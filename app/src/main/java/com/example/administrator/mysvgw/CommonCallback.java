package com.example.administrator.mysvgw;

import android.util.Log;

import com.example.administrator.mysvgw.bean.HttpResult;
import com.example.administrator.mysvgw.utils.CommonUtils;
import com.example.administrator.mysvgw.utils.GsonUtils;
import com.kili.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by whq on 2017/12/27.
 * 基础回调
 */

public abstract class CommonCallback<T> extends Callback<HttpResult<T>> {
    @Override
    public HttpResult parseNetworkResponse(Response response) throws Exception {
        HttpResult result = new HttpResult();
        String body = response.body().string();
        Log.d("zybody", "result==" + body);
        JSONObject jsonObject;

        try {
            jsonObject = new JSONObject(body);
            String data = jsonObject.optString("data");
            if(!CommonUtils.isEmpty(data)){
                if(data.startsWith("{")){
                    Type getType = getClass().getGenericSuperclass();
                    Type[] params = ((ParameterizedType)getType).getActualTypeArguments();
                    result = GsonUtils.fromJsonObject(new StringReader(body), (Class) params[0]);
                }else if(data.startsWith("[")){
                    Type genType = getClass().getGenericSuperclass();
                    Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
                    result = GsonUtils.fromJsonArray(new StringReader(body), params[0]);
                }
                if(result.isTokenInvalid()){
                    MyApplication.getInstance().logout();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }


}

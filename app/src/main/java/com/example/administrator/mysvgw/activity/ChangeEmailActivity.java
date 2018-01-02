package com.example.administrator.mysvgw.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mysvgw.Api;
import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.CommonCallback;
import com.example.administrator.mysvgw.MyApplication;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.bean.HttpResult;
import com.example.administrator.mysvgw.utils.CommonUtils;
import com.kili.okhttp.OkHttpUtils;

import java.util.HashMap;

import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by whq on 2018/1/2.
 */

public class ChangeEmailActivity extends BaseActivity {
    EditText et_change_em_pws, et_change_em;
    TextView tv_title;

    @Override
    protected int getContetView() {
        return R.layout.activity_change_email;
    }

    @Override
    protected void initViews() {
        setImmerseLayout(findViewById(R.id.rl_set), true);
        tv_title = getView(R.id.tv_title);
        et_change_em_pws = getView(R.id.et_change_em_pws);//当前密码
        et_change_em = getView(R.id.et_change_em);//邮箱
    }

    @Override
    protected void initData() {
        tv_title.setText("修改电子邮箱");
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.iv_left, R.id.tv_em_save})
    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_em_save:
                saveEmiage();
                break;
            default:
                break;
        }
    }

    private void saveEmiage() {
        String pws = et_change_em_pws.getText().toString().trim();
        String email = et_change_em.getText().toString().trim();
        if(CommonUtils.isEmpty(pws)){
            CommonUtils.toast(mContext,"密码不能为空！");
            return;
        }
        if(CommonUtils.isEmpty(email)){
            CommonUtils.toast(mContext, "邮箱地址不能为空!");
            return;
        }
        String url = Api.URL_MODIFY_EMAIL;
        HashMap<String, String> params = new HashMap<>();
        params.put("token", MyApplication.getInstance().getLoginKey());
        params.put("password", pws);
        params.put("email", email);
        OkHttpUtils.post().url(url).build().execute(new CommonCallback<Object>() {

            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                loadingDialogs("");
            }

            @Override
            public void onAfter() {
                super.onAfter();
                cancelLoadingDialog();
            }

            @Override
            public void onError(Call call, Exception e) {
                CommonUtils.toast(mContext,"网络链接失败，请重试！");
            }

            @Override
            public void onResponse(HttpResult<Object> response) {
                if(response.isSuccess()){
                    if(response.msg != null){
                        CommonUtils.toast(mContext, response.msg);
                    }
                    finish();
                }
            }
        });
    }
}

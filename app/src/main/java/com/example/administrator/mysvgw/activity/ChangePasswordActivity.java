package com.example.administrator.mysvgw.activity;

import android.view.MotionEvent;
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
 * 修改密码页
 */

public class ChangePasswordActivity extends BaseActivity {

    EditText et_change_cur_pws, et_change_new_pws, et_change_again_pws;
    TextView tv_pws_save, tv_title;

    @Override
    protected int getContetView() {
        return R.layout.activity_changps;
    }

    @Override
    protected void initViews() {
        setImmerseLayout(findViewById(R.id.rl_set), true);
        tv_title = getView(R.id.tv_title);
        et_change_cur_pws = getView(R.id.et_change_cur_pws);//当前密码
        et_change_new_pws = getView(R.id.et_change_new_pws);//新密码
        et_change_again_pws = getView(R.id.et_change_again_pws);//再次确认
        tv_pws_save = getView(R.id.tv_pws_save);//保存修改

    }

    @Override
    protected void initData() {
        tv_title.setText("修改密码");
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.tv_pws_save, R.id.iv_left})
    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_pws_save:
                saveChange();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            if (CommonUtils.isShouldHideInput(view, ev)) {
                CommonUtils.hintSoftKeyboard(this);
            }
            return super.dispatchTouchEvent(ev);
        }
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);

    }

    private void saveChange() {
        String curpws = et_change_cur_pws.getText().toString().trim();
        String newpws = et_change_new_pws.getText().toString().trim();
        String againpws = et_change_again_pws.getText().toString().trim();
        if(CommonUtils.isEmpty(curpws)){
            CommonUtils.toast(mContext, "当前密码不能为空");
            return;
        }
        if(CommonUtils.isEmpty(newpws)){
            CommonUtils.toast(mContext, "新密码不能为空");
            return;
        }
        if(CommonUtils.isEmpty(againpws)){
            CommonUtils.toast(mContext, "确认密码不能为空");
            return;
        }
        if(curpws.equals(newpws)){
            CommonUtils.toast(mContext, "新密码不能和旧密码一样");
            return;
        }
        if(!newpws.equals(againpws)){
            CommonUtils.toast(mContext, "两次密码不一致");
            return;
        }
        String url = Api.URL_MODIFY_PWD;
        HashMap<String, String> map = new HashMap<>();
        map.put("token", MyApplication.getInstance().getLoginKey());
        map.put("oldpassword", curpws);
        map.put("password", newpws);
        map.put("repassword", againpws);

        OkHttpUtils.post().url(url).params(map).build().execute(new CommonCallback<Object>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                loadingDialogs("");
            }

            @Override
            public void onError(Call call, Exception e) {
                CommonUtils.toast(mContext, "网络链接失败！");
            }

            @Override
            public void onResponse(HttpResult<Object> response) {
                if(response.isSuccess()){
                    if(response.msg != null){
                        CommonUtils.toast(mContext, response.msg);
                        MyApplication.getInstance().setLoginKey("");
                        finish();
                    }
                }
            }

            @Override
            public void onAfter() {
                super.onAfter();
                cancelLoadingDialog();
            }
        });

    }
}

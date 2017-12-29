package com.example.administrator.mysvgw.activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mysvgw.Api;
import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.CommonCallback;
import com.example.administrator.mysvgw.MyApplication;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.bean.HttpResult;
import com.example.administrator.mysvgw.bean.UserBean;
import com.example.administrator.mysvgw.utils.CommonUtils;
import com.kili.okhttp.OkHttpUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;

/**
 * 登陆页面
 * Created by whq on 2017/12/27.
 * 点击EditText其他位置，软键盘隐藏
 */

public class LoginActivity extends BaseActivity {

    TextView tv_title;//标题
    CheckBox cb_login_save;//选中
    EditText et_login_name;//账号
    EditText et_login_pwd;//密码

    @Override
    protected int getContetView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        tv_title = getView(R.id.tv_title);
        et_login_name = getView(R.id.et_login_name);
        et_login_pwd = getView(R.id.et_login_pwd);
        cb_login_save = getView(R.id.cb_login_save);
    }

    @Override
    protected void initData() {
        tv_title.setText("会员登陆");
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.iv_left, R.id.tv_login_register_2, R.id.tv_login_find_pwd, R.id.bt_login_ok})
    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_login_register_2:
                //注册
                startActivity(new Intent(mContext,RegisterActivity.class ));
                finish();
                break;
            case R.id.tv_login_find_pwd:
                //找回密码
                startActivity(new Intent(mContext, ForgotPasswordActivity.class));
                break;
            case R.id.bt_login_ok:
                //登陆
                login();
                break;
            default:
                break;
        }
    }

    /**
     * 点击其他地方隐藏软键盘
     *
     * @param
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            if (CommonUtils.isShouldHideInput(view, ev)) {
                //是否点击的是EditText。返回true，非EditText
                CommonUtils.hintSoftKeyboard(LoginActivity.this);
            }
            return super.dispatchTouchEvent(ev);
        }
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    private void login(){
        String name  = et_login_name.getText().toString().trim();
        String password = et_login_pwd.getText().toString().trim();
        if(CommonUtils.isEmpty(name)){
            CommonUtils.toast(mContext,"请输入用户名！");
            return;
        }
        if(CommonUtils.isEmpty(password)){
            CommonUtils.toast(mContext, "请输入密码！");
            return;
        }
        boolean isSevenDay = cb_login_save.isChecked();
        String url = Api.URL_LOGIN;
        final HashMap<String, String> map = new HashMap<>();
        map.put("user", name);
        map.put("pwd", password);
        map.put("free_landing", isSevenDay ? "1" : "0");
        OkHttpUtils.post().url(url).params(map).build().execute(new CommonCallback<UserBean>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                weixinDialogInit(getString(R.string.dialog_process));
            }

            @Override
            public void onError(Call call, Exception e) {
                CommonUtils.toast(mContext,"网络未连通，请检查网络");
            }

            @Override
            public void onResponse(HttpResult<UserBean> response) {
                if(response.isSuccess()){
                    setResult(RESULT_OK);
                    MyApplication.getInstance().setLoginKey(response.data.token);
                    CommonUtils.hintSoftKeyboard(LoginActivity.this);
                    finish();
                }
                if(!CommonUtils.isEmpty(response.msg)){
                    CommonUtils.toast(mContext, response.msg);
                }
            }

            @Override
            public void onAfter() {
                super.onAfter();
                cancelWeiXinDialog();
            }
        });

    }
























}

package com.example.administrator.mysvgw.activity;

import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mysvgw.Api;
import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.CommonCallback;
import com.example.administrator.mysvgw.Constant;
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
 * 修改手机号
 */

public class ChangePhomeActivity extends BaseActivity {

    EditText et_phone_pws, et_phone_new, et_phone_code;
    TextView tv_phone_ma, tv_title;

    @Override
    protected int getContetView() {
        return R.layout.activity_change_phone;
    }

    @Override
    protected void initViews() {
        tv_title = getView(R.id.tv_title);
        et_phone_pws = getView(R.id.et_phone_pws);//当前密码
        et_phone_new = getView(R.id.et_phone_new);//新手机号
        et_phone_code = getView(R.id.et_phone_code);//验证码
        tv_phone_ma = getView(R.id.tv_phone_ma);//btn

    }

    @Override
    protected void initData() {
        tv_title.setText("修改手机号");
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.iv_left, R.id.tv_phone_ma, R.id.tv_phone_save})
    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_phone_ma:
                //获取验证码
                sendCode();
                break;
            case R.id.tv_phone_save:
                //保存
                savePhone();
                break;
            default:
                break;
        }

    }

    /**
     * 获取验证码
     */
    String pws, phone, code;

    private boolean getCode() {
        boolean result = true;

        pws = et_phone_pws.getText().toString().trim();
        phone = et_phone_new.getText().toString().trim();
        code = et_phone_code.getText().toString().trim();
        if (CommonUtils.isEmpty(pws)) {
            CommonUtils.toast(mContext, "请输入密码");
            return false;
        }
        if (CommonUtils.isEmpty(phone) || phone.length() != 11) {
            CommonUtils.toast(mContext, "请输入正确的手机号");
            return false;
        }
        if (CommonUtils.isEmpty(code)) {
            CommonUtils.toast(mContext, "请输入验证码");
            return false;
        }

        return result;
    }

    /**
     * 请求验证码
     */

    private void sendCode() {
        pws = et_phone_pws.getText().toString().trim();
        phone = et_phone_new.getText().toString().trim();
        code = et_phone_code.getText().toString().trim();
        if (CommonUtils.isEmpty(pws)) {
            CommonUtils.toast(mContext, "请输入密码");
            return;
        }
        if (CommonUtils.isEmpty(phone) || phone.length() != 11) {
            CommonUtils.toast(mContext, "请输入正确的手机号");
            return;
        }
        String url = Api.URL_SEND_CODE;
        final HashMap<String, String> map = new HashMap<>();
        map.put("from", "changemobile");
        map.put("mobile", phone);
        map.put("password", pws);
        OkHttpUtils.post().params(map).url(url).build().execute(new CommonCallback<Object>() {
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
                CommonUtils.toast(mContext, "网络链接失败！");
            }

            @Override
            public void onResponse(HttpResult<Object> response) {
                    if (response.msg != null) {
                        CommonUtils.toast(mContext, response.msg);
                        countDownTimer.start();
                }
            }
        });
    }

    /**
     * 保存修改
     */
    private void savePhone() {
        if (!getCode()) {
            return;
        }
        String url = Api.URL_MODIFY_PHONE;
        final HashMap<String, String> map = new HashMap<>();
        map.put("token", MyApplication.getInstance().getLoginKey());
        map.put("password", pws);
        map.put("phone", phone);
        map.put("code", code);
        OkHttpUtils.post().url(url).build().execute(new CommonCallback<Object>() {

            @Override
            public void onError(Call call, Exception e) {
                CommonUtils.toast(mContext, "网络连接失败！");
            }

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
            public void onResponse(HttpResult<Object> response) {
                    if (response.msg != null) {
                        CommonUtils.toast(mContext, response.msg);
                        finish();
                }
            }


        });

    }

    /**
     * 验证码计时器
     * CountDownTimer(再次发送时常，读秒间隔)
     */
    private CountDownTimer countDownTimer = new CountDownTimer(Constant.SEND_CODE_TIME, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //读秒后不可点击
            tv_phone_ma.setEnabled(false);
            //随时变换时间
            tv_phone_ma.setText(millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish() {
            tv_phone_ma.setEnabled(true);
            tv_phone_ma.setText("获取验证码");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }

    /**
     * 点击其余处，隐藏软键盘
     */
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
}

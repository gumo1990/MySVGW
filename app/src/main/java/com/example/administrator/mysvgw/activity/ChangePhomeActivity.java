package com.example.administrator.mysvgw.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.R;

import butterknife.OnClick;

/**
 * Created by whq on 2018/1/2.
 * 修改手机号
 */

public class ChangePhomeActivity extends BaseActivity {

    EditText et_phone_pws, et_phone_new, et_phone_code;
    TextView tv_phone_ma;

    @Override
    protected int getContetView() {
        return R.layout.activity_change_phone;
    }

    @Override
    protected void initViews() {
        et_phone_pws = getView(R.id.et_phone_pws);//当前密码
        et_phone_new = getView(R.id.et_phone_new);//新手机号
        et_phone_code = getView(R.id.et_phone_code);//验证码
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.tv_phone_ma, R.id.tv_phone_save})
    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_phone_ma:
                //获取验证码
                break;
            case R.id.tv_phone_save:
                //保存

                break;
            default:
                break;
        }

    }
    /**
     * 获取验证码
     */
    private void getCode(){

    }

    /**
     * 保存修改
     */
    private void savePhone(){
        String  pws = et_phone_pws.getText().toString().trim();
        String phone = et_phone_new.getText().toString().trim();
        String code  = et_phone_code.getText().toString().trim();

    }
}

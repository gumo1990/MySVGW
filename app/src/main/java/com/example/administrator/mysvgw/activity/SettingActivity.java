package com.example.administrator.mysvgw.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.MyApplication;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.utils.CommonUtils;

import butterknife.OnClick;

/**
 * Created by whq on 2017/12/29.
 * 用户设置页面
 */

public class SettingActivity extends BaseActivity {

    TextView tv_title, tv_person_new, tv_person_chp, tv_person_chem,
            tv_person_chphone, tv_settings_logout;

    @Override
    protected int getContetView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViews() {
        tv_title = getView(R.id.tv_title);//title
        tv_person_new = getView(R.id.tv_person_new);//基本信息
        tv_person_chp = getView(R.id.tv_person_chp);//修改密码
        tv_person_chem = getView(R.id.tv_person_chem);//修改电子邮箱
        tv_person_chphone = getView(R.id.tv_person_chphone);//修改手机号
        tv_settings_logout = getView(R.id.tv_settings_logout);//退出当前用户
    }

    @Override
    protected void initData() {
        tv_title.setText("用户设置");
    //   CommonUtils.myStatusBar(this, R.color.red);// 在根布局加属性android:fitsSystemWindows="true"
        setImmerseLayout(findViewById(R.id.rl_set), true);//在actionbar布局设id
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.iv_left, R.id.tv_person_new, R.id.tv_person_chp, R.id.tv_person_chem,
            R.id.tv_person_chphone, R.id.tv_settings_logout})
    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_person_new:
                //个人信息
                if (CommonUtils.checkLogin(this)) {
                    startActivity(new Intent(mContext, PersonBaseActivity.class));
                }
                break;
            case R.id.tv_person_chp:
                //修改密码
                if (CommonUtils.checkLogin(this)) {
                    startActivity(new Intent(mContext, ChangePasswordActivity.class));
                }
                break;
            case R.id.tv_person_chem:
                //修改邮箱
                if(CommonUtils.checkLogin(this)){
                    startActivity(new Intent(mContext, ChangeEmailActivity.class));
                }
                break;
            case R.id.tv_person_chphone:
                //修改手机号
                if(CommonUtils.checkLogin(this)){
                    startActivity(new Intent(mContext, ChangePhomeActivity.class));
                }
                break;
            case R.id.tv_settings_logout:
                MyApplication.getInstance().setLoginKey("");
                startActivity(new Intent(mContext, LoginActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (CommonUtils.isLogin()) {
            tv_settings_logout.setVisibility(View.VISIBLE);
        } else {
            tv_settings_logout.setVisibility(View.GONE);
        }
    }
}

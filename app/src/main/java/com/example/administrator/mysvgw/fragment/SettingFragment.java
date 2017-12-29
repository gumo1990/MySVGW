package com.example.administrator.mysvgw.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mysvgw.BaseFragment;
import com.example.administrator.mysvgw.MyApplication;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.activity.LoginActivity;
import com.example.administrator.mysvgw.utils.CommonUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by whq on 2017/12/29.
 * 用户设置页面
 */

public class SettingFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int getContentView() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initViews() {
        tv_title.setText("用户设置");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.iv_left, R.id.tv_person_new, R.id.tv_person_chp, R.id.tv_person_chem,
            R.id.tv_person_chphone, R.id.tv_settings_logout})
    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                getActivity().finish();
                break;
            case R.id.tv_person_new:
                if(CommonUtils.checkLogin(getActivity())){

                }
                break;
            case R.id.tv_person_chp:

                break;
            case R.id.tv_person_chem:

                break;
            case R.id.tv_person_chphone:

                break;
            case R.id.tv_settings_logout:
                MyApplication.getInstance().logout();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
                break;
            default:
                break;

        }
    }
}

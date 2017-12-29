package com.example.administrator.mysvgw.fragment;

import android.content.Intent;
import android.view.View;

import com.example.administrator.mysvgw.BaseFragment;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.activity.LoginActivity;
import com.example.administrator.mysvgw.utils.CommonUtils;

import butterknife.OnClick;

import static com.example.administrator.mysvgw.utils.CommonUtils.isLogin;

/**
 * Created by whq on 2017/12/26.
 */

public class PersonFragment extends BaseFragment {
    @Override
    protected int getContentView() {
        return R.layout.fragment_my;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_personal_login})
    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.ll_personal_login:
                if (isLogin()) {
                //    enterImgSelector();
                    break;
                }
                startActivity(new Intent(getContext(), LoginActivity.class));
            default:
                break;
        }
    }
}

package com.example.administrator.mysvgw.activity;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.fragment.CarFragment;
import com.example.administrator.mysvgw.fragment.CategoryFragment;
import com.example.administrator.mysvgw.fragment.HomeFragment;
import com.example.administrator.mysvgw.fragment.MyFragment;
import com.example.administrator.mysvgw.fragment.VideoFragment;
import com.example.administrator.mysvgw.utils.CommonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by whq on 2017/12/25.
 * 添加注解
 * compile 'com.jakewharton:butterknife:8.5.1'
 * annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'--添加注解
 * 在onCreate中先绑定
 * unbinder = ButterKnife.bind(this);
 * 销毁时候要解绑
 * unbinder.unbind();
 */

public class MainActivity extends BaseActivity {

    Unbinder bind;

    private FragmentManager fragmentManager;
    final int HOME = 1;
    final int CATEGORY = 2;
    final int VIDEO = 3;
    final int CAR = 4;
    final int MYPERSON = 5;
    private static boolean isExit = false;
    private boolean isHome;
    HomeFragment homeFragment;
    CategoryFragment categoryFragment;
    VideoFragment videoFragment;
    CarFragment carFragment;
    MyFragment myFragment;
    @BindView(R.id.rb_home)
    RadioButton rb_home;

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        bind = ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void initData() {
        showFragment(HOME);
    }

    private void showFragment(int home) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (home) {
            case HOME:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fl_main, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                isHome = true;
                break;
            case CATEGORY:
                if (categoryFragment == null) {
                    categoryFragment = new CategoryFragment();
                    transaction.add(R.id.fl_main, categoryFragment);
                } else {
                    transaction.show(categoryFragment);
                }
                break;
            case VIDEO:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.fl_main, videoFragment);
                } else {
                    transaction.show(videoFragment);
                }
                break;
            case CAR:
                if (carFragment == null) {
                    carFragment = new CarFragment();
                    transaction.add(R.id.fl_main, carFragment);
                } else {
                    transaction.show(carFragment);
                }
                break;
            case MYPERSON:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.fl_main, myFragment);
                } else {
                    transaction.show(myFragment);
                }
                break;
            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFragment(FragmentTransaction transaction) {
        isHome = false;
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (categoryFragment != null) {
            transaction.hide(categoryFragment);
        }
        if (videoFragment != null) {
            transaction.hide(videoFragment);
        }
        if (carFragment != null) {
            transaction.hide(carFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.rb_home, R.id.rb_category, R.id.rb_video, R.id.rb_cart, R.id.rb_my})
    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.rb_home:
                showFragment(HOME);
                break;
            case R.id.rb_category:
                showFragment(CATEGORY);
                break;
            case R.id.rb_video:
                showFragment(VIDEO);
                break;
            case R.id.rb_cart:
                showFragment(CAR);
                break;
            case R.id.rb_my:
                showFragment(MYPERSON);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isHome) {
                exit();
            } else {
                rb_home.setChecked(true);
                showFragment(HOME);

            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            CommonUtils.toast(mContext, "再按一次退出程序");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {
            finish();
        }
    }
}

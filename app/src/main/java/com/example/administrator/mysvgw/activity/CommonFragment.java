package com.example.administrator.mysvgw.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.fragment.SettingFragment;

/**
 * Created by whq on 2017/12/29.
 */

public class CommonFragment extends BaseActivity {

    public static final String TARGET = "target";

    public static final int FRAGMENT_SETTINGS = 1; //设置
    public static final int FRAGMENT_SETTINGS_MODIFY_EMAIL = 2; //修改邮箱
    public static final int FRAGMENT_SETTINGS_MODIFY_PHONE = 3; // 修改手机
    public static final int FRAGMENT_SETTINGS_MODIFY_PWD = 4; //修改密码
    public static final int FRAGMENT_SETTINGS_BASE_INFO = 5; //基本信息
    public static final int FRAGMENT_FAVORITE_GOODS = 6; //商品收藏
    public static final int FRAGMENT_INTEGRAL = 7; //会员积分
    public static final int FRAGMENT_FORGOT_PWD = 8; //忘记密码
    public static final int FRAGMENT_FORGOT_PWD_SET = 9; //忘记密码 设置密码
    public static final int FRAGMENT_BIND_PHONE = 10; //绑定手机号
    public static final int FRAGMENT_SEARCH = 11; //搜索
    public static final int FRAGMENT_ORDER_COMMENT = 12; //订单评价
    public static final int FRAGMENT_ORDER_COMMENT_GOODS = 13; //商品评价
    public static final int FRAGMENT_SPREED = 14; //优惠大礼包
    public static final int FRAGMENT_DO_RULE = 15; //使用规则
    public static final int FRAGMENT_USE_DIS = 16; //优惠券使用
    public static final int FRAGMENT_MYHOME = 20;
    public static final int FRAGMENT_USE_COUPONS = 21;
    public static final int FRAGMENT_USE = 22; //使用优惠券
    public static final int FRAGMENT_MESSAGE_SETTING = 24; //消息设置
    public static final int FRAGMENT_STORE = 25; //店铺
    public static final int FRAGMENT_REBATE = 26; //我的返利
    public static final int FRAGMENT_LOOK = 27; //查看佣金
    public static final int FRAGMENT_APPLY = 28; //提现申请
    public static final int FRAGMENT_NOTES = 29; //提现记录

    FragmentManager manager;
    android.support.v4.app.FragmentTransaction transaction;

    @Override
    protected int getContetView() {
        return R.layout.activity_fragment_common;
    }

    @Override
    protected void initViews() {
        int target = getIntent().getIntExtra(TARGET, -1);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        Fragment fragment = null;
        switch (target) {
            case FRAGMENT_SETTINGS:
                fragment = new SettingFragment();
                break;

            default:
                break;
        }
        transaction.add(R.id.fl_common_fragment, fragment);
        transaction.commit();


    }

    @Override
    protected void initData() {

    }

    @Override
    public void initListener() {

    }


    @Override
    public void proClick(View view) {

    }
}

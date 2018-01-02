package com.example.administrator.mysvgw.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.mysvgw.Api;
import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.CommonCallback;
import com.example.administrator.mysvgw.MyApplication;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.bean.HttpResult;
import com.example.administrator.mysvgw.bean.UserBean;
import com.example.administrator.mysvgw.utils.CommonUtils;
import com.example.administrator.mysvgw.utils.DateTimePickDialogUtils;
import com.kili.okhttp.OkHttpUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by whq on 2018/1/2.
 */

public class PersonBaseActivity extends BaseActivity {

    TextView tv_title, tv_perosn_data;
    EditText et_person_name;
    RadioButton rb_person_man, rb_person_woman;

    @Override
    protected int getContetView() {
        return R.layout.activity_person_base;
    }

    @Override
    public void initViews() {
        CommonUtils.myStatusBar(this, R.color.white);
        tv_title = getView(R.id.tv_title);
        et_person_name = getView(R.id.et_person_name);//姓名
        rb_person_man = getView(R.id.rb_person_man);
        rb_person_woman = getView(R.id.rb_person_woman);
        tv_perosn_data = getView(R.id.tv_perosn_data);//出生日期
        getBaseInfo();
    }

    @Override
    public void initData() {
        tv_title.setText("个人资料");
        setLoadingDialog(true);
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.iv_left, R.id.tv_perosn_data, R.id.tv_person_save})

    @Override
    public void proClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_perosn_data:
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                String currentDate = format.format(curDate);
                new DateTimePickDialogUtils(PersonBaseActivity.this, currentDate).show(new DateTimePickDialogUtils.DataPickCallback() {
                    @Override
                    public void onPositive(String date) {
                        tv_perosn_data.setText(date);
                    }

                    @Override
                    public void onNegative() {

                    }
                });
                break;
            case R.id.tv_person_save:
                //保存修改
                saveInfo();
                break;
            default:
                break;
        }
    }

    /**
     * 点击其他地方关闭软键盘
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

    private void getBaseInfo() {
        String url = Api.URL_USER_BASE_INFO;
        HashMap<String, String> map = new HashMap<>();
        map.put("token", MyApplication.getInstance().getLoginKey());
        OkHttpUtils.post().url(url).params(map).build().execute(new CommonCallback<UserBean>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                loadingDialogs("加载中...");
            }

            @Override
            public void onError(Call call, Exception e) {
                CommonUtils.toast(mContext, "网络未连接，请检查网络！");
            }

            @Override
            public void onResponse(HttpResult<UserBean> response) {
                if (response.isSuccess()) {
                    if (response.data != null) {
                        fillData(response.data);
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

    /**
     * 填充数据
     *
     * @param data
     */
    private void fillData(UserBean data) {
        if (data.getUserName() != null) {
            et_person_name.setText(data.getUserName());
        }
        if (data.getBirthday() != null) {
            tv_perosn_data.setText(data.getBirthday() + "");
        }
        if (data.getSex() == 1) {
            rb_person_man.setChecked(true);
        } else {
            rb_person_woman.setChecked(true);
        }
    }

    /**
     * 保存修改
     */
    private void saveInfo() {
        String url = Api.URL_USER_BASE_SAVEINFO;
        String name = et_person_name.getText().toString().trim();
        String data = tv_perosn_data.getText().toString().trim();
        int sex = 1;
        if (rb_person_woman.isChecked()) {
            sex = 2;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("token", MyApplication.getInstance().getLoginKey());
        if (!CommonUtils.isEmpty(name)) {
            map.put("realName", name);
        }
        if (!CommonUtils.isEmpty(data)) {
            map.put("birthday", data);
        }
        map.put("gender", sex + "");
        OkHttpUtils.post().url(url).params(map).build().execute(new CommonCallback<UserBean>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                loadingDialogs("加载中...");
            }

            @Override
            public void onError(Call call, Exception e) {
                CommonUtils.toast(mContext, "网络未连接，请检查！");
            }

            @Override
            public void onResponse(HttpResult<UserBean> response) {
                if (response.isSuccess()) {
                    if (!CommonUtils.isEmpty(response.msg)) {
                        CommonUtils.toast(mContext, response.msg);
                        finish();
                    }
                }
            }


        });
    }
}
package com.example.administrator.mysvgw.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.mysvgw.Api;
import com.example.administrator.mysvgw.BaseFragment;
import com.example.administrator.mysvgw.CommonCallback;
import com.example.administrator.mysvgw.MyApplication;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.activity.LoginActivity;
import com.example.administrator.mysvgw.activity.SettingActivity;
import com.example.administrator.mysvgw.bean.HttpResult;
import com.example.administrator.mysvgw.bean.UserCenter;
import com.example.administrator.mysvgw.utils.CommonUtils;
import com.kili.okhttp.OkHttpUtils;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.loader.ImageLoader;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;

import static com.example.administrator.mysvgw.utils.CommonUtils.isLogin;

/**
 * Created by whq on 2017/12/26.
 * 图片加载，添加
 * compile 'com.github.bumptech.glide:glide:4.0.0-RC0'
 * compile 'com.github.bumptech.glide:compiler:4.0.0-RC0'
 * compile 'com.github.bumptech.glide:okhttp3-integration:4.0.0-RC0'
 */

public class PersonFragment extends BaseFragment {
    public static final int UPDATE_AVATAR = 2008;

    @BindView(R.id.iv_personal_avatar)
    ImageView iv_personal_avatar;//头像
    @BindView(R.id.tv_personal_name)
    TextView tv_personal_name;//姓名

    @Override
    protected int getContentView() {
        return R.layout.fragment_my;
    }

    @Override
    public void initViews() {
        initImagePicker();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_personal_login, R.id.iv_personal_settings})
    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.ll_personal_login:
                if (isLogin()) {
                    //如果登陆了，就去设置头像
                    enterImgSelector();
                    return;
                }
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.iv_personal_settings:
                //设置页面
                startActivity(new Intent(getContext(), SettingActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * 图片回调
     */
    private void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
                Glide.with(activity).load(path).into(imageView);
            }

            @Override
            public void clearMemoryCache() {

            }
        });
        imagePicker.setShowCamera(true);                      //显示拍照按钮
        imagePicker.setMultiMode(false);
        imagePicker.setCrop(true);                           //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true);                   //是否按矩形区域保存
        imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状

        //预览宽度为屏幕的2/3
        int width = CommonUtils.getScreenWidth(getContext()) * 2 / 3;
        if (width < 300) width = 300;

        imagePicker.setFocusWidth(width);                       //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(width);                      //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(200);                         //保存文件的宽度。单位像素
        imagePicker.setOutPutY(200);                         //保存文件的高度。单位像素
    }


    /**
     * 选择头像
     */
    private void enterImgSelector() {
        startActivityForResult(new Intent(getActivity(), ImageGridActivity.class), UPDATE_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == ImagePicker.RESULT_CODE_ITEMS){
            if (data != null && requestCode == UPDATE_AVATAR) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                ImageItem imageItem = images.get(0);
                uploadPortrait(imageItem);
            }

        }

    }
    /**
     *  上传头像
     */
    private void uploadPortrait(final ImageItem imageItem) {
        String url = Api.URL_UPLOAD_AVATAR;
        HashMap<String, String> params = new HashMap<>();
        params.put("token", MyApplication.getInstance().getLoginKey());
        File file = new File(imageItem.path);
        if (!file.exists()) {
            CommonUtils.toast(getContext(),"头像文件不存在");
            return;
        }
        OkHttpUtils.post().addFile("headImg", System.currentTimeMillis() + ".jpg", file).url(url).params(params).build().execute(new CommonCallback<Object>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
            }

            @Override
            public void onAfter() {
                super.onAfter();
            }

            @Override
            public void onError(Call call, Exception e) {
                CommonUtils.toast(getContext(), "上传头像失败，请检查网络！");
            }

            @Override
            public void onResponse(HttpResult response) {

                try {
                    if (!CommonUtils.isEmpty(response.msg))
                        CommonUtils.toast(getContext(),response.msg);

                    if (response.isSuccess()) {

                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getPersonImage();
                            }
                        }, 500);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();
        //获取头像信息
        getPersonImage();
    }

    /**
     * 获取头像信息
     */
    private void getPersonImage() {
        if (CommonUtils.isEmpty(MyApplication.getInstance().getLoginKey())) {
            iv_personal_avatar.setImageResource(R.drawable.ic_mine_avatar1);
            tv_personal_name.setText("点击登陆");
            return;
        }
        String url = Api.URL_USER_CENTER;
        HashMap<String, String> map = new HashMap<>();
        map.put("token", MyApplication.getInstance().getLoginKey());
        OkHttpUtils.post().url(url).params(map).build().execute(new CommonCallback<UserCenter>() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(HttpResult<UserCenter> response) {
                if (response.data != null) {
                    if (response.data.getPortrait() != null) {
                        Glide.with(getActivity()).asBitmap().load(response.data.getPortrait())
                                .apply(new RequestOptions().error(R.drawable.ic_mine_avatar1))
                                .into(new BitmapImageViewTarget(iv_personal_avatar) {
                                    @Override
                                    protected void setResource(Bitmap resource) {
                                        super.setResource(resource);
                                        if (resource != null) {
                                            iv_personal_avatar.setImageDrawable(CommonUtils
                                                    .createRoundImageWithBorder(resource, getContext()));
                                        }
                                    }
                                });
                    }
                    if (response.data.getUserName() != null) {
                        tv_personal_name.setText(response.data.getUserName());
                    }
                }
            }


        });
    }
}

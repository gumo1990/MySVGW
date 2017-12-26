package com.example.administrator.mysvgw.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.mysvgw.BaseActivity;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.adapter.GuideAdapter;
import com.example.administrator.mysvgw.utils.CommonUtils;

import java.util.ArrayList;

/**
 * Created by whq on 2017/12/25.
 */

public class GuildActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private Button btn_guild;
    private LinearLayout llPointGroup;//点的父元素
    private int[] mImageIds = new int[]{
            R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private ArrayList<ImageView> mImageViews;

    private int mPointWidth;//小圆点距离
    private View mRedPoint;//小红点

    @Override
    protected int getContetView() {
        return R.layout.activity_guild;
    }

    @Override
    protected void initViews() {
        mViewPager = getView(R.id.vp_guide);
        btn_guild = getView(R.id.btn_guild);
        llPointGroup = getView(R.id.ll_point_group);
        mRedPoint = getView(R.id.view_red_point);

    }

    @Override
    protected void initData() {
        mImageViews = new ArrayList<>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(mImageIds[i]);
            mImageViews.add(image);
        }
        GuideAdapter adapter = new GuideAdapter(mContext, mImageViews);
        mViewPager.setAdapter(adapter);
        //填充小圆点
        for (int i = 0; i < mImageIds.length; i++) {
            View point = new View(this);
            point.setBackgroundResource(R.drawable.shape_normal);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    CommonUtils.dp2px(this, 10), CommonUtils.dp2px(this, 10));
            point.setLayoutParams(params);
            if (i != 0) {
                params.leftMargin = CommonUtils.dp2px(this, 10);
            }
            llPointGroup.addView(point);
        }
        //红点移动
        final ViewTreeObserver viewTreeObserver = llPointGroup.getViewTreeObserver();//视图树
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                llPointGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mPointWidth = llPointGroup.getChildAt(1).getLeft() - llPointGroup.getChildAt(0).getLeft();

            }
        });
    }

    @Override
    public void initListener() {
        mViewPager.setOnPageChangeListener(this);
        btn_guild.setOnClickListener(this);
    }


    @Override
    public void proClick(View view) {

        switch (view.getId()) {
            case R.id.btn_guild:
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int offset = (int) ((mPointWidth * positionOffset) + position * mPointWidth);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mRedPoint.getLayoutParams());
        params.leftMargin = offset;//设置红点左边距，使红点移动
        mRedPoint.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        if(position == mImageIds.length -1){
            btn_guild.setVisibility(View.VISIBLE);
        }else{
            btn_guild.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

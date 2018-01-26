package com.example.administrator.mysvgw.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.example.administrator.mysvgw.Api;
import com.example.administrator.mysvgw.BaseTopBarFragment;
import com.example.administrator.mysvgw.CommonCallback;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.activity.LoginActivity;
import com.example.administrator.mysvgw.adapter.CategoryLeftAdapter;
import com.example.administrator.mysvgw.adapter.CategoryRightAdapter;
import com.example.administrator.mysvgw.bean.CategoryBean;
import com.example.administrator.mysvgw.bean.HttpResult;
import com.example.administrator.mysvgw.views.FullyGridLayoutManager;
import com.example.administrator.mysvgw.views.LoadingPage;
import com.example.administrator.mysvgw.views.SimpleDividerDecoration;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.kili.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import okhttp3.Call;

import static com.example.administrator.mysvgw.views.LoadingPage.LOADING;
import static com.example.administrator.mysvgw.views.LoadingPage.LOADING_HINT;
import static com.example.administrator.mysvgw.views.LoadingPage.LOADING_NODATA;
import static com.example.administrator.mysvgw.views.LoadingPage.LOADING_NONET;
import static in.srain.cube.views.ptr.util.PtrLocalDisplay.dp2px;

/**
 * Created by whq on 2017/12/26.
 * 分类页面
 */

public class CategoryFragment extends BaseTopBarFragment {

    @BindView(R.id.xv_cate_left)
    XRecyclerView xv_cate_left;//左侧rv
    @BindView(R.id.cb_cate)
    ConvenientBanner cb_cate;//广告位
    @BindView(R.id.xv_cate_right)
    XRecyclerView xv_cate_right;//右侧rv
    /* @BindView(R.id.mPtrframe)
     PtrFrameLayout mPtrframe;//下拉刷新*/
    @BindView(R.id.loadpage)
    LoadingPage loadPage;//加载动画

    //写一个集合收录右侧数据
    HashMap<Integer, List<CategoryBean.BrandBean>> hmBrand = new HashMap();
    HashMap<Integer, List<CategoryBean.ChildrenBeanX>> hmChildrenBeanX = new HashMap();

    ArrayList<CategoryBean.BrandBean> brand = new ArrayList<>();
    ArrayList<CategoryBean.ChildrenBeanX> children = new ArrayList<>();

    CategoryLeftAdapter leftAdapter;
    CategoryRightAdapter rightAdapter;

    @Override
    protected int getContentView() {
        return R.layout.fragment_category;
    }

    @Override
    public void initViews() {
        loadPage.switchLoadingState(LOADING);
        mStatusBarView.setBackgroundResource(R.color.red);
        getCategoryInfo();

    }

    @Override
    public void initListener() {
        loadPage.setLoadinglistener(new LoadingPage.LoadingListener() {
            @Override
            public void onLoading() {
                loadPage.switchLoadingState(LOADING);
                //请求接口
                getCategoryInfo();
            }
        });
       /* final PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getContext());
        header.setPadding(0, 0, 0, 0);
        //        header.setPadding(dp2px(20), dp2px(20), 0, 0);
        mPtrframe.setHeaderView(header);
        mPtrframe.addPtrUIHandler(header);
        mPtrframe.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPtrframe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rightAdapter.notifyDataSetChanged();
                        mPtrframe.refreshComplete();
                    }
                }, 2000);
            }
        });*/
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.tv_cate_search})
    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cate_search:
                //顶部搜索
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * 获取分类页面信息
     */
    private void getCategoryInfo() {

        String url = Api.URL_CLASSIFY;
        OkHttpUtils.get().url(url).params(null).build().execute(new CommonCallback<List<CategoryBean>>() {


            @Override
            public void onError(Call call, Exception e) {
                loadPage.switchLoadingState(LOADING_NONET);
                Log.d("whq", "----" + e);
            }

            @Override
            public void onResponse(HttpResult<List<CategoryBean>> response) {
                if (response.isSuccess()) {

                    if (response.data != null && response.data.size() > 0) {
                        loadPage.switchLoadingState(LOADING_HINT);
                        fillLeftData(response.data);
                    } else {
                        loadPage.switchLoadingState(LOADING_NODATA);
                    }
                }
            }

        });
    }

    /**
     * 左侧数据
     *
     * @param data
     */
    private void fillLeftData(final List<CategoryBean> data) {
        leftAdapter = new CategoryLeftAdapter(getContext(), data);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        xv_cate_left.setPullRefreshEnabled(false);//没有下拉刷新，默认是有的
        xv_cate_left.setLayoutManager(manager);
        xv_cate_left.addItemDecoration(new SimpleDividerDecoration(getContext()));//自定义分割线
        xv_cate_left.setAdapter(leftAdapter);


        for (CategoryBean bean : data) {
            //将所有广告和子类数据放入map中，然后根据id名字取
            hmBrand.put(bean.getCateId(), bean.getBrand());
            hmChildrenBeanX.put(bean.getCateId(), bean.getChildren());
        }
        //右侧先默认展示第二条数据
        fillRightData(data.get(0).getCateId());
        if (leftAdapter != null) {
            leftAdapter.setmOnItemClickListener(new CategoryLeftAdapter.OnItemClickListener() {

                @Override
                public void onItemClick(View v, Integer tag) {
                    leftAdapter.setPosition(tag);
                    leftAdapter.notifyDataSetChanged();
                    fillRightData(data.get(tag).getCateId());
                }
            });
        }

    }

    /**
     * 右侧数据
     * 每次点击左侧item，就从新定义List，然后从Map集合中选找（position是之前存储的cateId）对应的数据
     *
     * @param position
     */
    private void fillRightData(int position) {
        if (xv_cate_right != null) {
            xv_cate_right.removeAllViews();
        }

        brand = (ArrayList<CategoryBean.BrandBean>) hmBrand.get(position);
        children = (ArrayList<CategoryBean.ChildrenBeanX>) hmChildrenBeanX.get(position);
        //顶部轮播图
        if (brand != null && brand.size() > 0) {
            cb_cate.setVisibility(View.VISIBLE);
            cb_cate.setPages(new CBViewHolderCreator<LocalImageHolderView>() {

                @Override
                public LocalImageHolderView createHolder() {
                    return new LocalImageHolderView();
                }
            }, brand);
            //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
            //.setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
            //设置指示器的方向
            cb_cate.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);

            if (brand.size() > 1) {
                //图片多于一张时候才轮播
                cb_cate.startTurning(3000);
                Log.d("whq", "----size" + brand.size());
                cb_cate.setManualPageable(true);
            } else {
                //只有一张图片时候不轮播
                cb_cate.stopTurning();
                //没有手动滑动控制
                cb_cate.setManualPageable(false);
                Log.d("whq", "----size-----" + brand.size());
            }
        } else {
            cb_cate.setVisibility(View.GONE);
        }
        FullyGridLayoutManager manager = new FullyGridLayoutManager(getContext(), 3);
        xv_cate_right.setLayoutManager(manager);
        xv_cate_right.setPullRefreshEnabled(false);
        xv_cate_right.setLoadingMoreEnabled(false);
        rightAdapter = new CategoryRightAdapter(getContext(), children);
        xv_cate_right.setAdapter(rightAdapter);
        rightAdapter.notifyDataSetChanged();

    }

    private class LocalImageHolderView implements Holder<CategoryBean.BrandBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, CategoryBean.BrandBean data) {
            Glide.with(getContext()).load(data.getBrandLogo()).into(imageView);
        }


    }
}

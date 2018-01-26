package com.example.administrator.mysvgw.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.bean.CategoryBean;

import java.util.List;

/**
 * Created by whq on 2018/1/5.
 * 分类页面右侧adapter
 */

public class CategoryRightAdapter extends RecyclerView.Adapter<CategoryRightAdapter.ItemViewHolder> {

    List<CategoryBean.ChildrenBeanX> mdata;
    Context mcontext;
    public CategoryRightAdapter(Context context, List<CategoryBean.ChildrenBeanX> data) {
        this.mdata = data;
        this.mcontext = context;
    }

    @Override
    public CategoryRightAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cate_rightad,null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryRightAdapter.ItemViewHolder holder, final int position) {
        CategoryBean.ChildrenBeanX childrenBeanX = mdata.get(position);
        String cateImg = childrenBeanX.getCateImg();
        Glide.with(mcontext).load(cateImg).into(holder.imageView);
        holder.textView.setText(childrenBeanX.getCateName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("whq","----"+position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

     class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_cate_right);
            textView = itemView.findViewById(R.id.tv_cate_right);
        }
    }





























}

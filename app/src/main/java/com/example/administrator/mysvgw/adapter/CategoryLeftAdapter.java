package com.example.administrator.mysvgw.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.bean.CategoryBean;

import java.util.List;

/**
 * Created by whq on 2018/1/5.
 */

public class CategoryLeftAdapter extends RecyclerView.Adapter<CategoryLeftAdapter.ItemViewHolder>
        implements View.OnClickListener {
    Context mContext;
    List<CategoryBean> mdata;
    private int mposition;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    public void setmOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void setPosition(int position) {
        this.mposition = position;
    }

    public static interface OnItemClickListener {
        void onItemClick(View v, Integer tag);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public CategoryLeftAdapter(Context mContext, List<CategoryBean> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cate_leftad, parent, false);
        //View.inflate(parent.getContext(), R.layout.activity_cate_leftad, null);这个方法布局需要再次调整
        view.setOnClickListener((View.OnClickListener) this);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoryLeftAdapter.ItemViewHolder holder, final int position) {
        CategoryBean bean = mdata.get(position);
        holder.tv_cate_left.setText(bean.getCateName());
        //setTag，设置记录标签
        holder.itemView.setTag(position);
        if(mposition == position){
            holder.imageView.setBackgroundResource(R.color.red);
        }else{
            holder.imageView.setBackgroundResource(R.color.white1);
        }

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_cate_left;

        ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_cate_left);
            tv_cate_left = itemView.findViewById(R.id.tv_cate_left);
        }
    }
}

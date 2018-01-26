package com.example.administrator.mysvgw.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.mysvgw.R;

/**
 * Created by whq on 2018/1/5.
 * RecyclerView自定义分割线
 * https://www.jianshu.com/p/b46a4ff7c10a
 */

public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight;
    private Paint dividerPaint;

    public SimpleDividerDecoration(Context context) {
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.white1));
        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
           /* if(i == 0  || i== childCount-2){

            }else{
                c.drawRect(left, top, right, bottom, dividerPaint);
            }*/
            if (i == 0) {

            } else {
                c.drawRect(left, top, right, bottom, dividerPaint);
            }

        }
    }
}

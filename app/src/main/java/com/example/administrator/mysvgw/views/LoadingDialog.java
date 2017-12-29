package com.example.administrator.mysvgw.views;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mysvgw.R;

/**
 * Created by whq on 2017/12/27.
 */

public class LoadingDialog extends ProgressDialog {
    private TextView tv;
    private Context context;
    String msg = "";

    public LoadingDialog(Context context) {
        super(context, R.style.loadingDialogStyle);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loading_dialog);
        tv = (TextView) this.findViewById(R.id.tv);
        tv.setText(msg);
        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.LinearLayout);
        linearLayout.getBackground().setAlpha(210);
    }

    public void setShowMsg(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            this.msg = msg;
        } else {
            this.msg = context.getString(R.string.dialog_process);
        }
    }
}

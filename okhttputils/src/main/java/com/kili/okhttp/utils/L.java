package com.kili.okhttp.utils;

import android.util.Log;

/**
 * Created by zhy on 15/11/6.
 */
public class L
{
    private static boolean debug = true;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("whq", "url-----"+msg);
        }
    }

}


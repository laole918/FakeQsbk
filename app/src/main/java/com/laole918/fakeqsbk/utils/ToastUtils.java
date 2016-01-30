package com.laole918.fakeqsbk.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.laole918.fakeqsbk.R;

/**
 * Created by laole918 on 2016/1/30.
 */
public class ToastUtils {

    public static void show(Context context, int resId, int duration) {
        CharSequence text = context.getText(resId);
        show(context, text, duration);
    }

    public static void show(Context context, CharSequence text, int duration) {
        View view = getToastView(context, text);
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }

    private static View getToastView(Context context, CharSequence text) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View toastView = inflater.inflate(R.layout.layout_toast, null);
        TextView textView = (TextView) toastView.findViewById(R.id.tv_toast);
        textView.setText(text);
        return toastView;
    }
}

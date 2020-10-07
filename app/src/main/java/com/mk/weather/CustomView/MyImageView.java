package com.mk.weather.CustomView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.mk.weather.Utils.BaseApplication;

public class MyImageView extends AppCompatImageView {
    Context mContext;
    public MyImageView(Context context) {
        super(context);
        mContext = context;
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

    }
    public  void loadImg(String url){
       Glide.with(mContext).load(url).into(this);
    }
    public void loadImgFromDrawable(Integer integer){
        Glide.with(mContext).load(integer).into(this);
    }
}

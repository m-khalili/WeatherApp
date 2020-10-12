package com.mk.weather.CustomView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mk.weather.R;
import com.mk.weather.Utils.Constants;

public class MyTextView extends RelativeLayout {
    TextView txt;

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.custom_text_view , this , true);
        txt = v.findViewById(R.id.txt);
        txt.setSelected(true);


        TypedArray attrsArray =
                getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);



        String text = attrsArray.getString(R.styleable.MyTextView_text);
        if (text != null){
            txt.setText(text);
        }
        ColorStateList color = attrsArray.getColorStateList(R.styleable.MyTextView_textColor);
        if (color != null){
            txt.setTextColor(color);
        }
        int textSize = attrsArray.getDimensionPixelSize(R.styleable.MyTextView_textSize,0);
        if (textSize > 0){
            txt.setTextSize(textSize);
        }
        int typeFaceNumber = 0 ;
        if (attrsArray.hasValue(R.styleable.MyTextView_textFont)){
            typeFaceNumber = attrsArray.getInt(R.styleable.MyTextView_textFont, 0);
        }

        Typeface regular = Typeface.createFromAsset(context.getAssets(), Constants.regular);
        Typeface medium = Typeface.createFromAsset(context.getAssets(),Constants.medium);
        Typeface bold = Typeface.createFromAsset(context.getAssets(),Constants.bold);
        Typeface light = Typeface.createFromAsset(context.getAssets(),Constants.light);
        Typeface semiBold = Typeface.createFromAsset(context.getAssets(),Constants.semiBold);
        Typeface mediumTest = Typeface.createFromAsset(context.getAssets(),"JosefinSans-Medium1.ttf");

        if (typeFaceNumber == 1)
            txt.setTypeface(regular);
        if (typeFaceNumber == 2)
            txt.setTypeface(medium);
        if (typeFaceNumber == 3)
            txt.setTypeface(bold);
        if (typeFaceNumber == 4)
            txt.setTypeface(light);
        if (typeFaceNumber == 5)
            txt.setTypeface(semiBold);
        if (typeFaceNumber == 6)
            txt.setTypeface(mediumTest);
    }
    public void setTxt(String value){
        txt.setText(value);
    }
    public void setTxt(Double value){
        txt.setText(value.toString());
    }
    public void setTxt(Integer value){
        txt.setText(value.toString());
    }


    public String getText(){
        return txt.getText().toString();
    }

    public void setVisibilityGone(){
        txt.setVisibility(GONE);
    }
}

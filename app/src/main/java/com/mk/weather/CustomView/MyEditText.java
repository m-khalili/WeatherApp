package com.mk.weather.CustomView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;

import com.mk.weather.R;
import com.mk.weather.Utils.Constants;

public class MyEditText extends RelativeLayout {

    EditText txt;
    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.custom_edit_text , this , true);
        txt = v.findViewById(R.id.txt);



        TypedArray attrsArray =
                getContext().obtainStyledAttributes(attrs, R.styleable.MyEditText);

        String hint = attrsArray.getString(R.styleable.MyEditText_hint);
        if (hint != null){
            txt.setHint(hint);
        }

        ColorStateList color = attrsArray.getColorStateList(R.styleable.MyEditText_textColor);
        if (color != null){
            txt.setHintTextColor(color);
        }

        int textSize = attrsArray.getDimensionPixelSize(R.styleable.MyEditText_textSize,0);
        if (textSize > 0){
            txt.setTextSize(textSize);
        }
        int typeFaceNumber = 0 ;
        if (attrsArray.hasValue(R.styleable.MyEditText_textFont)){
            typeFaceNumber = attrsArray.getInt(R.styleable.MyEditText_textFont, 0);
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

   public void setError(String value){
        txt.setError(value);

   }


}

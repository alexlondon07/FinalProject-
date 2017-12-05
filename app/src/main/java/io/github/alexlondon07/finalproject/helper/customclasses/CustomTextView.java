package io.github.alexlondon07.finalproject.helper.customclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import io.github.alexlondon07.finalproject.R;

/**
 * Created by alexlondon07 on 11/30/17.
 */



public class CustomTextView extends AppCompatTextView  {



    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setAllCaps(true);
        setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
        setPadding(2,2,2,2);
        setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        setTypeface(Typeface.DEFAULT_BOLD);
        setPadding(12,12,12,12);
        setTextSize(12);
    }

}

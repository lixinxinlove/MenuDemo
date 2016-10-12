package com.eventmosh.menudemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/**
 * Created by android on 2016/10/12.
 */
public class PopMenu extends RelativeLayout {

    public PopMenu(Context context) {
        this(context,null);
    }

    public PopMenu(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PopMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.pop_menu_layout, this);



    }




}

package com.eventmosh.menudemo;

import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener, PopupWindow.OnDismissListener {


    private ImageView ivMenu;
    private PopupWindow popWindos;
    private  GridView gridView;

    private LinearLayout llMenu;


    RotateAnimation rotateOpen;
    RotateAnimation rotateClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ivMenu = (ImageView) findViewById(R.id.iv_menu);
        llMenu= (LinearLayout) findViewById(R.id.ll_menu);
        gridView= (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new MyGridViewAdapter(this));


        ivMenu.setOnClickListener(this);

        rotateOpen = new RotateAnimation(0f, 90f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateOpen.setFillAfter(true);
        rotateOpen.setDuration(200);

        rotateClose = new RotateAnimation(90f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateClose.setFillAfter(true);
        rotateClose.setDuration(200);

    }

    @Override
    public void onClick(View view) {

        showMonu();
       // showPop(ivMenu);
        ivMenu.startAnimation(rotateOpen);
        ivMenu.setImageResource(R.mipmap.close_icon);

    }


    private void showPop(View view) {

        View dialogView = View.inflate(this, R.layout.pop_layout, null);

        gridView = (GridView) dialogView.findViewById(R.id.grid_view);

        gridView.setAdapter(new MyGridViewAdapter(this));
        popWindos = new PopupWindow(dialogView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        popWindos.setAnimationStyle(R.style.AnimationFade);
        popWindos.setBackgroundDrawable(new PaintDrawable());
        popWindos.setFocusable(true);
        popWindos.showAsDropDown(view, 0, -400);
        popWindos.setOnDismissListener(this);


        dialogView.measure(0,0);

        int[] location = new int[2];
        view.getLocationOnScreen(location);

      //  popWindos.showAtLocation(view, Gravity.NO_GRAVITY, location[0], location[1]-popWindos.getHeight());

    }

    @Override
    public void onDismiss() {
        ivMenu.startAnimation(rotateClose);
        ivMenu.setImageResource(R.mipmap.open_icon);

    }


   private void showMonu(){

       llMenu.setVisibility(View.VISIBLE);

       Animation animation= AnimationUtils.loadAnimation(this,R.anim.pop_open_anim);

       llMenu.startAnimation(animation);

    }


}

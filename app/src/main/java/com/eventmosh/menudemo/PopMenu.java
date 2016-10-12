package com.eventmosh.menudemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by android on 2016/10/12.
 */
public class PopMenu extends RelativeLayout implements AdapterView.OnItemClickListener, View.OnClickListener {

    private GridView mGridView;
    private ImageView ivMenu;
    private LinearLayout llPopMenu;
    private View view;
    private Context context;
    private RelativeLayout rootView;

    private List mData;

    private boolean isOpen = false;

    private RotateAnimation rotateOpen;
    private RotateAnimation rotateClose;


    public PopMenu(Context context) {
        this(context, null);
    }

    public PopMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.pop_menu_layout, this);
        init();
        initAnim();
    }

    private void init() {
        rootView = (RelativeLayout) view.findViewById(R.id.root_view);
        mGridView = (GridView) view.findViewById(R.id.grid_view);
        ivMenu = (ImageView) view.findViewById(R.id.iv_menu);
        llPopMenu = (LinearLayout) view.findViewById(R.id.ll_pop_menu);
        mGridView.setAdapter(new GridViewAdapter());
        rootView.setOnClickListener(this);
        ivMenu.setOnClickListener(this);
        mGridView.setOnItemClickListener(this);
    }

    private void initAnim() {
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


    public void setmData(List mData) {
        this.mData = mData;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showMenu();
        if (listener != null) {
            listener.onItemMenuClick(position);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.root_view:
                if (isOpen) {
                    showMenu();
                }
                break;
            case R.id.iv_menu:
                showMenu();
                break;
        }
    }

    public void showMenu() {
        if (isOpen) {
            rootView.setVisibility(GONE);
            llPopMenu.setVisibility(GONE);
            ivMenu.setImageResource(R.mipmap.open_icon);
            ivMenu.startAnimation(rotateClose);
        } else {
            rootView.setVisibility(VISIBLE);
            llPopMenu.setVisibility(VISIBLE);
            ivMenu.setImageResource(R.mipmap.close_icon);
            ivMenu.startAnimation(rotateOpen);

        }
        isOpen = !isOpen;
    }


    private OnItemMenuListener listener;

    public void setOnItemMenuListener(OnItemMenuListener listener) {
        this.listener = listener;
    }

    public interface OnItemMenuListener {
        void onItemMenuClick(int position);
    }

    class GridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View v = View.inflate(context, R.layout.item_menu, null);
            return v;
        }
    }
}

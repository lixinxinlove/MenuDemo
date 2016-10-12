package com.eventmosh.menudemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by android on 2016/10/12.
 */
public class MyGridViewAdapter extends BaseAdapter {


    public MyGridViewAdapter(Context mContext) {
        this.mContext = mContext;

    }

    private Context mContext;


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

      View  v = View.inflate(mContext, R.layout.item_menu, null);

        return v;
    }
}

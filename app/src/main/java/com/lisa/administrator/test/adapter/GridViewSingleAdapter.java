package com.lisa.administrator.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lisa.administrator.test.R;

import java.util.ArrayList;

/**
 * Created by One Of A Kind Lisa on 2017/2/5
 */

public class GridViewSingleAdapter extends BaseAdapter {
    private ArrayList<String> mList;
    private Context mContext;
    private int clickTemp = -1;//状态标识位

    public GridViewSingleAdapter(ArrayList<String> mList, Context mContext) {
        super();
        this.mList = mList;
        this.mContext = mContext;
    }

    public void setSelection(int position) {
        clickTemp = position;
    }


    @Override
    public int getCount() {
        // TODO: 2017/2/5
        return mList.size();

    }

    @Override
    public Object getItem(int i) {
        // TODO: 2017/2/5
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO: 2017/2/5
        return arg0;
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        // TODO: 2017/2/5
        View view = View.inflate(mContext, R.layout.layout_gridview_item, null);
        TextView tv = (TextView) view.findViewById(R.id.textView1);
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.rl_layout);
        tv.setText(mList.get(position));
        if (clickTemp == position) {
            layout.setBackgroundResource(R.drawable.gradview_item_box_choosed);
            ;
        } else {
            layout.setBackgroundResource(R.drawable.gradview_item_box);
            ;
        }
        return view;
    }
}

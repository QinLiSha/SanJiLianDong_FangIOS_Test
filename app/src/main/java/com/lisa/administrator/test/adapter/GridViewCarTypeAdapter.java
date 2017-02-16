package com.lisa.administrator.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lisa.administrator.test.R;
import com.lisa.administrator.test.base.MyBaseAdapter;

/**
 * Created by One Of A Kind Lisa on 2017/1/13
 */

public class GridViewCarTypeAdapter extends MyBaseAdapter {
    String[] names = {"功能1", "功能2", "功能3", "功能4", "功能5", "功能6"};

    //通过构造方法初始化上下文
    public GridViewCarTypeAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];

    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getMyView(int position, View convertView, ViewGroup parent) {
        //通过布局填充器LayoutInflater填充网格单元格内的布局
        convertView = layoutInflater.inflate(R.layout.layout_gridview_item_1, null);
        //使用findViewById分别找到单元格内布局的图片以及文字
        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        //引用数组内元素设置布局内图片以及文字的内容
        tv.setText(names[position]);
        return convertView;
    }
}

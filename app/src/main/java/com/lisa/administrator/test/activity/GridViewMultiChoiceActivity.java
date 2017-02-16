package com.lisa.administrator.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.lisa.administrator.test.R;
import com.lisa.administrator.test.base.MyBaseActivity;
import com.lisa.administrator.test.view.GridItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 继承MultiChoiceModeListener接口实现gridview的单选和多选，并获取相应的数据
 */

public class GridViewMultiChoiceActivity extends MyBaseActivity implements AbsListView.MultiChoiceModeListener {
    private GridView mGridView_red; //红球的gridview
    private GridAdapter mGridAdapterRed; //红球的适配器
    private GridView gridview_bule; //蓝球的gridview
    private GridAdapter mGridAdapterBlue; //蓝球的适配器
    private Button button; //下一步按钮
    private Map mSelectMapRed = new HashMap(); //存放选择红球的数字的集合
    private Map mSelectMapBlue = new HashMap(); //存放选择蓝球的数字的集合


    Map mImgIds_red = new HashMap(); //存放红球的集合
    Map mImgIds_blue = new HashMap(); //存放蓝球的集合

    /**
     * 程序从此开始运行
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_multi_choice);

//显示33个红球区域的图片
        for (int i = 0; i < 33; i++) {
            mImgIds_red.put(i, R.drawable.ball);
        }

//显示8个蓝球区域的图片
        for (int i = 0; i < 8; i++) {
            mImgIds_blue.put(i, R.drawable.ball);
        }
        mGridView_red = (GridView) findViewById(R.id.gridview_red); //初始化红球的gridview
        button = (Button) findViewById(R.id.button); //初始化下一步按钮
        mGridView_red.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);// 设置为多选模式
        mGridAdapterRed = new GridAdapter(this); //为红球new一个适配器
        mGridView_red.setAdapter(mGridAdapterRed);// 红球数据适配
        mGridView_red.setMultiChoiceModeListener(this);// 设置红球多选模式监听器

        gridview_bule = (GridView) findViewById(R.id.gridview_bule); //初始化蓝球的gridview
        gridview_bule.setChoiceMode(GridView.CHOICE_MODE_SINGLE);// 设置为多选模式
        mGridAdapterBlue = new GridAdapter(this, "blue"); //为蓝球new一个适配器并且传入蓝球的标识
        gridview_bule.setAdapter(mGridAdapterBlue);// 数据适配
        gridview_bule.setMultiChoiceModeListener(this);//设置蓝球单选模式监听器


//监听按钮
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String select_red_ball = ""; //红球的数字
                String select_blue_ball = ""; //蓝球的数字
                List selectednum_red = new ArrayList(); //存放选中红球数字的list
                SparseBooleanArray selectedposition_red;
                selectedposition_red = mGridView_red.getCheckedItemPositions();
                for (int i = 0; i < mImgIds_red.size(); i++) {
                    if (selectedposition_red.get(i)) {
                        selectednum_red.add(i + 1);
                    }
                }
                for (int i = 0; i < selectednum_red.size(); i++) {
                    select_red_ball = select_red_ball + selectednum_red.get(i) + " ";
                }
                List selectednum_blue = new ArrayList(); //存放选中蓝球的数字
                SparseBooleanArray selectedposition_blue;
                selectedposition_blue = gridview_bule.getCheckedItemPositions();
                for (int i = 0; i < mImgIds_blue.size(); i++) {
                    if (selectedposition_blue.get(i)) {
                        selectednum_blue.add(i + 1);
                    }
                }
                for (int i = 0; i < selectednum_blue.size(); i++) {
                    select_blue_ball = "" + selectednum_blue.get(i) + " ";
                }
//跳转到下一个页面，并显示数据
                Intent intent = new Intent();
                intent.setClass(GridViewMultiChoiceActivity.this, ShowNumberActivity.class);
                intent.putExtra("select", select_blue_ball + select_red_ball); //传数据
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return true;
    }


    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return true;
    }


    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return true;
    }


    @Override
    public void onDestroyActionMode(ActionMode mode) {
        mGridAdapterRed.notifyDataSetChanged();
    }


    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position,
                                          long id, boolean checked) {
        mSelectMapRed.put(position, checked);/* 放入选中的集合中 */
        mode.invalidate();
    }


    //适配器
    private class GridAdapter extends BaseAdapter {


        private Context mContext;
        private String mType = "red";


        public GridAdapter(Context ctx) {
            mContext = ctx;
        }

        public GridAdapter(Context ctx, String type) {
            mContext = ctx;
            mType = type;
        }

        @Override
        public int getCount() {
            return (mType.equals("red") ? mImgIds_red : mImgIds_blue).size();
        }


        @Override
        public Integer getItem(int position) {
            return Integer.valueOf((mType.equals("red") ? mImgIds_red : mImgIds_blue).get(position).toString());
        }


        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
/* 得到View */
        public View getView(int position, View convertView, ViewGroup parent) {
            GridItem item;
            if (mType.equals("red")) {
                if (convertView == null) {
                    item = new GridItem(mContext);
                    item.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                            AbsListView.LayoutParams.MATCH_PARENT));
                } else {
                    item = (GridItem) convertView;
                }
                item.setImgResId(getItem(position));
                item.setItemText(String.valueOf(position + 1));
                item.setChecked(mSelectMapRed.get(position) == null ? false : (Boolean) mSelectMapRed.get(position));
            } else {
                if (convertView == null) {
                    item = new GridItem(mContext, "blue");
                    item.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                            AbsListView.LayoutParams.MATCH_PARENT));
                } else {
                    item = (GridItem) convertView;
                }
                item.setImgResId(getItem(position));
                item.setItemText(String.valueOf(position + 1));
                item.setChecked(mSelectMapBlue.get(position) == null ? false
                        : (Boolean) mSelectMapBlue.get(position));
            }

            return item;
        }
    }


}

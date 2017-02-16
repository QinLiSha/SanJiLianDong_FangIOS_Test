package com.lisa.administrator.test.view;

/**
 * Created by One Of A Kind Lisa on 2017/2/7
 * <p>
 * 自定义View继承Checable接口
 * <p>
 * 自定义View继承Checable接口
 */

/**
 * 自定义View继承Checable接口*/

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lisa.administrator.test.R;


public class GridItem extends RelativeLayout implements Checkable {


    private Context mContext;
    private boolean mChecked;//判断该选项是否被选上的标志量
    private ImageView mImgView = null; //点击前的图片
    private ImageView mSecletView = null; //点击红球的图片
    private ImageView mSecletBlue = null; //点击篮球的图片
    private TextView mItemText = null; //显示的数字
    private String mType = "red"; //标识是篮球还是红球的点击

    public GridItem(Context context) {
        this(context, null, 0);
    }

    public GridItem(Context context, String mType) {
        this(context, null, 0);
        this.mType = mType;
    }


    public GridItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public GridItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.grid_item, this); //初始化item布局
        mImgView = (ImageView) findViewById(R.id.img_view); //初始化原始布局id
        mSecletView = (ImageView) findViewById(R.id.select_red); //红球的id
        mItemText = (TextView) findViewById(R.id.itemText); //号码的id
        mSecletBlue = (ImageView) findViewById(R.id.select_blue); //篮球的id
    }

    @Override
    public void setChecked(boolean checked) {
// TODO Auto-generated method stub
        mChecked = checked;
        if (mType.equals("red")) {
            mSecletView.setVisibility(checked ? View.VISIBLE : View.GONE);//选上了图片变成红色


        } else {
            mSecletBlue.setVisibility(checked ? View.VISIBLE : View.GONE);//选上了图片变成蓝色


        }
    }


    @Override
    public boolean isChecked() {
        return mChecked;
    }


    @Override
    public void toggle() {
        setChecked(!mChecked);
    }


    public void setImgResId(int resId) {
        if (mImgView != null) {
            mImgView.setBackgroundResource(resId);//设置背景
        }
    }


    public void setItemText(String itemText) {
        mItemText.setText(itemText); //设置文字
    }


}
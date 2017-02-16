package com.lisa.administrator.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lisa.administrator.test.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemoDatePickerActivity_1 extends AppCompatActivity {

    @BindView(R.id.today)
    TextView today;
    @BindView(R.id.tomorrow)
    TextView tomorrow;
    @BindView(R.id.the_day_after_tomorrow)
    TextView theDayAfterTomorrow;
    @BindView(R.id.activity_demo_date_picker_1)
    LinearLayout activityDemoDatePicker1;
    String stringtoday;
    String stringtomorrow;
    String stringaftertomorrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_date_picker_1);
        ButterKnife.bind(this);
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        stringtomorrow = formatter.format(date);
    }


    @OnClick({R.id.today, R.id.tomorrow, R.id.the_day_after_tomorrow, R.id.activity_demo_date_picker_1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.today:
                break;
            case R.id.tomorrow:
                tomorrow.setText(stringtomorrow);
                break;
            case R.id.the_day_after_tomorrow:
                break;
            case R.id.activity_demo_date_picker_1:
                break;
        }
    }
}

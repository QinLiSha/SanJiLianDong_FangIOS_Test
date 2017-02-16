package com.lisa.administrator.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.lisa.administrator.test.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 仿照IOS的wheelview的时间选择器有
 * 本文中有：
 * 年月日时分
 * 和
 * 年月日
 * 的dialog的选择
 */
public class DemoDatePickerActivity extends AppCompatActivity implements OnDateSetListener {

    @BindView(R.id.button_all)
    Button buttonAll;
    @BindView(R.id.button_date)
    Button buttonDate;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_date)
    TextView tvDate;
    TimePickerDialog mDialogAll;
    TimePickerDialog mDialogYearMonthDay;

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_date_picker);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
//        mDialogAll = new TimePickerDialog.Builder()
//                .setCallBack(this)
//                .setCancelStringId("Cancel")
//                .setSureStringId("Sure")
//                .setTitleStringId("TimePicker")
//                .setYearText("Year")
//                .setMonthText("Month")
//                .setDayText("Day")
//                .setHourText("Hour")
//                .setMinuteText("Minute")
//                .setCyclic(false)
//                .setMinMillseconds(System.currentTimeMillis())
//                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
//                .setCurrentMillseconds(System.currentTimeMillis())
//                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
//                .setType(Type.ALL)
//                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
//                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
//                .setWheelItemTextSize(12)
//                .build();
        mDialogAll = new TimePickerDialog.Builder()
                .setMinMillseconds(System.currentTimeMillis())
                .setThemeColor(R.color.colorPrimary)
                .setWheelItemTextSize(16)
                .setCallBack(this)
                .build();
        mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setCallBack(this)
                .build();
    }


    @OnClick({R.id.button_all, R.id.button_date})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_all:
                mDialogAll.show(getSupportFragmentManager(), "all");
                break;
            case R.id.button_date:
                mDialogYearMonthDay.show(getSupportFragmentManager(), "year_month_day");
                break;
        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        String text = getDateToString(millseconds);
        tvAll.setText(text);
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

}

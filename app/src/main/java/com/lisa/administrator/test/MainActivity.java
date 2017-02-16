package com.lisa.administrator.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lisa.administrator.test.activity.DemoDatePickerActivity;
import com.lisa.administrator.test.activity.DemoNumberPickerActivity;
import com.lisa.administrator.test.activity.DemoTimePickerActivity;
import com.lisa.administrator.test.activity.GridViewMultiChoiceActivity;
import com.lisa.administrator.test.activity.GridViewSingleActivity;
import com.lisa.administrator.test.activity.TimePickerActivity;
import com.lisa.administrator.test.activity.ToActivity;
import com.lisa.administrator.test.base.MyBaseActivity;
import com.zaaach.citypicker.CityPickerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MyBaseActivity {

    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.tv_address_from)
    TextView tvAddressFrom;
    @BindView(R.id.tv_address_to)
    TextView tvAddressTo;
    @BindView(R.id.tv_address)
    TextView tvAddress;

    @BindView(R.id.tv_city)
    TextView tvCity;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private static final int REQUEST_CODE_CAR_TYPE_AND_LENGTH = 1;
    @BindView(R.id.gridview_muli_choice)
    TextView gridviewMuliChoice;
    @BindView(R.id.tv_time_picker)
    TextView tvTimePicker;
    @BindView(R.id.tv_date_picker)
    TextView tvDatePicker;
    @BindView(R.id.tv_num_picker)
    TextView tvNumPicker;
    @BindView(R.id.tv_time_picker_1)
    TextView tvTimePicker1;
    @BindView(R.id.tv_date_picker_1)
    TextView tvDatePicker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //启动

    }

    //重写onActivityResult方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tvCity.setText("当前选择：" + city);
            }
        }
        if (requestCode == REQUEST_CODE_CAR_TYPE_AND_LENGTH && resultCode == RESULT_OK) {
            if (data != null) {
                String result = data.getStringExtra(ToActivity.KEY_CAR_TYPE_AND_LENGTH);
                tvAddress.setText(result);
            }
        }
    }

    @OnClick({R.id.tv_address_from, R.id.tv_address_to, R.id.tv_address, R.id.tv_city, R.id.gridview_muli_choice,
            R.id.tv_time_picker, R.id.tv_date_picker, R.id.tv_num_picker, R.id.tv_time_picker_1, R.id.tv_date_picker_1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_address_from:
                initAddress(tvAddressFrom);
                break;
            case R.id.tv_address_to:
//                initAddress(tvAddressTo);
//                openActivity(MainActivity.this, GridViewTestActivity.class);
                openActivity(GridViewSingleActivity.class);
//                Intent intent = new Intent(MainActivity.this, GridViewSingleActivity.class);
//                startActivityForResult();

                break;
            case R.id.tv_address:
//                openActivity(MainActivity.this, FromActivity.class);
                Intent intent = new Intent(MainActivity.this, ToActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CAR_TYPE_AND_LENGTH);

                break;
            case R.id.tv_city:
                startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.gridview_muli_choice:
                openActivity(GridViewMultiChoiceActivity.class);
                break;
            case R.id.tv_time_picker:
                openActivity(DemoTimePickerActivity.class);
                break;
            case R.id.tv_date_picker:
                openActivity(DemoDatePickerActivity.class);
                break;
            case R.id.tv_num_picker:
                openActivity(DemoNumberPickerActivity.class);
                break;
            case R.id.tv_time_picker_1:
                Time time = new Time("GMT+8");
                time.setToNow();
                int year = time.year;
                int month = time.month;
                int day = time.monthDay;
                int minute = time.minute;
                int hour = time.hour;
                int sec = time.second;
                tvTimePicker1.setText("当前时间为：" + year +
                        "年 " + month +
                        "月 " + day +
                        "日 " + hour +
                        "时 " + minute +
                        "分 " + sec +
                        "秒");
                break;
            case R.id.tv_date_picker_1:
                openActivity(TimePickerActivity.class);
                break;
        }
    }


    /**
     * TimePickerDialog实现代码
     */
//    TimePickerDialog td = new TimePickerDialog(DateTimePicker.this,
//            new TimePickerDialog.OnTimeSetListener() {
//                @Override
//                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                    try {
//                        String dtStart = String.valueOf(hourOfDay) ":" String.valueOf(minute);
//                        format = new SimpleDateFormat("HH:mm");
//
//                        timeValue = new java.sql.Time(format.parse(dtStart).getTime());
//                        txttime.setText(String.valueOf(timeValue));
//                        String amPm = hourOfDay % 12 ":" minute " "
//                        ((hourOfDay >= 12) ? "PM" : "AM");
//                        txttime.setText(amPm"
//                                "   String.valueOf(timeValue));
//                    } catch (Exception ex) {
//                        txttime.setText(ex.getMessage().toString());
//                    }
//                }
//            },
//            hour, min, DateFormat.is24HourFormat(DateTimePicker.this)
//    );
//    td.show();
}

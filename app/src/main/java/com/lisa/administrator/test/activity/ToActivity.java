package com.lisa.administrator.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lisa.administrator.test.R;
import com.lisa.administrator.test.base.MyBaseActivity;


public class ToActivity extends MyBaseActivity {
    private Button buttonTo;
    public static final String KEY_CAR_TYPE_AND_LENGTH = "result_car_type_and_length";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);
        init();
    }

    private void init() {
        buttonTo = (Button) findViewById(R.id.button_to);
        buttonTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backCarInfo("4.5米中卡");
            }
        });
    }

    private void backCarInfo(String carInfo) {
        Intent data = new Intent();
        data.putExtra(KEY_CAR_TYPE_AND_LENGTH, carInfo);
        setResult(RESULT_OK, data);
        finish();
    }
}

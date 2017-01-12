package com.lisa.administrator.test;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }



    @OnClick({R.id.tv_address_from, R.id.tv_address_to})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_address_from:
                initAddress(tvAddressFrom);
                break;
            case R.id.tv_address_to:
                initAddress(tvAddressTo);
                break;
        }
    }
}

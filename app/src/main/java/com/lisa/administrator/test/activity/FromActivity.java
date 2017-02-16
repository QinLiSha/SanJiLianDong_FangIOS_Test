//package com.lisa.administrator.test.activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.lisa.administrator.test.R;
//import com.lisa.administrator.test.base.MyBaseActivity;
//
//public class FromActivity extends MyBaseActivity {
//    private Button buttonFrom;
//    private TextView tvWord;
//    private static final int REQUEST_CODE_CAR_TYPE_AND_LENGTH = 1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_from);
//        init();
//    }
//
//    private void init() {
//        buttonFrom = (Button) findViewById(R.id.button_from);
//        tvWord = (TextView) findViewById(R.id.textView_from);
//        buttonFrom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FromActivity.this, ToActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_CAR_TYPE_AND_LENGTH);
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE_CAR_TYPE_AND_LENGTH && resultCode == RESULT_OK) {
//            if (data != null) {
//                String result = data.getStringExtra(ToActivity.KEY_CAR_TYPE_AND_LENGTH);
//                tvWord.setText(result);
//            }
//        }
//    }
//}

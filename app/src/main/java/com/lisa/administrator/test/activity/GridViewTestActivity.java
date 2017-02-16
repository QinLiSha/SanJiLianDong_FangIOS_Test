package com.lisa.administrator.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.lisa.administrator.test.adapter.GridViewCarLengthAdapter;
import com.lisa.administrator.test.adapter.GridViewCarTypeAdapter;
import com.lisa.administrator.test.R;

public class GridViewTestActivity extends AppCompatActivity {
    private GridView gv_car_length;//声明GridView视图
    private GridView gv_car_type;//声明GridView视图
    private String carLengthAndType;
    private String carLength;
    private String carType;
    TextView tv_all;
    GridViewCarLengthAdapter gridViewCarLengthAdapter;
    GridViewCarTypeAdapter gridViewCarTypeAdapter;
    Button button;
    private static final String TAG = "GridViewTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_car_type_length);
        button = (Button) findViewById(R.id.btn_sure_choose_cartype);
        gv_car_length = (GridView) findViewById(R.id.gv_car_length);
        gv_car_type = (GridView) findViewById(R.id.gv_car_type);
        tv_all = (TextView) findViewById(R.id.tv_all);
        gridViewCarLengthAdapter = new GridViewCarLengthAdapter(this);
        gridViewCarTypeAdapter = new GridViewCarTypeAdapter(this);
        gv_car_length.setAdapter(gridViewCarLengthAdapter);//通过设置适配器实现网格内布局
        gv_car_type.setAdapter(gridViewCarTypeAdapter);//通过设置适配器实现网格内布局
        //为每个单元格（item）添加单击事件
//        gv_car_length.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView tv = (TextView) view.findViewById(R.id.tv);
//                textView.setText(tv.getText());
//            }
//        });
        gv_car_length.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView) view.findViewById(R.id.tv);
//                textView.setText(tv.getText());
                carLength = (String) tv.getText();
                System.out.print(carLength);
                Log.e(TAG, "onItemSelected: =====carLength======" + carLength);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gv_car_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                carType = (String) adapterView.getSelectedItem().toString();
                carType = ((TextView) adapterView.getSelectedItem()).getText().toString();
                System.out.print(carType);
                tv_all.setText(carType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carLengthAndType = carType + carLength;
                tv_all.setText(carLengthAndType);
            }
        });
    }
}
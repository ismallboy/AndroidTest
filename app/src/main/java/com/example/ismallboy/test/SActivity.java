package com.example.ismallboy.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Haier-We_Can on 2016/3/22.
 */
public class SActivity extends Activity {

    private Button bt1;
    private  String content = "您好";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);

        bt1 = (Button)findViewById(R.id.button);

        /**
         * 什么时候给第一个页面回传数据
         */
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("data", content);
                setResult(2,data);
                finish();
            }
        });
    }
}

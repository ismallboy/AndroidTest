package com.example.ismallboy.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.ContentHandler;

/**
 * Created by Haier-We_Can on 2016/3/22.
 */
public class FActivity extends Activity{
    private Button bt1;
    private Button bt2;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);

        mContext = this;
        bt1 = (Button)findViewById(R.id.button1_first);
        bt2 = (Button)findViewById(R.id.button1_second);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 第一个参数
                 */
                Intent intent = new Intent(mContext, SActivity.class);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    /**
     *
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            String content = data.getStringExtra("data");
            TextView tv = (TextView)findViewById(R.id.textView);
            tv.setText(content);

        }
    }
}

package com.example.ismallboy.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Haier-We_Can on 2016/3/24.
 */
public class ButtonTestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化布局
        setContentView(R.layout.activity_buttontest);
        Button btn_yellow = (Button) findViewById(R.id.btnLogin);
        btn_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ButtonTestActivity.this, "ismallboy", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}

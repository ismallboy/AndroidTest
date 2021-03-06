package com.example.ismallboy.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Haier-We_Can on 2016/3/23.
 */
public class calc extends Activity implements View.OnClickListener{
    //声明按钮
    Button btn_0;//0按钮
    Button btn_1;//0按钮
    Button btn_2;//0按钮
    Button btn_3;//0按钮
    Button btn_4;//0按钮
    Button btn_5;//0按钮
    Button btn_6;//0按钮
    Button btn_7;//0按钮
    Button btn_8;//0按钮
    Button btn_9;//0按钮
    Button btn_point;//0按钮
    Button btn_del;//0按钮
    Button btn_clear;//0按钮
    Button btn_add;//0按钮
    Button btn_minus;//0按钮
    Button btn_multiply;//0按钮
    Button btn_divide;//0按钮
    Button btn_equal;//0按钮

    EditText et_input;//显示输出结果的按钮

    boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        //初始化按钮
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);

        et_input = (EditText) findViewById(R.id.et_input);

        //实现按钮的点击事件
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);

    }

    /**
     * 实现点击事件
     * @param v 控件
     */
    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag){
                    clear_flag = false;
                    et_input.setText("");
                    str = "";
                }
                et_input.setText(str + ((Button)v).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if (clear_flag){
                    clear_flag = false;
                    et_input.setText("");
                    str = "";
                }
                et_input.setText(str + " " + ((Button)v).getText() + " ");
                break;
            case R.id.btn_clear:
                clear_flag = false;
                et_input.setText("");
                str = "";
                break;
            case R.id.btn_del:
                if (clear_flag){
                    clear_flag = false;
                    et_input.setText("");
                    str = "";
                }else if (str != null && !str.equals("")){
                    et_input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }

    private void getResult(){
        double result = 0;
        String exp = et_input.getText().toString();
        if (exp == null || exp.equals("")){
            return;
        }
        if (!exp.contains("")) {
            return;
        }
        if (clear_flag){
            return;
        }
        clear_flag = true;

        //第一个数字
        String num1 = exp.substring(0, exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String num2 = exp.substring(exp.indexOf(" ") + 3);
        if (!num1.equals("") && !num2.equals("")){
            double d1 = Double.parseDouble(num1);
            double d2 = Double.parseDouble(num2);
            //判断当前是什么运算
            if (op.equals("+")){
                result = d1 + d2;
            }else if (op.equals("-")){
                result = d1 - d2;
            }else if (op.equals("×")){
                result = d1 * d2;
            }else if (op.equals("÷")){
                if (d2 != 0){
                    result = d1 / d2;
                }else{
                    result = 0;
                }
            }
            if (!num1.contains(".") && !num2.contains(".")){
                int r = (int)result;
                et_input.setText(r + "");
            }else{
                et_input.setText(result + "");
            }
        }

    }
}

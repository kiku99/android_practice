package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result,rest;

    Button[] buttons = new Button[10];
    Integer[] buttonsIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9,};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("실습용 계산기");

        editText1 = (EditText) findViewById(R.id.Edit1);
        editText2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        textResult=(TextView)findViewById(R.id.Result);
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString());
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString());
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString());
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                rest= Integer.parseInt(num1) % Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString()+"나머지는"+rest.toString());
                return false;
            }
        });

        for (int i = 0; i < buttonsIDs.length; i++) {
            buttons[i] = (Button) findViewById(buttonsIDs[i]);
        }
        for (int i = 0; i < buttonsIDs.length; i++) {
            final int index;
            index = i;
            buttons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (editText1.isFocused() == true) {
                        num1 = editText1.getText().toString() + buttons[index].getText().toString();
                        editText1.setText(num1);
                    } else if (editText2.isFocused() == true) {
                        num2 = editText2.getText().toString() + buttons[index].getText().toString();
                        editText2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디트 텍스트를 터치해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }


}
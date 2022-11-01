package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double num1 = 0, num2 = 0;
    int numFlag = 0;
    int actionFlag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);

    }

    public void resetData () {
        num1 = 0;
        num2 = 0;
        numFlag = 0;
        actionFlag = 0;
        result.setText("");
    }

    public void changeState () {
        if (numFlag == 0) {
            num1 = Integer.valueOf(result.getText().toString());
            numFlag = 1;
            result.setText("");
        }
        else if (numFlag == 1) {
            num1 = Integer.valueOf(result.getText().toString());
            result.setText("");
        }
    }


    public void buttonFunctionNumber(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;

            String str = b.getText().toString();

            if (numFlag == 3) {
                resetData();
            }

            if (result.getText().toString().startsWith("0")) {
                result.setText(str);
            }
            else{
                result.append(str);
            }
        }
    }

    public void buttonFunctionAction (View view) {
        if (view instanceof Button) {
            Button b = (Button) view;
            String str = b.getText().toString();

            if (str.equals("÷")) {
                actionFlag = 1;
                changeState();
            }
            else if (str.equals("x")) {
                actionFlag = 2;
                changeState();
            }
            else if (str.equals("-")) {
                actionFlag = 3;
                changeState();
            }
            else if (str.equals("+")){
                actionFlag = 4;
                changeState();
            }
        }
    }

    public void buttonFunctionClear (View view) {
        resetData();
    }

    public void buttonFunctionEqual (View view) {
        if (numFlag == 1) {
            num2 = Integer.valueOf(result.getText().toString());
            if (actionFlag == 1) {result.setText(String.valueOf(Double.parseDouble(String.format("%.03f", (num1/num2)))));}
            else if (actionFlag == 2) {result.setText(String.valueOf((int)(num1*num2)));}
            else if (actionFlag == 3) {result.setText(String.valueOf((int)(num1-num2)));}
            else if (actionFlag == 4) {result.setText(String.valueOf((int)(num1+num2)));}
            numFlag = 3;
        }
    }

}
package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double num1 = 0, num2 = 0;
    int numFlag = 0;
    int actionFlag = 0;
    DecimalFormat format = new DecimalFormat("0.###");


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
        if (numFlag == 0 || numFlag == 3) {
            num1 = Double.valueOf(result.getText().toString());
            numFlag = 1;
            result.setText("");
        }
        else if (numFlag == 1) {
            if (!(result.getText().toString().equals(""))){
            num1 = Double.valueOf(result.getText().toString());
            result.setText("");
            }
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

            switch (str) {
                case "÷":
                    actionFlag = 1;
                    changeState();
                    break;

                case "x":
                    actionFlag = 2;
                    changeState();
                    break;

                case "-":
                    actionFlag = 3;
                    changeState();
                    break;

                case "+":
                    actionFlag = 4;
                    changeState();
                    break;
            }
        }
    }

    public void buttonFunctionClear (View view) {
        resetData();
    }

    public void buttonFunctionEqual (View view) {
        if (numFlag == 1 && !(result.getText().toString().equals(""))) {
            num2 = Double.valueOf(result.getText().toString());

            switch (actionFlag) {
                case 1:
                    if (num2 == 0) {
                        result.setText("ERROR");
                    } else {
                    result.setText(format.format(num1/num2));
                    }

                    break;

                case 2:
                    result.setText(format.format(num1*num2));
                    break;

                case 3:
                    result.setText(format.format(num1-num2));
                    break;

                case 4:
                    result.setText(format.format(num1+num2));
                    break;
            }
            numFlag = 3;
        }
    }

}
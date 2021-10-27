package com.example.calculator10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Integer firstVar, secondVar;
    private Boolean isFirstVarChosen = false;
    private String operation;
    private Integer result;
    private Boolean isEqualRepeat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);

    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setTextTvResult("1");
                break;
            case R.id.btn_two:
                setTextTvResult("2");
                break;
            case R.id.btn_three:
                setTextTvResult("3");
                break;
            case R.id.btn_four:
                setTextTvResult("4");
                break;
            case R.id.btn_five:
                setTextTvResult("5");
                break;
            case R.id.btn_six:
                setTextTvResult("6");
                break;
            case R.id.btn_seven:
                setTextTvResult("7");
                break;
            case R.id.btn_eight:
                setTextTvResult("8");
                break;
            case R.id.btn_nine:
                setTextTvResult("9");
                break;
            case R.id.btn_null:
                setTextTvResult("0");
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                isFirstVarChosen = false;
                firstVar = 0;
                secondVar = 0;
                break;
        }
    }

    private void setTextTvResult(String number) {
        if (tvResult.getText().toString().equals("0")) {
            tvResult.setText(number);
        } else {
            tvResult.append(number);
        }
        if (isFirstVarChosen) {
            tvResult.setText(number);
        }
        isFirstVarChosen = false;
        isEqualRepeat = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                //12
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                operation = "+";
                isEqualRepeat = false;
                break;
            case R.id.btn_minus:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                operation = "-";
                isEqualRepeat = false;
                break;
            case R.id.btn_div:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                operation = "/";
                isEqualRepeat = false;
                break;
            case R.id.btn_multiply:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                operation = "*";
                isEqualRepeat = false;
                break;
            case R.id.btn_percent:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                operation = "%";
                isEqualRepeat = false;
                break;
            case R.id.btn_equal:
                //22
                if (!isEqualRepeat) {
                    secondVar = Integer.parseInt(tvResult.getText().toString());
                } else {
                    firstVar = Integer.parseInt(tvResult.getText().toString());
                }

                switch (operation) {
                    case "+":
                        // 12 + 21 = 33
                        result = firstVar + secondVar;
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        break;
                    case "*":
                        result = firstVar * secondVar;
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        break;
                    case "%":
                        result = (firstVar * secondVar)/100 ;
                        break;
                }
                //33
                tvResult.setText(result.toString());
                isFirstVarChosen = false;
                isEqualRepeat = true;
                break;

        }
    }


}
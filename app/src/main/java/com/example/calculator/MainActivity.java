package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private double firstValue = Double.NaN;
    private double secondValue;
    private String currentOperator;
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
    }

    public void onDigitClick(View view) {
        if (isNewOperation) {
            tvResult.setText("");
            isNewOperation = false;
        }

        Button button = (Button) view;
        tvResult.append(button.getText());
    }

    public void onOperatorClick(View view) {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(tvResult.getText().toString());
            performOperation();
        }
        firstValue = Double.parseDouble(tvResult.getText().toString());

        Button button = (Button) view;
        currentOperator = button.getText().toString();
        isNewOperation = true;
    }

    public void onEqualClick(View view) {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(tvResult.getText().toString());
            performOperation();
            firstValue = Double.NaN;
            currentOperator = "";
            isNewOperation = true;
        }
    }

    public void onClearClick(View view) {
        tvResult.setText("0");
        firstValue = Double.NaN;
        secondValue = Double.NaN;
        currentOperator = "";
        isNewOperation = true;
    }

    private void performOperation() {
        switch (currentOperator) {
            case "+":
                tvResult.setText(String.valueOf(firstValue + secondValue));
                break;
            case "-":
                tvResult.setText(String.valueOf(firstValue - secondValue));
                break;
            case "*":
                tvResult.setText(String.valueOf(firstValue * secondValue));
                break;
            case "/":
                tvResult.setText(String.valueOf(firstValue / secondValue));
                break;
        }
    }
}

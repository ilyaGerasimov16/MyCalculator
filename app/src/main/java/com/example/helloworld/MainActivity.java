 package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


 public class MainActivity extends AppCompatActivity {

     final String KEY_CURRENT = "CURRENT";
     final String KEY_INTERMEDIATE ="INTERMEDIATE";
     final String KEY_SIGN = "SIGN";

     TextView resultView;
     Button buttonReset;
     Button button0;
     Button button1;
     Button button2;
     Button button3;
     Button button4;
     Button button5;
     Button button6;
     Button button7;
     Button button8;
     Button button9;
     Button buttonAdd;
     Button buttonSub;
     Button buttonMul;
     Button buttonDiv;
     Button buttonPoint;
     Button buttonResult;
     CurrentNumber currentNumber = new CurrentNumber();
     IntermediateValue intermediateValue = new IntermediateValue();
     Float result;
     CurrentSign currentSign = new CurrentSign();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);

        initView();
        buttonClickListeners();
    }

     private void buttonClickListeners() {
        button0.setOnClickListener(v -> {
            currentNumber.addDigit(button0.getText().toString());
            setNumberToTextView();
        });

         button1.setOnClickListener(v -> {
             currentNumber.addDigit(button1.getText().toString());
             setNumberToTextView();
         });

         button2.setOnClickListener(v -> {
             currentNumber.addDigit(button2.getText().toString());
             setNumberToTextView();
         });

         button3.setOnClickListener(v -> {
             currentNumber.addDigit(button3.getText().toString());
             setNumberToTextView();
         });
         button4.setOnClickListener(v -> {
             currentNumber.addDigit(button4.getText().toString());
             setNumberToTextView();
         });
         button5.setOnClickListener(v -> {
             currentNumber.addDigit(button5.getText().toString());
             setNumberToTextView();
         });
         button6.setOnClickListener(v -> {
             currentNumber.addDigit(button6.getText().toString());
             setNumberToTextView();
         });
         button7.setOnClickListener(v -> {
             currentNumber.addDigit(button7.getText().toString());
             setNumberToTextView();
         });
         button8.setOnClickListener(v -> {
             currentNumber.addDigit(button8.getText().toString());
             setNumberToTextView();
         });
         button9.setOnClickListener(v -> {
             currentNumber.addDigit(button9.getText().toString());
             setNumberToTextView();
         });

         buttonPoint.setOnClickListener(v -> {
             if (!currentNumber.getNumber().contains(".")){
                 currentNumber.addDigit(buttonPoint.getText().toString());
                 setNumberToTextView();
             }
         });

         buttonAdd.setOnClickListener(v -> {
             intermediateValue.setIntermediateValue(currentNumber.getNumber());
             currentNumber.resetToZero();
             setNumberToTextView();
             currentSign.setSign('+');
         });
         buttonSub.setOnClickListener(v -> {
             if (currentNumber.getNumber().equals("")){
                 currentNumber.addDigit(buttonSub.getText().toString());
             } else {
                 if (currentSign.getSign() == null) {
                     intermediateValue.setIntermediateValue(currentNumber.getNumber());
                     currentSign.setSign('-');
                 }
                 currentNumber.resetToZero();
             }
             setNumberToTextView();
         });
         buttonMul.setOnClickListener(v -> {
             intermediateValue.setIntermediateValue(currentNumber.getNumber());
             currentNumber.resetToZero();
             setNumberToTextView();
             currentSign.setSign('*');
         });

         buttonDiv.setOnClickListener(v -> {
             intermediateValue.setIntermediateValue(currentNumber.getNumber());
             currentNumber.resetToZero();
             setNumberToTextView();
             currentSign.setSign('/');
         });

         buttonReset.setOnClickListener(v -> {
             intermediateValue.resetToZero();
             currentNumber.resetToZero();
             setNumberToTextView();
         });

         buttonResult.setOnClickListener(v -> {

             if (intermediateValue.getIntermediateValue().length()>0 && currentNumber.getNumber().length()>0){
                if(buttonPoint.getText().toString().equals(currentNumber.getNumber())) {
                    currentNumber.setNumber("0.0");
                }
                 if (buttonPoint.getText().toString().equals(intermediateValue.getIntermediateValue())) {
                     intermediateValue.setIntermediateValue("0.0");
                 }
                 switch (currentSign.getSign()){
                 case ('+'):
                     result = Float.parseFloat(currentNumber.getNumber()) + Float.parseFloat(intermediateValue.getIntermediateValue());
                     currentNumber.setNumber(result.toString());
                     setNumberToTextView();
                     break;
                 case ('-'):
                     result = Float.parseFloat(intermediateValue.getIntermediateValue()) - Float.parseFloat(currentNumber.getNumber());
                     currentNumber.setNumber(result.toString());
                     setNumberToTextView();
                     break;
                 case ('*'):
                     result = Float.parseFloat(currentNumber.getNumber()) * Float.parseFloat(intermediateValue.getIntermediateValue());
                     currentNumber.setNumber(result.toString());
                     setNumberToTextView();
                     break;
                 case ('/'):
                     try {
                         result = Float.parseFloat(intermediateValue.getIntermediateValue()) / Float.parseFloat(currentNumber.getNumber());
                         currentNumber.setNumber(result.toString());
                         setNumberToTextView();
                     } catch (Exception ex) {
                         resultView.setText("Ошибка");
                     }
                     break;
             }}
         });
     }

     private void setNumberToTextView() {
         resultView.setText(currentNumber.getNumber());
     }

     private void initView() {
        resultView = findViewById(R.id.text_result);
        button0 = findViewById(R.id.btn_0);
        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        button3 = findViewById(R.id.btn_3);
        button4 = findViewById(R.id.btn_4);
        button5 = findViewById(R.id.btn_5);
        button6 = findViewById(R.id.btn_6);
        button7 = findViewById(R.id.btn_7);
        button8 = findViewById(R.id.btn_8);
        button9 = findViewById(R.id.btn_9);
        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        buttonPoint = findViewById(R.id.btn_point);
        buttonResult = findViewById(R.id.btn_result);
        buttonReset = findViewById(R.id.btn_reset);
    }

     @Override
     protected void onSaveInstanceState(@NonNull Bundle outState) {
         super.onSaveInstanceState(outState);
         outState.putSerializable(KEY_CURRENT, currentNumber);
         outState.putSerializable(KEY_INTERMEDIATE, intermediateValue);
         outState.putParcelable(KEY_SIGN, currentSign);
     }

     @Override
     protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
         super.onRestoreInstanceState(savedInstanceState);
         currentNumber = (CurrentNumber) savedInstanceState.getSerializable(KEY_CURRENT);
         intermediateValue = (IntermediateValue) savedInstanceState.getSerializable(KEY_INTERMEDIATE);
         currentSign = savedInstanceState.getParcelable(KEY_SIGN);
         setNumberToTextView();
     }
 }
package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        calculate = (Button) findViewById(R.id.calculate);
        result = (TextView) findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI(){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr) /100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);
             displayeBMI(bmi);
        }

    }

    private void displayeBMI(float bmi){
        String bmiLable = "";

        if(Float.compare(bmi, 15f) <= 0){
            bmiLable = "Need to gain more weight";
        }
         else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi,16f) <= 0){
            bmiLable = " Need to gain few more weight";
        }
        else if(Float.compare(bmi, 16f) > 0 && Float.compare(bmi,18.5f) <= 0){
            bmiLable = " underweight!!";
        }
        else if(Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi,25f) <= 0){
            bmiLable = "Your weight is normal!!";
        }
        else if(Float.compare(bmi, 25f) > 0 && Float.compare(bmi,30f) <= 0){
            bmiLable = " You are overweight";
        }

        else {
            bmiLable ="Extreme Overweight need to loose weight";
        }
        bmiLable = bmi + "\n" + bmiLable;
        result.setText(bmiLable);


    }
}
package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button MatrixCalc = (Button) findViewById(R.id.button11);
        Button TrigonometryCalc = (Button) findViewById(R.id.button6);
        Button LogCalc = (Button) findViewById(R.id.button5);
        Button ElectricCalc = (Button) findViewById(R.id.button3);
        Button NumSysCalc = (Button) findViewById(R.id.button15);
        MatrixCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatrixCalc();
            }
        });
        TrigonometryCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrigCalc();
            }
        });
        LogCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogCalc();
            }
        });
        ElectricCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElectricCalc();
            }
        });
        NumSysCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumSysCalc();
            }
        });
    }

    public void MatrixCalc() {

        Intent intent = new Intent(this, Matrix.class);
        startActivity(intent);
    }
    public void TrigCalc() {

        Intent intent = new Intent(this, Trigonometry.class);
        startActivity(intent);
    }
    public void LogCalc() {

        Intent intent = new Intent(this, LogarithmicCalc.class);
        startActivity(intent);
    }

    public void ElectricCalc() {

        Intent intent = new Intent(this, ElectricCalc.class);
        startActivity(intent);
    }

    public void NumSysCalc() {

        Intent intent = new Intent(this, NumberCalc.class);
        startActivity(intent);
    }
}
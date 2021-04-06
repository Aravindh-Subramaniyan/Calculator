package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LogarithmicCalc extends AppCompatActivity {

    Spinner sp1;
    EditText ed1,ed2;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logarithmic_calc);
        ed1=findViewById(R.id.baseEditText);
        ed2=findViewById(R.id.valueEditText);

    }


    public void calculateNaturalLog(View view) {
        //int base=Integer.parseInt(String.valueOf(baseVal.getText()));
        EditText entValue=findViewById(R.id.valueEditText);
        TextView resultLbl=findViewById(R.id.resultLbl);
        double value;
        String n1=entValue.getText().toString();
        try{
            value=Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(n1)), 10));
            String res=String.valueOf(Math.log(value));
            resultLbl.setText(res);
        }
        catch (NumberFormatException e){
            ed1.setError("Invalid input");
        }


    }

    public void calculateLog(View view) {
        //base=Integer.parseInt(String.valueOf(baseVal.getText()));
        // value = Double.parseDouble(String.valueOf(entValue.getText()));

        EditText entValue=findViewById(R.id.valueEditText);
        EditText baseVal=findViewById(R.id.baseEditText);
        TextView resultLbl=findViewById(R.id.resultLbl);
        int base;
        double value;
        String n1=baseVal.getText().toString();
        String n2=entValue.getText().toString();

        try{
            value=Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(n1)), 10));
            base=Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(n2)), 10));
            String res=String.valueOf(Math.log(value)/Math.log(base));
            resultLbl.setText(res);
        }
        catch (NumberFormatException e){
            ed1.setError("Invalid input");
            ed2.setError("Invalid input");
        }

    }

    public void calculateAntiLog(View view) {

        EditText entValue=findViewById(R.id.valueEditText);
        EditText baseVal=findViewById(R.id.baseEditText);
        TextView resultLbl=findViewById(R.id.resultLbl);
        int base;
        double value;
        String n1=baseVal.getText().toString();
        String n2=entValue.getText().toString();

        try{
            value=Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(n1)), 10));
            base=Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(n2)), 10));
            String res=String.valueOf(Math.pow(value,base));
            resultLbl.setText(res);
        }
        catch (NumberFormatException e){
            ed1.setError("Invalid input");
            ed2.setError("Invalid input");
        }
    }
}

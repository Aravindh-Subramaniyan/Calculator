package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Trigonometry extends AppCompatActivity {

    Button Calc;
    Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometry);
        sp1=findViewById(R.id.spinner);
        String[] from = {"Sin","Cos","Tan","Sec","CoSec","Cot","ArcSin","ArcCos","ArcTan"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        ad.setDropDownViewResource(R.layout.spinner_textview);
        sp1.setAdapter(ad);
        Calc = (Button) findViewById(R.id.button7);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcVal();
            }
        });
    }

    public void CalcVal(){
        EditText ed,ans;
        Double deg,rad,ResValue,temp;
        ed=findViewById(R.id.Val);
        ans=findViewById(R.id.Ans);
        try{
            deg=Double.parseDouble(ed.getText().toString());
            rad=Math.toRadians(deg);
            if(sp1.getSelectedItem().toString() == "Sin"){
                ResValue = Math.sin(rad);
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "Cos"){
                ResValue = Math.cos(rad);
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "Tan"){
                ResValue = Math.tan(rad);
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "CoSec"){
                temp = Math.sin(rad);
                ResValue= 1/temp;
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "Sec"){
                temp = Math.cos(rad);
                ResValue= 1/temp;
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "Cot"){
                temp = Math.tan(rad);
                ResValue= 1/temp;
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "ArcSin"){
                ResValue = Math.asin(rad);
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "ArcCos"){
                ResValue = Math.acos(rad);
                ans.setText(ResValue.toString());
            }
            else if(sp1.getSelectedItem().toString() == "ArcTan"){
                ResValue = Math.atan(rad);
                ans.setText(ResValue.toString());
            }
        }
        catch (NumberFormatException e){
            ed.setError("Invalid input");
        }

    }
}
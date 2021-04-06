package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Matrix extends AppCompatActivity {
    EditText row, col, val;
    Button matrix, bt2;
    TextView txt;
    String t;
    int i, j;
    int[][] mat = new int[3][3];
    int[][] mat2 = new int[3][3];
    int[][] addmat = new int[3][3];
    int[][] submat = new int[3][3];
    int[][] powmat = new int[3][3];
    int[][] mul = new int[3][3];
    String[][] result = new String[3][3];
    String[][] lowdia = new String[3][3];
    TextView[][] res = new TextView[3][3];
    EditText e[][] = new EditText[3][3];
    EditText e2[][] = new EditText[3][3];
    Button ins,square;
    Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        sp1 = findViewById(R.id.spinner2);
        String[] from = {"MATRIX A", "MATRIX B"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);
        Button AddMatrix = (Button) findViewById(R.id.button);
        Button SubMatrix = (Button) findViewById(R.id.button2);
        Button Multiplication = (Button) findViewById(R.id.button8);
        ins=(Button) findViewById(R.id.button10);
        square=(Button) findViewById(R.id.button9);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertMat();
            }
        });
        AddMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMat();
            }
        });
        SubMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubMat();
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SquareMat();
            }
        });
        Multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiplyMat();
            }
        });
    }
    public void InsertMat() {
        EditText ed1,ed2;
        ed1=findViewById(R.id.T11);
        ed2=findViewById(R.id.M11);
        try {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    String s = "T" + i + j;
                    e[i][j] = findViewById(getResources().getIdentifier(s, "id", getPackageName()));
                    mat[i][j] = Integer.parseInt(e[i][j].getText().toString());
                }
            }
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    String s = "M" + i + j;
                    e2[i][j] = findViewById(getResources().getIdentifier(s, "id", getPackageName()));
                    mat2[i][j] = Integer.parseInt(e2[i][j].getText().toString());
                }
            }
        } catch (NumberFormatException e) {
            ed1.setError("Invalid input");
            ed2.setError("Invalid input");
        }
    }


        public void AddMat()
    {
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                addmat[i][j]= mat[i][j]+mat2[i][j];
                result[i][j]=Integer.toString(addmat[i][j]);
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                //trans[i][j]=mat[j][i];
                String s="R"+i+j;
                res[i][j]= findViewById(getResources().getIdentifier(s,"id",getPackageName()));
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                res[i][j].setText(result[i][j]);
            }
        }
    }


    public void SubMat()
    {
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                submat[i][j]= mat[i][j]-mat2[i][j];
                result[i][j]=Integer.toString(submat[i][j]);
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                String s="R"+i+j;
                res[i][j]= findViewById(getResources().getIdentifier(s,"id",getPackageName()));
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                res[i][j].setText(result[i][j]);
            }
        }
    }

    public void MultiplyMat()
    {
        int a=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                mul[i][j] = 0;
                String s="R"+i+j;
                res[i][j]= findViewById(getResources().getIdentifier(s,"id",getPackageName()));
                for (int k = 0; k < 3; k++) {
                    mul[i][j] += mat[i][k] * mat2[k][j];
                }//end of k loop
            }
        }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                result[i][j]=Integer.toString(mul[i][j]);
                res[i][j].setText(result[i][j]);
            }
        }
    }

    public void SquareMat()
    {
        if (sp1.getSelectedItem().toString() == "MATRIX A") {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    powmat[i][j] = mat[i][j] * mat[i][j];
                    result[i][j] = Integer.toString(powmat[i][j]);
                }
            }
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    String s = "R" + i + j;
                    res[i][j] = findViewById(getResources().getIdentifier(s, "id", getPackageName()));
                }
            }
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    res[i][j].setText(result[i][j]);
                }
            }
        }
        else if(sp1.getSelectedItem().toString() == "MATRIX B") {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    powmat[i][j] = mat2[i][j] * mat2[i][j];
                    result[i][j] = Integer.toString(powmat[i][j]);
                }
            }
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    String s = "R" + i + j;
                    res[i][j] = findViewById(getResources().getIdentifier(s, "id", getPackageName()));
                }
            }
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    res[i][j].setText(result[i][j]);
                }
            }
        }
    }


}
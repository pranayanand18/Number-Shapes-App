package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int num;
        public boolean isSquare() {

            double squareRoot = Math.sqrt(num);
            if(squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular() {

            int x = 1, triangularNum = 1;
            while(triangularNum<num) {
                x++;
                triangularNum = triangularNum + x;
            }
            if(triangularNum == num) return true;
            else return false;
        }
    }

    public void testNumber(View v) {

        EditText editText = (EditText) findViewById(R.id.editTextNumber);

        String message;
        if(editText.getText().toString().isEmpty())
            message = "Please enter a number";
        else {
            Number myNum = new Number();
            myNum.num = Integer.parseInt(editText.getText().toString());
            message = editText.getText().toString();
            if (myNum.isSquare() && myNum.isTriangular()) {
                message += " is square and triangular.";
            } else if (myNum.isSquare())
                message += " is square but not triangular.";
            else if (myNum.isTriangular()) message += " is triangular but not square.";
            else message += " is neither triangular nor square";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
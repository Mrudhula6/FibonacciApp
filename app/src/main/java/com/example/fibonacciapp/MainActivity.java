package com.example.fibonacciapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnGenerate;
    ListView lvFibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnGenerate = findViewById(R.id.btnGenerate);
        lvFibonacci = findViewById(R.id.lvFibonacci);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etNumber.getText().toString();
                if (!input.isEmpty()) {
                    int n = Integer.parseInt(input);
                    ArrayList<String> fibonacciList = generateFibonacci(n);


                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, fibonacciList);
                    lvFibonacci.setAdapter(adapter);
                }
            }
        });
    }

    private ArrayList<String> generateFibonacci(int n) {
        ArrayList<String> list = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(a));
            int sum = a + b;
            a = b;
            b = sum;
        }
        return list;
    }
}

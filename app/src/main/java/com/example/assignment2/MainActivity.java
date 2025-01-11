package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button GradeBtn , VatBtn , BmiBtn , ExitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        GradeBtn = findViewById(R.id.GradeBtn);
        GradeBtn.setBackgroundColor(Color.parseColor("#964B00"));

        VatBtn = findViewById(R.id.VatBtn);
        VatBtn.setBackgroundColor(Color.parseColor("#964B00"));

        BmiBtn = findViewById(R.id.BmiBtn);
        BmiBtn.setBackgroundColor(Color.parseColor("#964B00"));

        ExitBtn = findViewById(R.id.ExitBtn);
        ExitBtn.setBackgroundColor(Color.parseColor("#964B00"));

        //ปุ่มเรียกไปหน้า calculate grade
        GradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculategradepage = new Intent(MainActivity.this , CalculateGrade.class);
                startActivity(calculategradepage); //ใช้เรียกตัวแปรให้ทำตามคำสั่งเพื่อเริ่มโปรแกรม
            }
        });

        //ปุ่มไปหน้า calculate vat product
        VatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculateVatpage = new Intent(MainActivity.this , CalculateVat.class);
                startActivity(calculateVatpage);
            }
        });

        //ปุ่มไป calculate BMI
        BmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculateBMIpage = new Intent(MainActivity.this , CalculateBMI.class);
                startActivity(calculateBMIpage);
            }
        });

        //ปุ่มออกโปรแกรม
        ExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
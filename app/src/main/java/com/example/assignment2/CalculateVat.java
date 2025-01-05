package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculateVat extends AppCompatActivity implements View.OnClickListener {

    private Button BackVatBtn;
    private EditText inputGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculate_vat);

        BackVatBtn = findViewById(R.id.BackVatBtn);
        BackVatBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        finish(); //คำสั่งปิดการใช้ calculate grade
    }
}
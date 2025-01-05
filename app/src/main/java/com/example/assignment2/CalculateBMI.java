package com.example.assignment2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculateBMI extends AppCompatActivity implements View.OnClickListener {

    private Button BackBtn;
    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculate_bmi);

        BackBtn = findViewById(R.id.BackBMIBtn);
        BackBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();

    }
}
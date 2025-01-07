package com.example.assignment2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculateBMI extends AppCompatActivity implements View.OnClickListener {

    private Button BackBMIBtn , CalBMIBtn;
    private EditText WeightInput , HeightInput , WeightBMI , HeightBMI , TotalBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculate_bmi);

        BackBMIBtn = findViewById(R.id.BackBMIBtn);
        BackBMIBtn.setOnClickListener(this);
        BackBMIBtn.setBackgroundColor(Color.parseColor("#964B00"));

        CalBMIBtn = findViewById(R.id.CalBMIBtn);
        CalBMIBtn.setOnClickListener(this);
        CalBMIBtn.setBackgroundColor(Color.parseColor("#964B00"));

        WeightInput = findViewById(R.id.WeightInput);
        WeightInput.setHint("ใส่น้ำหนักเป็นหน่วยกิโลกรัม");

        HeightInput = findViewById(R.id.HeightInput);
        HeightInput.setHint("ใส่ส่วนสูงเป็นหน่วยเซนติเมตร");

        WeightBMI = findViewById(R.id.WeightBMI);
        HeightBMI = findViewById(R.id.HeigthBMI);
        TotalBMI = findViewById(R.id.TotalBMI);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.CalBMIBtn) {
            calculate();
        } else if (v.getId() == R.id.BackBMIBtn){
            finish();
        }
    }

    public void calculate() {
        String weight = WeightInput.getText().toString();
        String height = HeightInput.getText().toString();

        String numberPattern = "^[0-9]+(\\.[0-9]+)?$";

        if (weight.isEmpty() || height.isEmpty()) {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();

        } else if (!weight.matches(numberPattern) || !height.matches(numberPattern)) {
            Toast.makeText(this, "กรุณากรอกข้อมูลเป็นตัวเลข", Toast.LENGTH_SHORT).show();

        } else {
            float inputWeight = Float.parseFloat(weight);
            float inputHeight = Float.parseFloat(height);

            float bmi = inputWeight / ((inputHeight / 100) * (inputHeight / 100));

            String resultWeight = String.format("%.2f" , inputWeight) + " กิโลกรัม";
            WeightBMI.setText(resultWeight);

            String resultHeight = String.format("%.2f" , inputHeight) + " เซนติเมตร";
            HeightBMI.setText(resultHeight);

            String resultTotal = String.format("%.2f" , bmi);
            TotalBMI.setText(resultTotal);

            // ล้างค่าหลังจากประมวลผล
            WeightInput.setText("");
            HeightInput.setText("");
        }
    }
}
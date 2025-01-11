package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.graphics.Color;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateGrade extends AppCompatActivity implements View.OnClickListener {

    private Button BackBtn , CalGradeBtn;
    private EditText InputScore , OutputGrade , ResultGrade ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculate_grade);

        InputScore = findViewById(R.id.InputScore);
        InputScore.setHint("ใส่ตัวเลข");

        OutputGrade = findViewById(R.id.OutputGrade);
        ResultGrade = findViewById(R.id.ResultGrade);

        //ปุ่มย้อนกลับหน้าหลัก
        BackBtn = findViewById(R.id.BackGradeBtn);
        BackBtn.setOnClickListener(this);
        BackBtn.setBackgroundColor(Color.parseColor("#964B00"));

        //ปุ่มคำนวณ
        CalGradeBtn = findViewById(R.id.CalGradeBtn);
        CalGradeBtn.setOnClickListener(this);
        CalGradeBtn.setBackgroundColor(Color.parseColor("#964B00"));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.CalGradeBtn) {
            calculate();
        } else if (v.getId() == R.id.BackGradeBtn) {
            finish();
        }
    }

    private void calculate() {
        String input = InputScore.getText().toString();

        if (!input.isEmpty()) {
            try {
                int score = Integer.parseInt(input);
                String grade = "";

                if (score >= 101) {
                    OutputGrade.setText("");
                    ResultGrade.setText("");
                    Toast.makeText(this, "คะแนน " + score + " ไม่ถูกต้อง",
                            Toast.LENGTH_SHORT).show();
                } else if (score >= 80) {
                    grade = "A";
                } else if (score >= 75) {
                    grade = "B+";
                } else if (score >= 70) {
                    grade = "B";
                } else if (score >= 65) {
                    grade = "C+";
                } else if (score >= 60) {
                    grade = "C";
                } else if (score >= 55) {
                    grade = "D+";
                } else if (score >= 50) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                if (score <= 100) {
                    OutputGrade.setText(String.valueOf(score));
                    ResultGrade.setText(grade);
                }
                InputScore.setText("");
                InputScore.setHint("ใส่ตัวเลข");
            } catch (NumberFormatException e) {
                //ถ้า score ไม่เป็นตัวเลขจะแจ้ง toast
                Toast.makeText(this, "กรุณากรอกคะแนนเป็นตัวเลข", Toast.LENGTH_SHORT).show();
            }
        } else {
            //ถ้า input empty จะ toast
            Toast.makeText(this, "กรุณากรอกคะแนน", Toast.LENGTH_SHORT).show();
        }
    }
}
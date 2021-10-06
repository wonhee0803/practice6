package com.example.practice6_ntom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.practice6_ntom.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> calc());
    }

    private void calc() {
        String start = binding.editStart.getText().toString();
        String  end = binding.editEnd.getText().toString();

        if (start.isEmpty() || end.isEmpty()) {
            Toast.makeText(this, "숫자를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        int startValue = Integer.parseInt(start);
        int endValue = Integer.parseInt(end);

        if (startValue > endValue) {
            Toast.makeText(this, "시작 값은 종료 값보다 작거나 같아야 합니다.", Toast.LENGTH_SHORT).show();
            return;
        }


        int calc = 0;
        for (int i = startValue; i <= endValue; i++) {
            calc += i;
        }

        binding.textResult.setText(Integer.toString(calc));
        binding.textResult.setVisibility(View.VISIBLE);
        binding.labelResult.setText(String.format("%d부터 %d 까지의 합은", startValue, endValue));
        binding.labelResult.setVisibility(View.VISIBLE);
    }
}
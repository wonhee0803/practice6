package com.example.practice6_ntom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.practice6_ntom.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> calc());
    }

    private void calc() {
        int start = Integer.parseInt(binding.editStart.getText().toString());
        int end = Integer.parseInt(binding.editEnd.getText().toString());

        if (start >= end) {
            binding.textResult.setText("시작 값은 종료 값보다 작거나 같아야 합니다.");
            return;
        }

        String label = String.format("%d부터 %d 까지의 합은", start, end);
        binding.textResult.setText(label);

        int result = 0;
        for (int i = 1; i <= end; i++) {
            result += i;
        }

        binding.textResult.setText(Integer.toString(result));
    }
}
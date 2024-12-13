package com.ssapps.dptv;

import android.os.Bundle;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ssapps.datepickertextview.OnDateChangedListener;
import com.ssapps.dptv.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.datePickerActions.setDate("04/10/2024");

        binding.datePickerActions.setOnDateChangedListener(new OnDateChangedListener() {
            @Override
            public void onDateChanged(String newDate) {
                Toast.makeText(getApplicationContext(), String.format("New data : %s",newDate), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
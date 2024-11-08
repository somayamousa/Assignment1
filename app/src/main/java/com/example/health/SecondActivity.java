package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button sleepButton = findViewById(R.id.sleepButton);
        Button nutritionButton = findViewById(R.id.nutritionButton);
        Button exerciseButton = findViewById(R.id.exerciseButton);

        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SleepInfoActivity when the Sleep button is clicked
                Intent intent = new Intent(SecondActivity.this, SleepInfoActivity.class);
                startActivity(intent);
            }
        });

        nutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle nutrition button click (you can add your code here)
                Intent intent = new Intent(SecondActivity.this, NutritionActivity.class);
                startActivity(intent);
            }
        });

        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle exercise button click (you can add your code here)
                Intent intent = new Intent(SecondActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });
    }
}

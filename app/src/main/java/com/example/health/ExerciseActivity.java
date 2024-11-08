package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        TextView infoTextView = findViewById(R.id.infoTextView);
        infoTextView.setText("Exercise is vital for maintaining a healthy body and mind. It offers various benefits, including:\n" +
                "- Weight management\n" +
                "- Improved cardiovascular health\n" +
                "- Enhanced mood and mental health\n" +
                "- Increased strength and flexibility\n" +
                "\n" +
                "Stay active and include regular exercise in your routine!");

        RadioGroup exerciseTypeRadioGroup = findViewById(R.id.exerciseTypeRadioGroup);
        Button showSelectedButton = findViewById(R.id.showSelectedButton);

        showSelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected exercise type
                int selectedTypeId = exerciseTypeRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedType = findViewById(selectedTypeId);
                String selectedTypeText = selectedType != null ? selectedType.getText().toString() : "No exercise type selected.";

                // Start ExerciseDetailActivity and pass the selected exercise type
                Intent intent = new Intent(ExerciseActivity.this, ExerciseDetailActivity.class);
                intent.putExtra("selectedExerciseType", selectedTypeText);
                startActivity(intent);
            }
        });
    }
}

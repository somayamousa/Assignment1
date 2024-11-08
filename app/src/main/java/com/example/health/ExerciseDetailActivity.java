package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        TextView detailTextView = findViewById(R.id.detailTextView);

        // Retrieve the selected exercise type from the intent
        Intent intent = getIntent();
        String selectedType = intent.getStringExtra("selectedExerciseType");

        // Determine the benefits based on selected exercise type
        String benefits;
        switch (selectedType) {
            case "Cardio":
                benefits = "Benefits of Cardio:\n" +
                        "- Improves heart health\n" +
                        "- Increases lung capacity\n" +
                        "- Burns calories\n" +
                        "- Enhances mood and reduces stress";
                break;
            case "Strength Training":
                benefits = "Benefits of Strength Training:\n" +
                        "- Builds muscle mass\n" +
                        "- Increases metabolism\n" +
                        "- Improves bone density\n" +
                        "- Boosts confidence";
                break;
            case "Flexibility Exercises":
                benefits = "Benefits of Flexibility Exercises:\n" +
                        "- Increases range of motion\n" +
                        "- Reduces risk of injury\n" +
                        "- Improves posture\n" +
                        "- Alleviates muscle soreness";
                break;
            default:
                benefits = "No benefits available.";
        }

        // Display the selected exercise type and its benefits
        String message = "Selected Exercise Type: " + selectedType + "\n\n" + benefits;
        detailTextView.setText(message);
    }
}

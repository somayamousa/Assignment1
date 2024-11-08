package com.example.health;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SleepInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_info);

        // Set up the sleep information text
        TextView infoTextView = findViewById(R.id.infoTextView);
        infoTextView.setText("Sleep is important for overall health. Good sleep affects various aspects, including:\n" +
                "- Improving memory\n" +
                "- Boosting immunity\n" +
                "- Enhancing mood\n" +
                "- Increasing focus and productivity\n" +
                "\n" +
                "Make sure to get enough sleep each night for good health.");

        Button showSelectedButton = findViewById(R.id.showSelectedButton);

        showSelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected checkboxes
                StringBuilder benefits = new StringBuilder("Selected Health Benefits:\n");
                CheckBox benefit1 = findViewById(R.id.benefit1);
                CheckBox benefit2 = findViewById(R.id.benefit2);
                CheckBox benefit3 = findViewById(R.id.benefit3);
                CheckBox benefit4 = findViewById(R.id.benefit4);

                if (benefit1.isChecked()) benefits.append("- ").append(benefit1.getText()).append("\n");
                if (benefit2.isChecked()) benefits.append("- ").append(benefit2.getText()).append("\n");
                if (benefit3.isChecked()) benefits.append("- ").append(benefit3.getText()).append("\n");
                if (benefit4.isChecked()) benefits.append("- ").append(benefit4.getText()).append("\n");

                // Display the selected benefits
                String message = benefits.length() > 0 ? benefits.toString() : "No benefits selected.";
                infoTextView.setText(message);
            }
        });
    }
}

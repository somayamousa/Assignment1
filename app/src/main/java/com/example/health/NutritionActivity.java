package com.example.health;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class NutritionActivity extends AppCompatActivity {
    private List<Nutrition> nutritionList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        initializeNutritionData();

        Spinner spinner = findViewById(R.id.nutritionSpinner);
        Button showNutritionButton = findViewById(R.id.showNutritionButton);
        listView = findViewById(R.id.nutritionListView);
        ImageView nutritionImageView = findViewById(R.id.nutritionImageView);

        List<String> foodItems = new ArrayList<>();
        for (Nutrition nutrition : nutritionList) {
            foodItems.add(nutrition.getFoodItem());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, foodItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        showNutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedFood = spinner.getSelectedItem().toString();
                List<String> nutritionInfo = getNutritionInfo(selectedFood);

                ArrayAdapter<String> nutritionAdapter = new ArrayAdapter<>(NutritionActivity.this, android.R.layout.simple_list_item_1, nutritionInfo);
                listView.setAdapter(nutritionAdapter);

                // Change the image based on the selected food
                int imageResId = getImageResId(selectedFood);
                nutritionImageView.setImageResource(imageResId);

                // Set up click listener for each item in the listView
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem = (String) parent.getItemAtPosition(position);
                        Toast.makeText(NutritionActivity.this, "Selected Info: " + selectedItem, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initializeNutritionData() {
        nutritionList = new ArrayList<>();
        nutritionList.add(new Nutrition("Apple", 52.0, R.drawable.apple_image)); // Replace with your actual image resource
        nutritionList.add(new Nutrition("Banana", 89.0, R.drawable.banana_image)); // Replace with your actual image resource
        nutritionList.add(new Nutrition("Chicken", 239.0, R.drawable.chicken_image)); // Replace with your actual image resource
        // Add more nutrition data as needed
    }

    private List<String> getNutritionInfo(String foodItem) {
        for (Nutrition nutrition : nutritionList) {
            if (nutrition.getFoodItem().equals(foodItem)) {
                List<String> info = new ArrayList<>();
                info.add("Food Item: " + nutrition.getFoodItem());
                info.add("Calories: " + nutrition.getCalories());
                return info;
            }
        }
        return new ArrayList<>();
    }

    private int getImageResId(String foodItem) {
        for (Nutrition nutrition : nutritionList) {
            if (nutrition.getFoodItem().equals(foodItem)) {
                return nutrition.getImageResId();
            }
        }
        return 0; // Default image or 0 if not found
    }
}

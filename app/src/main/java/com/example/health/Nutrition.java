package com.example.health;

public class Nutrition {
    private String foodItem;
    private double calories;
    private int imageResId; // Resource ID for the image

    public Nutrition(String foodItem, double calories, int imageResId) {
        this.foodItem = foodItem;
        this.calories = calories;
        this.imageResId = imageResId;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public double getCalories() {
        return calories;
    }

    public int getImageResId() {
        return imageResId;
    }
}

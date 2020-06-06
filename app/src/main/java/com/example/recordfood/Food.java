package com.example.recordfood;

public class Food {

    private String foodName;
    private double foodCalorie;

    public Food(String foodName, double foodCalorie) {
        this.foodName = foodName;
        this.foodCalorie = foodCalorie;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodCalorie() {
        return foodCalorie;
    }

    public void setFoodCalorie(double foodCalorie) {
        this.foodCalorie = foodCalorie;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodCalorie=" + foodCalorie +
                '}';
    }
}

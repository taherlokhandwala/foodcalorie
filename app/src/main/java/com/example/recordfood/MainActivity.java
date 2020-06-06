package com.example.recordfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtFood;
    private Button btnAddFood;
    private RecyclerView recViewFood;
    private ArrayList<Food> foodItems = new ArrayList<>();
    private ApiInterface apiInterface;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxtFood = findViewById(R.id.editTxtFood);
        btnAddFood = findViewById(R.id.btnAddFood);
        recViewFood = findViewById(R.id.recViewFood);

        adapter = new FoodAdapter();
        adapter.setFoodItems(foodItems);
        recViewFood.setAdapter(adapter);
        recViewFood.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q = editTxtFood.getText().toString();
                Call<Food> call = apiInterface.getFoodCalorie(q);
                call.enqueue(new Callback<Food>() {
                    @Override
                    public void onResponse(Call<Food> call, Response<Food> response) {
                        if(response.body()!=null){
                            foodItems.add(new Food(response.body().getFoodName(),response.body().getFoodCalorie()));
                            adapter.notifyDataSetChanged();
                        }else{
                            Toast.makeText(MainActivity.this, "Food Item Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Food> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }



}
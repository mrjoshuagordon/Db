package com.jh.db;


import java.util.HashMap;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditFood extends Activity{
    
    EditText food_name;
    EditText protein_name;
    EditText fat_name;
    EditText carb_name;
    EditText fiber_name;
    EditText restaurant;
    EditText calories_name;
 
    
  

    
    public void onCreate(Bundle savedInstanceState){
        
        TestAdapter mDbHelper = new TestAdapter(this);         
        mDbHelper.createDatabase();       
        mDbHelper.open(); 
        
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_food);
        restaurant = (EditText) findViewById(R.id.restaurant);
        calories_name = (EditText) findViewById(R.id.calories_name);
        food_name= (EditText) findViewById(R.id.food_name);
        protein_name = (EditText) findViewById(R.id.protein_name);
        fat_name = (EditText) findViewById(R.id.fat_name);
        carb_name = (EditText) findViewById(R.id.carb_name);
        fiber_name = (EditText) findViewById(R.id.fiber_name);
        
        Intent theIntent = getIntent();
        
        String foodId = theIntent.getStringExtra("foodId");
        
        HashMap<String, String> foodList = mDbHelper.getFoodInfo(foodId);
        
        if(foodList.size() != 0){
            
            food_name.setText(foodList.get("food_name"));
            restaurant.setText(foodList.get("restaurant"));
            calories_name.setText(foodList.get("calories_name"));
            protein_name.setText(foodList.get("protein_name"));
            fat_name.setText(foodList.get("fat_name"));
            carb_name.setText(foodList.get("carb_name"));
            fiber_name.setText(foodList.get("fiber_name"));
            
        }
    }
    

    
    public void callMainActivity(View view){
        
        Intent objIntent = new Intent(getApplication(), NextActivity2.class);
        
        startActivity(objIntent);
        
    }
    
}
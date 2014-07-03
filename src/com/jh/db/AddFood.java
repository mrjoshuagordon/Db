package com.jh.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



import java.util.HashMap;

public class AddFood extends Activity{

    

    EditText food_name;
    EditText protein_name;
    EditText fat_name;
    EditText carb_name;
    EditText fiber_name;
    EditText restaurant;
    EditText category;
    EditText calories_name;
 
    

    
    public void onCreate(Bundle savedInstanceState){
        
      
        
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food);
   
     
        
        
    }
    

    
    
    public void AddEmployee(View v)
    {
        
        
        TestAdapter mDbHelper = new TestAdapter(this);         
        mDbHelper.createDatabase();       
        mDbHelper.open(); 
        
        restaurant = (EditText) findViewById(R.id.restaurant);
        category = (EditText) findViewById(R.id.food_name); 
        food_name = (EditText) findViewById(R.id.food_name);       
//        calories_name = (EditText) findViewById(R.id.calories_name);
//        protein_name = (EditText) findViewById(R.id.protein_name);
//        fat_name = (EditText) findViewById(R.id.fat_name);
//        carb_name = (EditText) findViewById(R.id.carb_name);
//        fiber_name = (EditText) findViewById(R.id.fiber_name);
        
      
        String restaurant_text = restaurant.getText().toString();
        String food_name_text = food_name.getText().toString();
        String category_name_text = category.getText().toString();
        double fill = 0.0;
//        String calories_name_text = calories_name.getText().toString();
//        String protein_name_text = protein_name.getText().toString();
//        String fat_name_text = fat_name.getText().toString();
//        String carb_name_text = carb_name.getText().toString();
//        String fiber_name_text = fiber_name.getText().toString();
     
        
        
        mDbHelper.AddEmployee(restaurant_text,  category_name_text, food_name_text, fill,fill, fill, fill, fill);
        
        mDbHelper.close();  
        
        
        
        Utility.ShowMessageBox(this,"Data saved.");
        
        this.callMain(v);
 
    }
    
    
    
    
    
    
    
    
    
    
    public void EditFoodMethod(View v)
    {
        
        TestAdapter mDbHelper = new TestAdapter(this);         
        mDbHelper.createDatabase();       
        mDbHelper.open(); 
        
        Intent theIntent = getIntent();
        
        String foodId = theIntent.getStringExtra("foodId");
        
        restaurant = (EditText) findViewById(R.id.restaurant);
        food_name= (EditText) findViewById(R.id.food_name);       
        calories_name = (EditText) findViewById(R.id.calories_name);
        protein_name = (EditText) findViewById(R.id.protein_name);
        fat_name = (EditText) findViewById(R.id.fat_name);
        carb_name = (EditText) findViewById(R.id.carb_name);
        fiber_name = (EditText) findViewById(R.id.fiber_name);
        
        
       // Name = (EditText) findViewById(R.id.Name);
      //  Email = (EditText) findViewById(R.id.Email);
     //   String email = Email.getText().toString();
        String restaurant_edit = restaurant.getText().toString();       
        String food_name_edit = food_name.getText().toString();
        String calories_name_edit = calories_name.getText().toString();
        String protein_name_edit = protein_name.getText().toString();
        String fat_name_edit = fat_name.getText().toString();
        String carb_name_edit = carb_name.getText().toString();
        String fiber_name_edit = fiber_name.getText().toString();
       
        
        
       
        
       mDbHelper.EditFoodMethod(restaurant_edit, calories_name_edit,food_name_edit, protein_name_edit,fat_name_edit, carb_name_edit, fiber_name_edit,foodId);
       
       mDbHelper.close(); 
       
       Utility.ShowMessageBox(this,"Data saved.");
       
       this.callMain(v);
       
     
        
    }
    
    
    
    
    
//    
//    
//    
//    
//    
//    
//    
//public void editFood(View view){
//        
//        HashMap<String, String> queryValuesMap = new HashMap<String, String>();
//     
//        
//        Intent theIntent = getIntent();
//        
//        String foodId = theIntent.getStringExtra("foodId");
//        
//        queryValuesMap.put("foodId", foodId);
//        queryValuesMap.put("food_name", food_name.getText().toString());
//        queryValuesMap.put("protein_name", protein_name.getText().toString());
//        queryValuesMap.put("fat_name", fat_name.getText().toString());
//        queryValuesMap.put("carb_name", carb_name.getText().toString());
//        queryValuesMap.put("fiber_name", fiber_name.getText().toString());
//        
//        dbTools.updateFood(queryValuesMap);
//        this.callMain(view);
//        
//    }
//    
    public void callMain(View view){
        
        Intent objIntent = new Intent(getApplication(), MainActivity.class);
        
        startActivity(objIntent);
        
    }
    
    
    public void callMainActivity(View view){
        
        Intent objIntent = new Intent(getApplication(), NextActivity2.class);
        
        startActivity(objIntent);
        
    }
    
}

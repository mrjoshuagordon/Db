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
 
    
    DBTools dbTools = new DBTools(this);

    
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
    

    
//    public void SaveEmployee(View v)
//    {
//    EditText food_name = (EditText)findViewById(R.id.food_name);
//    EditText restaurant = (EditText)findViewById(R.id.restaurant);
//   
//    String foodString = food_name.getText().toString();
//    String restaurantString = restaurant.getText().toString();
//   
//   
//    TestAdapter mDbHelper = new TestAdapter(this);
//    mDbHelper.createDatabase();
//    mDbHelper.open();
//   
//    if(mDbHelper.SaveEmployee(foodString, restaurantString))
//    {
//    Utility.ShowMessageBox(this,"Data saved.");
//    }
//    else
//    {
//    Utility.ShowMessageBox(this,"OOPS try again!");
//    }
//    
//    }
//    
    
    
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
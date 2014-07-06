package com.jh.db;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
   
     
        // get action bar   
        ActionBar actionBar = getActionBar();
 
        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
        
    }
    

    
    
    public void AddEmployee(View v)
    {
        
        
        TestAdapter mDbHelper = new TestAdapter(this);         
        mDbHelper.createDatabase();       
        mDbHelper.open(); 
        
        restaurant = (EditText) findViewById(R.id.restaurant);
        category = (EditText) findViewById(R.id.food_name); 
        food_name = (EditText) findViewById(R.id.food_name);       
        calories_name = (EditText) findViewById(R.id.calories_name);
        protein_name = (EditText) findViewById(R.id.protein_name);
        fat_name = (EditText) findViewById(R.id.fat_name);
        carb_name = (EditText) findViewById(R.id.carb_name);
        fiber_name = (EditText) findViewById(R.id.fiber_name);
        
//        double calories_name_text = 0.0;
//        double protein_name_text = 0.0;
//        double fat_name_text = 0.0;
//        double carb_name_text = 0.0;
//        double fiber_name_text = 0.0;
        
        double calories_name_text1;
        double protein_name_text1;
        double fat_name_text1;
        double carb_name_text1;
        double fiber_name_text1;
        
        String restaurant_text = restaurant.getText().toString();
        String food_name_text = food_name.getText().toString();
        String category_name_text = category.getText().toString();
        
        String temp_cal = calories_name.getText().toString();        
        if(temp_cal == null || temp_cal == "" || temp_cal.length()==0 ){ calories_name_text1 = 0.0; } else{ calories_name_text1 =  Double.parseDouble(temp_cal); }
     
        String temp_pro = protein_name.getText().toString();        
        if(temp_pro == null || temp_pro == "" || temp_pro.length()==0 ){ protein_name_text1 = 0.0; } else{ protein_name_text1 =  Double.parseDouble(temp_pro); }
        
        String temp_fat = fat_name.getText().toString();        
        if(temp_fat == null || temp_fat == "" || temp_fat.length()==0 ){ fat_name_text1 = 0.0; } else{ fat_name_text1 =  Double.parseDouble(temp_fat); }
     
        String temp_carb = carb_name.getText().toString();        
        if(temp_carb == null || temp_carb == "" || temp_carb.length()==0 ){ carb_name_text1 = 0.0; } else{ carb_name_text1 =  Double.parseDouble(temp_carb); }
     
        String temp_fiber = fiber_name.getText().toString();        
        if(temp_fiber == null || temp_fiber == "" || temp_fiber.length()==0 ){ fiber_name_text1 = 0.0; } else{ fiber_name_text1 =  Double.parseDouble(temp_fiber); }
     
        

        
        
//        String temp_pro = protein_name.getText().toString();
//        protein_name_text1 = (double) Double.parseDouble(temp_pro);
//        
//        String temp_fat = fat_name.getText().toString();
//        fat_name_text1 = (double) Double.parseDouble(temp_fat);
//        
//        String temp_carb = carb_name.getText().toString();
//        carb_name_text1 = (double) Double.parseDouble(temp_carb);
//        
//        String temp_fiber = fiber_name.getText().toString();
//        fiber_name_text1 = (double) Double.parseDouble(temp_fiber);
      
           
        
        //  calories_name_text = Double.parseDouble(calories_name.getText().toString());
    //    protein_name_text = Double.parseDouble(protein_name.getText().toString());
  //      fat_name_text = Double.parseDouble(fat_name.getText().toString());
   //     carb_name_text = Double.parseDouble(carb_name.getText().toString());
   //     fiber_name_text = Double.parseDouble(fiber_name.getText().toString());
        
        
        
        
        
   //     double fill = 0.0;
//        String calories_name_text = calories_name.getText().toString();
//        String protein_name_text = protein_name.getText().toString();
//        String fat_name_text = fat_name.getText().toString();
//        String carb_name_text = carb_name.getText().toString();
//        String fiber_name_text = fiber_name.getText().toString();
     
        
        
        mDbHelper.AddEmployee(restaurant_text,  category_name_text, food_name_text, calories_name_text1,
                protein_name_text1, fat_name_text1,carb_name_text1, fiber_name_text1);
        
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
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
    
    // Called when a options menu item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // We check what menu item was clicked and show a Toast
        if (id == R.id.action_settings) {

            // A DialogFragment is a Fragment you can place over top
            // the current Activity. A Fragment is like an interface
            // block that you can place into an Activity.
            // The FrgamentManager allows you to interact with the
            // Fragment
            DialogFragment myFragment = new MyDialogFragment();

            myFragment.show(getFragmentManager(), "theDialog");

            return true;

            // If exit was clicked close the app
        } else if (id == R.id.add_food) {
            Intent i = new Intent(AddFood.this, AddFood.class);
            startActivity(i);
          
            return true;
        }
        else if (id == R.id.activity_main) {
            Intent h = new Intent(AddFood.this, MainActivity.class);
            startActivity(h);
            
            return true;
        }
        else if (id == R.id.exit_the_app) {
            finish();
            return true;
        }else if (id == R.id.contact_me) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","josh@jganalytics.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MenuFind");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
            
            
     
            
            
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    
    
    
}

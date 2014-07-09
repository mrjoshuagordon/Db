package com.jganalytics.menufind;


import java.util.HashMap;


import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
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
        

        // get action bar   
      //  ActionBar actionBar = getActionBar();
 
        // Enabling Up / Back navigation
      //  actionBar.setDisplayHomeAsUpEnabled(true);
        
        
        
        
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
    
    
    public void goAddFood (View view){
        
        Intent objIntent = new Intent(getApplication(), AddFood.class);
        
        startActivity(objIntent);
        
    }
    
    
    
    public void goMapRest (View view){
        
        
        TestAdapter mDbHelper = new TestAdapter(this);         
        mDbHelper.createDatabase();       
        mDbHelper.open(); 
        
        Intent theIntent = getIntent();
        

        
        restaurant = (EditText) findViewById(R.id.restaurant);
        String restaurant_edit = restaurant.getText().toString();  
        
        String provider;
       // LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
      //  boolean enabled = service
       //   .isProviderEnabled(LocationManager.GPS_PROVIDER);

        // check if enabled and if not send user to the GSP settings
        // Better solution would be to display a dialog and suggesting to 
        // go to the settings
        
        
        try {
            LocationManager service = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            service.isProviderEnabled(LocationManager.GPS_PROVIDER);
            Criteria criteria = new Criteria();
            provider = service.getBestProvider(criteria, false);
            Location location = service.getLastKnownLocation(provider);
            
            double lat = (double) (location.getLatitude());
            double lng = (double) (location.getLongitude());
          
            String uri =  "geo:"+ lat + "," + lng  +  "?q=" + restaurant_edit;
            
            startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
        } catch (Exception e) {
            DialogFragment myFragment = new GPSDialogFragment();

            myFragment.show(getFragmentManager(), "theDialog");
            
         
            
           // String uri =  "geo:"+ "0" + "," + "0"  +  "?q=" + restaurant_edit;
            
           // startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
        }
        
     
//        try{
//        if (!enabled) {
//            Intent gpsOptionsIntent = new Intent(  
//                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);  
//                startActivity(gpsOptionsIntent);
//          
//        } 
//        } catch (Exception e) {}
        
         // LocationManager locationManager;
          // Get the location manager
        //  locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
          // Define the criteria how to select the locatioin provider -> use
          // default
       
    //      Intent myIntent = new Intent(EditFood.this, MenuMap.class);
      //    myIntent.putExtra("key", uri);
          // myIntent.putExtra("key", name); //Optional parameters

      //    EditFood.this.startActivity(myIntent); 
          
   
        
       // Intent objIntent = new Intent(getApplication(), MenuMap.class);
        
      //  startActivity(objIntent);
        
    }
    
    
    
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
            Intent i = new Intent(EditFood.this, AddFood.class);
            startActivity(i);
          
            return true;
        }
        else if (id == R.id.activity_main) {
            Intent h = new Intent(EditFood.this, MainActivity.class);
            startActivity(h);
            
            return true;
        }
       else if (id == R.id.contact_me) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","josh@jganalytics.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MenuFind");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
            
            
     
            
            
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    
    
}
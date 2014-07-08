
package com.jganalytics.menufind;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;








import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView lv;
    public String orderBy;
    public String sortBy;
  
    
    
    public void onCreate(Bundle savedInstanceState) {
        

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calc = (Button) findViewById(R.id.btnCalculate);

        // queryName.addTextChangedListener(queryNameListener);
        // setContentView(R.layout.activity_main);

        // TestAdapter mDbHelper = new TestAdapter(this);
        // mDbHelper.createDatabase();
        // mDbHelper.open();

        // lv = (ListView) findViewById(R.id.listView1);
        // List<String> testdata = new ArrayList<String>();
        // testdata.add("foo");
        // testdata.add("bar");

        // testdata = mDbHelper.getArrayTestData();

        //
        //
        // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
        // this,
        // android.R.layout.simple_list_item_1,
        // testdata );
        //
        // lv.setAdapter(arrayAdapter);
        //
        // mDbHelper.close();

    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
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
            Intent i = new Intent(MainActivity.this, AddFood.class);
            startActivity(i);
          
            return true;
        }
        else if (id == R.id.activity_main) {
            Intent h = new Intent(MainActivity.this, MainActivity.class);
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
    
    
    
    
    
    
    
//     public void SaveEmployee(View v)
//     {
//     EditText txtName = (EditText)findViewById(R.id.txtName);
//     EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
//    
//     String name = txtName.getText().toString();
//     String email = txtEmail.getText().toString();
//    
//    
//     TestAdapter mDbHelper = new TestAdapter(this);
//     mDbHelper.createDatabase();
//     mDbHelper.open();
//    
//     if(mDbHelper.SaveEmployee(name, email))
//     {
//     Utility.ShowMessageBox(this,"Data saved.");
//     }
//     else
//     {
//     Utility.ShowMessageBox(this,"OOPS try again!");
//     }
//     }
    //
    // public void LoadEmployee(View v)
    // {
    // TestAdapter mDbHelper = new TestAdapter(this);
    // mDbHelper.createDatabase();
    // mDbHelper.open();
    //
    // Cursor testdata = mDbHelper.getTestData();
    //
    // String name = Utility.GetColumnValue(testdata, "Name");
    // String email = Utility.GetColumnValue(testdata, "Email");
    //
    // Utility.ShowMessageBox(this, "Name: "+ name + " and Email: "+ email);
    // mDbHelper.close();
    // }
    //
    //
    public void goForward(View v) {

        Intent myIntent = new Intent(MainActivity.this, NextActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);

    }

    public void goToNew(View v) {
        EditText queryName = (EditText) findViewById(R.id.queryName);
        String name = queryName.getText().toString();

        Intent myIntent = new Intent(MainActivity.this, NextActivity1.class);
        myIntent.putExtra("key", name); // Optional parameters
        MainActivity.this.startActivity(myIntent);

    }
    
    
    
    
    public void clearSearch(View v) {
        
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();

        overridePendingTransition(0, 0);
        startActivity(intent);

    }
    

    public void goToNew2(View v) {
       
        String querySort;
       
        EditText queryName = (EditText) findViewById(R.id.queryName);
        EditText calorieNameMin = (EditText) findViewById(R.id.calorieNameMin);
        EditText calorieNameMax = (EditText) findViewById(R.id.calorieNameMax);
        EditText proteinNameMin = (EditText) findViewById(R.id.proteinNameMin);
        EditText proteinNameMax = (EditText) findViewById(R.id.proteinNameMax);
        EditText fatNameMin = (EditText) findViewById(R.id.fatNameMin);
        EditText fatNameMax = (EditText) findViewById(R.id.fatNameMax);
        EditText carbNameMin = (EditText) findViewById(R.id.carbNameMin);
        EditText carbNameMax = (EditText) findViewById(R.id.carbNameMax);
        EditText fiberNameMin = (EditText) findViewById(R.id.fiberNameMin);
        EditText fiberNameMax = (EditText) findViewById(R.id.fiberNameMax);
        EditText searchName = (EditText) findViewById(R.id.searchName);
        EditText searchRestaurant = (EditText) findViewById(R.id.searchRestaurant);
//        
//        CheckBox checkBox = (CheckBox) findViewById(R.id.cbProtein);
//        if (checkBox.isChecked()) {
//          querySort = "protein_name"; 
//        } else{
//          querySort = "fat_name";
//        }
        
        RadioGroup g = (RadioGroup) findViewById(R.id.radioMacro); 
        
        
       switch (g.getCheckedRadioButtonId())
       {
       case R.id.radioCalories:
           orderBy = "calories_name";
       break;
        
       case R.id.radioProtein:
           orderBy = "protein_name";
       break;
       
       case R.id.radioFat:
           orderBy = "fat_name";
       break;
       
       
       case R.id.radioCarb:
           orderBy = "carb_name";
       break;
       
       case R.id.radioFiber:
           orderBy = "fiber_name";
       break;
       
       
       
       }
       
       
       RadioGroup o = (RadioGroup) findViewById(R.id.radioSort); 
       
       
       switch (o.getCheckedRadioButtonId())
       {
       case R.id.sortASC:
           sortBy = "ASC";
       break;
        
       case R.id.sortDESC:
           sortBy = "DESC";
       break;
            
       
       }
       
       
       
       //    String orderBy = null;
        
//        if(querySort== "radioCalories"){  orderBy = "calories_name"; }
//        if(querySort== "radioProtein"){   orderBy = "protein_name"; }
//        if(querySort== "radioFat"){   orderBy = "fat_name"; }
//        if(querySort== "radioCarb"){   orderBy = "carb_name"; }
//        if(querySort== "radioFiber"){  orderBy = "fiber_name"; }

        
        
        
        
        
        String noResults = queryName.getText().toString();
        String calorieMin = calorieNameMin.getText().toString();
        String calorieMax = calorieNameMax.getText().toString();
        String proteinMin = proteinNameMin.getText().toString();
        String proteinMax = proteinNameMax.getText().toString();
        String fatMin = fatNameMin.getText().toString();
        String fatMax = fatNameMax.getText().toString();
        String carbMin = carbNameMin.getText().toString();
        String carbMax = carbNameMax.getText().toString();
        String fiberMin = fiberNameMin.getText().toString();
        String fiberMax = fiberNameMax.getText().toString();
        String searchNameInput = searchName.getText().toString();
        String searchRestaurantInput = searchRestaurant.getText().toString();
       
        String params[] = {
               // noResults, proteinMin, proteinMax, querySort
                 noResults, calorieMin,calorieMax, proteinMin, proteinMax, fatMin, 
                 fatMax, carbMin, carbMax, fiberMin, fiberMax, orderBy, sortBy, searchNameInput,
                 searchRestaurantInput
        };

        Intent myIntent = new Intent(MainActivity.this, NextActivity2.class);
        myIntent.putExtra("key", params);
        // myIntent.putExtra("key", name); //Optional parameters

        MainActivity.this.startActivity(myIntent);

    }
    
    
   

}

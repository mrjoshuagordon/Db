package com.jh.db;



import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;






import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NextActivity2 extends ListActivity {
    TextView foodId;

    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        String[] value1 = intent.getStringArrayExtra("key"); 

     
        
        
        
        //value1 = value1 + 5;
        
        setContentView(R.layout.tvlay3);
    
       // setContentView(R.layout.activity_main); 
        
        
        
        
        
          TestAdapter mDbHelper = new TestAdapter(this);         
          mDbHelper.createDatabase();       
          mDbHelper.open(); 
          
          ArrayList<HashMap<String, String>> foodList =  mDbHelper.getArrayTestDataNew2(value1);  
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          if(foodList.size()!=0) {
              
              // Get the ListView and assign an event handler to it
              
              ListView listView = getListView();
              listView.setOnItemClickListener(new OnItemClickListener() {
                  
                  public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                      
                      // When an item is clicked get the TextView
                      // with a matching checkId
                      
                      foodId = (TextView) view.findViewById(R.id.foodId);
                      
                      // Convert that contactId into a String
                      
                      String foodIdValue = foodId.getText().toString();   
                      
                      // Signals an intention to do something
                      // getApplication() returns the application that owns
                      // this activity
                      
                      Intent  theIndent = new Intent(getApplication(),EditFood.class);
                      
                      // Put additional data in for EditContact to use
                      
                      theIndent.putExtra("foodId", foodIdValue); 
                      
                      // Calls for EditContact
                      
                      startActivity(theIndent); 
                  }
              }); 
              
           
       //   lv = (ListView) findViewById(R.id.listView1); 
        //  List<String> testdata = new ArrayList<String>();
        //  testdata.add("foo");
       //  testdata.add(value1.toString());
          
          
          ListAdapter adapter = new SimpleAdapter( NextActivity2.this,foodList, 
                  R.layout.food_entry1, new String[] { "foodId","restaurant","food_name", "calories_name", "protein_name", "fat_name", "carb_name"},
                  new int[] {R.id.foodId,R.id.restaurant, R.id.food_name, R.id.calories_name, R.id.protein_name, R.id.fat_name, R.id.carb_name});
          
          // setListAdapter provides the Cursor for the ListView
          // The Cursor provides access to the database data
          
          setListAdapter(adapter);
         
          }
//          testdata = mDbHelper.getArrayTestDataNew2(value1); 
//           
//          
//     
//          
//          ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                  this, 
//                  android.R.layout.simple_list_item_1,
//                  testdata );
//
//          lv.setAdapter(arrayAdapter); 
          
          mDbHelper.close();
    
          
          // get action bar   
          ActionBar actionBar = getActionBar();
   
          // Enabling Up / Back navigation
          actionBar.setDisplayHomeAsUpEnabled(true);
          
          
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
            Intent i = new Intent(NextActivity2.this, AddFood.class);
            startActivity(i);
          
            return true;
        }
        else if (id == R.id.activity_main) {
            Intent h = new Intent(NextActivity2.this, MainActivity.class);
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

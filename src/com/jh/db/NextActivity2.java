package com.jh.db;



import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NextActivity2 extends ListActivity {
    

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
    
    }
}

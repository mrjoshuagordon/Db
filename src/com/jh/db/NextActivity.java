package com.jh.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NextActivity  extends Activity {
    

    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acts);
    
       // setContentView(R.layout.activity_main); 
        
          TestAdapter mDbHelper = new TestAdapter(this);         
          mDbHelper.createDatabase();       
          mDbHelper.open(); 
           
          lv = (ListView) findViewById(R.id.listView1); 
          List<String> testdata = new ArrayList<String>();
        //  testdata.add("foo");
        // testdata.add("bar");
          
          testdata = mDbHelper.getArrayTestData(); 
           
          
     
          
          ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                  this, 
                  android.R.layout.simple_list_item_1,
                  testdata );

          lv.setAdapter(arrayAdapter); 
          
          mDbHelper.close();
    
    }
}

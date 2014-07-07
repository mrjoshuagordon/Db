package com.jganalytics.menufind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

public class NextActivity1  extends Activity {
    

    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        String value1 = intent.getStringExtra("key"); 
      //  Double value1;
       // String value1;
        
//        try{
//           value1 = Double.parseDouble(value); 
//          // value1 = Double.parseDouble(value); 
//        } catch (Exception e){
//            value1 = "Joshua Gordon";
//            
//        }
        
        //value1 = value1 + 5;
        
        setContentView(R.layout.tvlay);
    
       // setContentView(R.layout.activity_main); 
        
          TestAdapter mDbHelper = new TestAdapter(this);         
          mDbHelper.createDatabase();       
          mDbHelper.open(); 
           
          lv = (ListView) findViewById(R.id.listView1); 
          List<String> testdata = new ArrayList<String>();
        //  testdata.add("foo");
       //  testdata.add(value1.toString());
          
          testdata = mDbHelper.getArrayTestDataNew(value1); 
           
          
     
          
          ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                  this, 
                  android.R.layout.simple_list_item_1,
                  testdata );

          lv.setAdapter(arrayAdapter); 
          
          mDbHelper.close();
    
    }
}

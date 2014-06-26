
package com.jh.db;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView lv;
   
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button calc = (Button) findViewById(R.id.btnCalculate);
        
    
        
        //    queryName.addTextChangedListener(queryNameListener);
       // setContentView(R.layout.activity_main); 
        
      //    TestAdapter mDbHelper = new TestAdapter(this);         
       //   mDbHelper.createDatabase();       
      //    mDbHelper.open(); 
           
      //    lv = (ListView) findViewById(R.id.listView1); 
     //     List<String> testdata = new ArrayList<String>();
        //  testdata.add("foo");
        // testdata.add("bar");
          
      //    testdata = mDbHelper.getArrayTestData(); 
           
          
//     
//          
//          ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                  this, 
//                  android.R.layout.simple_list_item_1,
//                  testdata );
//
//          lv.setAdapter(arrayAdapter); 
//          
//          mDbHelper.close();
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    public void SaveEmployee(View v)
    {
    	EditText txtName = (EditText)findViewById(R.id.txtName);
    	EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
    	
    	String name = txtName.getText().toString();
    	String email = txtEmail.getText().toString();
    	
    	
    	TestAdapter mDbHelper = new TestAdapter(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	
    	if(mDbHelper.SaveEmployee(name, email))
    	{
    		Utility.ShowMessageBox(this,"Data saved.");
    	}
    	else
    	{
    		Utility.ShowMessageBox(this,"OOPS try again!");
    	}
    }
    
    public void LoadEmployee(View v)
    {
    	TestAdapter mDbHelper = new TestAdapter(this);         
    	mDbHelper.createDatabase();       
    	mDbHelper.open(); 
    	 
    	Cursor testdata = mDbHelper.getTestData(); 
    	 
    	String name = Utility.GetColumnValue(testdata, "Name");
    	String email = Utility.GetColumnValue(testdata, "Email");
    	
    	Utility.ShowMessageBox(this, "Name: "+ name + " and Email: "+ email);
    	mDbHelper.close();
    }
    
    
    public void goForward(View v){
        
        
        Intent myIntent = new Intent(MainActivity.this, NextActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);
        
        
    }
    
   
    
  public void goToNew(View v){
        EditText queryName = (EditText) findViewById(R.id.queryName); 
        String name = queryName.getText().toString();
       
        Intent myIntent = new Intent(MainActivity.this, NextActivity1.class);
       myIntent.putExtra("key", name); //Optional parameters
        MainActivity.this.startActivity(myIntent);
        
        
    } 
    

    
    
    
    
    
}

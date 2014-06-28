package com.jh.db;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.util.Log; 
import android.widget.ArrayAdapter;
import android.widget.TextView;

 
public class TestAdapter  
{ 
    protected static final String TAG = "DataAdapter"; 
    public ArrayList<String> results = new ArrayList<String>();
    private final Context mContext; 
    private SQLiteDatabase mDb; 
    private DataBaseHelper mDbHelper; 
 
    public TestAdapter(Context context)  
    { 
        this.mContext = context; 
        mDbHelper = new DataBaseHelper(mContext); 
    } 
 
    public TestAdapter createDatabase() throws SQLException  
    { 
        try  
        { 
            mDbHelper.createDataBase(); 
        }  
        catch (IOException mIOException)  
        { 
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase"); 
            throw new Error("UnableToCreateDatabase"); 
        } 
        return this; 
    } 
 
    public TestAdapter open() throws SQLException  
    { 
        try  
        { 
            mDbHelper.openDataBase(); 
            mDbHelper.close(); 
            mDb = mDbHelper.getReadableDatabase(); 
        }  
        catch (SQLException mSQLException)  
        { 
            Log.e(TAG, "open >>"+ mSQLException.toString()); 
            throw mSQLException; 
        } 
        return this; 
    } 
 
    public void close()  
    { 
        mDbHelper.close(); 
    } 
 
     public Cursor getTestData() 
     { 
         try 
         { 
             String sql ="SELECT * from Employees"; 
             //String sql ="SELECT EmployeeId, Name, Email FROm Employees"; 
             Cursor mCur = mDb.rawQuery(sql, null); 
            
             
             
//             if (mCur != null ) {
//                 if  (mCur.moveToFirst()) {
//                     do {
//                         String firstName = mCur.getString(mCur.getColumnIndex("Name"));
//                         String email = mCur.getString(mCur.getColumnIndex("Email"));
//                         results.add("Name: " + firstName + ",Email: " + email);
//                     }while (mCur.moveToNext());
//                 } 
//                 
//                 
//             }           
////         
//             return results;
             
             if (mCur!=null) 
             { 
                mCur.moveToNext(); 
             } 
             return mCur; 
         } 
         catch (SQLException mSQLException)  
         { 
             Log.e(TAG, "getTestData >>"+ mSQLException.toString()); 
             throw mSQLException; 
         } 
     }
     
    
     
     
     public ArrayList getArrayTestData() 
     { 
         try 
         { 
             String sql ="SELECT * from Employees"; 
             //String sql ="SELECT EmployeeId, Name, Email FROm Employees"; 
             Cursor mCur = mDb.rawQuery(sql, null); 
            
             
             
             if (mCur != null ) {
                 if  (mCur.moveToFirst()) {
                     do {
                         String firstName = mCur.getString(mCur.getColumnIndex("Name"));
                         String email = mCur.getString(mCur.getColumnIndex("Email"));
                         results.add("Name: " + firstName + ",Email: " + email);
                     }while (mCur.moveToNext());
                 } 
                 
                 
             }           
//         
//             return results;
             
//             if (mCur!=null) 
//             { 
//                mCur.moveToNext(); 
//             } 
             return results; 
         } 
         catch (SQLException mSQLException)  
         { 
             Log.e(TAG, "getTestData >>"+ mSQLException.toString()); 
             throw mSQLException; 
         } 
     }
     
     

     

     
     public ArrayList getArrayTestDataNew(String query) 
     { 
      //   String[] words = new String[8]; 
         
         
         try 
         { 
             // String sql ="SELECT * from Employees where Name ='" + query + "'";
             
             String sql ="SELECT * from foods limit 50"; 
             
             //String sql ="SELECT EmployeeId, Name, Email FROm Employees"; 
             Cursor mCur = mDb.rawQuery(sql, null); 
            
             
             
             if (mCur != null ) {
                 if  (mCur.moveToFirst()) {
                     do {
                        // String firstName = mCur.getString(mCur.getColumnIndex("Name"));
                       //  String email = mCur.getString(mCur.getColumnIndex("Email"));
                         String restaurant = mCur.getString(mCur.getColumnIndex("restaurant")); 
                         String category = mCur.getString(mCur.getColumnIndex("category"));
                         String food_name = mCur.getString(mCur.getColumnIndex("food_name"));
                         String calories_name = mCur.getString(mCur.getColumnIndex("calories_name"));
                         String protein_name = mCur.getString(mCur.getColumnIndex("protein_name"));
                         String fat_name = mCur.getString(mCur.getColumnIndex("fat_name"));
                         String carb_name = mCur.getString(mCur.getColumnIndex("carb_name"));
                         String fiber_name = mCur.getString(mCur.getColumnIndex("fiber_name"));
                         
                                                 
                         
                         
                         results.add(restaurant + ", " + category + ", " + food_name + ", " + 
                         calories_name + ", " + protein_name + ", " +
                                 fat_name + ", " + carb_name + ", " + fiber_name );
                     }while (mCur.moveToNext());
                 } 
                 
                 
             }           
//         
//             return results;
             
//             if (mCur!=null) 
//             { 
//                mCur.moveToNext(); 
//             } 
             return results; 
         } 
         catch (SQLException mSQLException)  
         { 
             Log.e(TAG, "getTestData >>"+ mSQLException.toString()); 
             throw mSQLException; 
         } 
     }
     
     
     
      // START NEW METHOD ATTEMPT ///////////////////////////////////////////////////////////////////////

     
     public ArrayList<HashMap<String, String>> getArrayTestDataNew2(String[] query) 
     { 
      //   String[] words = new String[8]; 
         
         String noResultsQuery = query[0];
         String proteinQueryMin = query[1];
         String proteinQueryMax = query[2];
         
         
//         if(proteinQuery.length()==0){
//             proteinQuery = "0";
//         } else{
//             proteinQuery = proteinQuery;
//         }
         
         
         
         ArrayList<HashMap<String, String>> foodArrayList = new ArrayList<HashMap<String, String>>(); 
         try 
         { 
             // String sql ="SELECT * from foods limit '" + noResultsQuery + "'";
             
              String sql ="SELECT * from foods WHERE protein_name >' " + proteinQueryMin + " 'limit ' " + noResultsQuery + " '";
              
           //  String sql ="SELECT * from foods limit 50"; 
             
             //String sql ="SELECT EmployeeId, Name, Email FROm Employees"; 
            
             
         //    String sql ="SELECT * from foods where protein_name >= '" + 
        //     proteinQueryMin  + "' and protein_name <= ' " + proteinQueryMax + 
        //     "' limit '" + noResultsQuery + "'";
             
          //  String sql ="SELECT * from foods limit 30";
             
             
             
             
             Cursor mCur = mDb.rawQuery(sql, null); 
            
             
             
             if (mCur != null ) {
                 if  (mCur.moveToFirst()) {
                     do {
                        // String firstName = mCur.getString(mCur.getColumnIndex("Name"));
                       //  String email = mCur.getString(mCur.getColumnIndex("Email"));
                         String restaurant = mCur.getString(mCur.getColumnIndex("restaurant")); 
                         String category = mCur.getString(mCur.getColumnIndex("category"));
                         String food_name = mCur.getString(mCur.getColumnIndex("food_name"));
                         String calories_name = mCur.getString(mCur.getColumnIndex("calories_name"));
                         String protein_name = mCur.getString(mCur.getColumnIndex("protein_name"));
                         String fat_name = mCur.getString(mCur.getColumnIndex("fat_name"));
                         String carb_name = mCur.getString(mCur.getColumnIndex("carb_name"));
                         String fiber_name = mCur.getString(mCur.getColumnIndex("fiber_name"));
                                                                         
                         
                         
                         HashMap<String, String> foodMap = new HashMap<String, String>();
                         
                         foodMap.put("foodId", mCur.getString(0));
                         foodMap.put("restaurant", mCur.getString(1));
                         foodMap.put("category", mCur.getString(2));
                         foodMap.put("food_name", mCur.getString(3));
                         foodMap.put("calories_name", mCur.getString(4));
                         foodMap.put("protein_name", mCur.getString(5));
                         foodMap.put("fat_name", mCur.getString(6));
                         foodMap.put("carb_name", mCur.getString(7));
                         foodMap.put("fiber_name", mCur.getString(8));
                         
                         foodArrayList.add(foodMap); 
                         
                         
                         
                     }while (mCur.moveToNext());
                 } 
                 
                 
             }           

             return foodArrayList;
         } 
         catch (SQLException mSQLException)  
         { 
             Log.e(TAG, "getTestData >>"+ mSQLException.toString()); 
             throw mSQLException; 
         } 
     }
     
     
     
  // END METHOD ATTEMPT ///////////////////////////////////////////////////////////////////////

     
    public boolean SaveEmployee(String name, String email) 
    {
        try
        {
            ContentValues cv = new ContentValues();
            cv.put("Name", name);
            cv.put("Email", email);
            
            mDb.insert("Employees", null, cv);

            Log.d("SaveEmployee", "informationsaved");
            return true;
            
        }
        catch(Exception ex)
        {
            Log.d("SaveEmployee", ex.toString());
            return false;
        }
    }
     
    
 

} 


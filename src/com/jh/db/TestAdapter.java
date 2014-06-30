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
    public String search;
 
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
         // String querySort = query[3];
         String noResultsQuery = query[0];
         String calorieQueryMin = query[1];
         String calorieQueryMax = query[2];
         String proteinQueryMin = query[3];
         String proteinQueryMax = query[4];
         String fatQueryMin = query[5];
         String fatQueryMax = query[6];
         String carbQueryMin = query[7];
         String carbQueryMax = query[8];
         String fiberQueryMin = query[9];
         String fiberQueryMax = query[10];
         String querySort = query[11];
         String sortBy = query[12];
         String searchQuery = query[13];
         
                  
         if(calorieQueryMin.length()==0){ calorieQueryMin = "0"; }          
         if(calorieQueryMax.length()==0){ calorieQueryMax = "4580"; }
         if(proteinQueryMin.length()==0){ proteinQueryMin = "0"; }          
         if(proteinQueryMax.length()==0){ proteinQueryMax = "179"; }
         if(fatQueryMin.length()==0){ fatQueryMin = "0"; }          
         if(fatQueryMax.length()==0){ fatQueryMax = "277"; }
         if(carbQueryMin.length()==0){ carbQueryMin = "0"; }          
         if(carbQueryMax.length()==0){ carbQueryMax = "414"; }
         if(fiberQueryMin.length()==0){ fiberQueryMin = "0"; }          
         if(fiberQueryMax.length()==0){ fiberQueryMax = "38"; }
         if(searchQuery.length()==0){ search = " ' "; } else{ search = "' and food_name like '% " + searchQuery + " %' "; }
         
         
         
         ArrayList<HashMap<String, String>> foodArrayList = new ArrayList<HashMap<String, String>>(); 
         try 
         { 
             // String sql ="SELECT * from foods limit '" + noResultsQuery + "'";
             
             
             
             
              String sql ="SELECT * from foods WHERE protein_name >= ' " + proteinQueryMin 
                      + " ' and protein_name <=' "  + proteinQueryMax  
                      + " ' and fat_name <= ' "  + fatQueryMax  
                      + " ' and fat_name >= ' "  + fatQueryMin  
                      + " ' and carb_name <= ' "  + carbQueryMax  
                      + " ' and carb_name >= ' "  + carbQueryMin
                      + " ' and fiber_name <= ' "  + fiberQueryMax  
                      + " ' and fiber_name >= ' "  + fiberQueryMin
                      + " ' and calories_name <= ' "  + calorieQueryMax 
                      + " ' and calories_name >= ' "  + calorieQueryMin
                      + search 
                      
                      
                      
                      
                      + "  ORDER BY  " + querySort + " "
                      + sortBy + 
              
              
              
               "  limit ' " + noResultsQuery +  " ' ";
              
              
//              String sql ="SELECT * from foods WHERE protein_name > ' " + proteinQueryMin + " ' and protein_name < ' " 
//                      + proteinQueryMax  + " ' ORDER BY  " + querySort +
//                      "   DESC limit ' " + noResultsQuery +  " ' ";
//              
              
              
              // String sql ="SELECT * from foods WHERE protein_name > ' " + proteinQueryMin + " ' and protein_name < ' " + proteinQueryMax +
              //" ' limit ' " + noResultsQuery + " ' ";
              
              
//              String sql ="SELECT * from foods WHERE protein_name > ' " + proteinQueryMin + " ' and protein_name < ' " 
//                      + proteinQueryMax  + " ' ORDER BY  " + querySort +
//                      "   DESC limit ' " + noResultsQuery +  " ' ";
           //  String sql ="SELECT * from foods limit 50"; 
             
             //String sql ="SELECT EmployeeId, Name, Email FROm Employees"; 
            
             
           //  String sql ="SELECT * from foods where protein_name >= '" + 
          //   proteinQueryMin  + "' and protein_name <= ' " + proteinQueryMax + 
         //    "' limit '" + noResultsQuery + "'";
             
          //  String sql ="SELECT * from foods order by protein_name desc limit 30 ";
             
             
             
             
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
     public HashMap<String, String> getFoodInfo(String id){
         
         HashMap<String, String> foodMap = new HashMap<String, String>();
         
        // SQLiteDatabase database = mDb;
         
         String selectQuery = "SELECT * FROM foods WHERE foodId='" + id + "'";
         
         Cursor mCur = mDb.rawQuery(selectQuery, null);
         
         if(mCur.moveToFirst()){
             
             do{
                 foodMap.put("foodId", mCur.getString(0));
                 foodMap.put("restaurant", mCur.getString(1));
                 foodMap.put("category", mCur.getString(2));
                 foodMap.put("food_name", mCur.getString(3));
                 foodMap.put("calories_name", mCur.getString(4));
                 foodMap.put("protein_name", mCur.getString(5));
                 foodMap.put("fat_name", mCur.getString(6));
                 foodMap.put("carb_name", mCur.getString(7));
                 foodMap.put("fiber_name", mCur.getString(8));
                 
//                 foodMap.put("foodId", cursor.getString(0));
//                 foodMap.put("food_name", cursor.getString(1));
//                 foodMap.put("protein_name", cursor.getString(2));
//                 foodMap.put("fat_name", cursor.getString(3));
//                 foodMap.put("carb_name", cursor.getString(4));
//                 foodMap.put("fiber_name", cursor.getString(5));
                 
             } while(mCur.moveToNext());
             
         }
         
         return foodMap;
         
     }
     
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


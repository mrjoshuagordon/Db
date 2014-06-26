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
         try 
         { 
             String sql ="SELECT * from Employees where Name ='" + query + "'";
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


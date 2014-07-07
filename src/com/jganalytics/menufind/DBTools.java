package com.jganalytics.menufind;



import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBTools extends SQLiteOpenHelper {
    
    public DBTools(Context applicationContext){
        
        super(applicationContext, "menu_foods.db", null, 1);
        
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        
      String query = "CREATE TABLE foods (  foodId INTEGER PRIMARY KEY AUTOINCREMENT, restaurant TEXT, " +
      		"category TEXT, food_name TEXT, calories_name DOUBLE, " +
      		"protein_name DOUBLE,fat_name DOUBLE,carb_name DOUBLE,fiber_name DOUBLE, " +
      		"sodium_name DOUBLE,sugar_name DOUBLE)";
       
        database.execSQL(query);
       // database.execSQL(".mode csv");
      //  database.execSQL(".import res/raw/myfile.csv " + "foods");  
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        
        String query = "DROP TABLE IF EXISTS foods";
        
        database.execSQL(query);
        onCreate(database);
        
    }
    
    public void insertFood(HashMap<String, String> queryValues){
        
        SQLiteDatabase database = this.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        
        values.put("food_name", queryValues.get("food_name"));
        values.put("protein_name", queryValues.get("protein_name"));
        values.put("fat_name", queryValues.get("fat_name"));
        values.put("carb_name", queryValues.get("carb_name"));
        values.put("fiber_name", queryValues.get("fiber_name"));
        
        database.insert("foods", null, values);
        
        database.close();
        
    }
    
    public int updateFood(HashMap<String, String> queryValues){
        
        SQLiteDatabase database = this.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        
        values.put("food_name", queryValues.get("food_name"));
        values.put("protein_name", queryValues.get("protein_name"));
        values.put("fat_name", queryValues.get("fat_name"));
        values.put("carb_name", queryValues.get("carb_name"));
        values.put("fiber_name", queryValues.get("fiber_name"));
        
        return database.update("foods", values, 
                "foodId" + " = ?", new String[] {queryValues.get("foodId") });
        
    }
    
    public void deleteFood(String id){
        
        SQLiteDatabase database = this.getWritableDatabase();
        
        String deleteQuery = "DELETE FROM foods WHERE foodId='" + id + "'";
        
        database.execSQL(deleteQuery);
        
    }
    
    public ArrayList<HashMap<String, String>> getAllFoods(){
        
        ArrayList<HashMap<String, String>> foodArrayList = new ArrayList<HashMap<String, String>>();
        
        String selectQuery = "SELECT * FROM foods";
        
        SQLiteDatabase database = this.getWritableDatabase();
        
        Cursor cursor = database.rawQuery(selectQuery, null);
        
        if(cursor.moveToFirst()){
            
            do{
                
                HashMap<String, String> foodMap = new HashMap<String, String>();
                
                foodMap.put("foodId", cursor.getString(0));
                foodMap.put("food_name", cursor.getString(1));
                foodMap.put("protein_name", cursor.getString(2));
                foodMap.put("fat_name", cursor.getString(3));
                foodMap.put("carb_name", cursor.getString(4));
                foodMap.put("fiber_name", cursor.getString(5));
                
                foodArrayList.add(foodMap);
                
            } while(cursor.moveToNext());
            
        }
        
        return foodArrayList;
        
    }
    
    public HashMap<String, String> getFoodInfo(String id){
        
        HashMap<String, String> foodMap = new HashMap<String, String>();
        
        SQLiteDatabase database = this.getReadableDatabase();
        
        String selectQuery = "SELECT * FROM foods WHERE foodId='" + id + "'";
        
        Cursor cursor = database.rawQuery(selectQuery, null);
        
        if(cursor.moveToFirst()){
            
            do{
                
                foodMap.put("foodId", cursor.getString(0));
                foodMap.put("food_name", cursor.getString(1));
                foodMap.put("protein_name", cursor.getString(2));
                foodMap.put("fat_name", cursor.getString(3));
                foodMap.put("carb_name", cursor.getString(4));
                foodMap.put("fiber_name", cursor.getString(5));
                
            } while(cursor.moveToNext());
            
        }
        
        return foodMap;
        
    }
    
}









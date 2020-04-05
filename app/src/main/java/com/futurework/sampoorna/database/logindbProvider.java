package com.futurework.sampoorna.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class logindbProvider {

    SQLiteDatabase read;
    SQLiteDatabase write;
    public logindbProvider(logindbHelper obj){
        read = obj.getReadableDatabase();
    }
    public int getCount(){
        Cursor cursor = read.query(BlankContract.BlankEnter.LOGIN_TABLE_NAME, null, null, null, null, null, null);

        try{
            return cursor.getCount();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            cursor.close();
        }
        return Integer.parseInt(null);
    }

    public String getValueString(String obj){
        Cursor cursor = read.query(BlankContract.BlankEnter.LOGIN_TABLE_NAME , null,null,null,null,null,null);;
        int CURSOR_FLAG = cursor.getColumnIndex(obj);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getString(CURSOR_FLAG);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            cursor.close();
        }
        return null;
    }

    public int getValueInt(String obj){
        Cursor cursor = read.query(BlankContract.BlankEnter.LOGIN_TABLE_NAME, null, null, null, null, null, null);

        try{
            return cursor.getInt(cursor.getColumnIndex(obj));
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            cursor.close();
        }
        return Integer.parseInt(null);
    }

    public void setImage(){

    }

}

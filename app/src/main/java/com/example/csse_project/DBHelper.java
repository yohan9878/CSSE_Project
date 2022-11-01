package com.example.csse_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Orders.db";

    public DBHelper (Context context){ super(context, DATABASE_NAME,null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE" + PurchaseOderMaster.PurchaseOrders.TABLE_NAME + "("+
                        PurchaseOderMaster.PurchaseOrders._ID + "INTEGER PRIMARY KEY," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_SITE_NAME + "TEXT," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_ITEM_NAME + "TEXT," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_SUPPLIER_NAME + "TEXT," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_DELIVERY_ADDRESS + "TEXT," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_QUANTITY + "INTEGER," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_REQUIRED_DATE + "TEXT," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_DESCRIPTION + "TEXT," +
                        PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_TOTAL_PRICE + "INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Boolean insertData(String siteName, String itemName, String supplierName, String deliveryAddress,
                           int quantity, String requiredDate, String description, int totalPrice){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_SITE_NAME, siteName);
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_ITEM_NAME, itemName);
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_SUPPLIER_NAME, supplierName);
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_DELIVERY_ADDRESS, deliveryAddress);
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_QUANTITY, quantity);
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_REQUIRED_DATE, requiredDate);
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_DESCRIPTION, description);
        values.put(PurchaseOderMaster.PurchaseOrders.COLUMN_NAME_TOTAL_PRICE, totalPrice);

        long result = db.insert(PurchaseOderMaster.PurchaseOrders.TABLE_NAME,null, values);
        if(result==-1){
            return false;
        }else{
            return true;
        }


    }
}

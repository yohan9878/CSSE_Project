package com.example.csse_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "orders";
    public static final String TABLE_NAME ="purchase_orders";
    private static final String KEY_ID = "id";
    public static final String COLUMN_NAME_SITE_NAME ="site_name";
    public static final String COLUMN_NAME_ITEM_NAME ="item_name";
    public static final String COLUMN_NAME_SUPPLIER_NAME ="supplier_name";
    public static final String COLUMN_NAME_DELIVERY_ADDRESS ="delivery_address";
    public static final String COLUMN_NAME_QUANTITY ="quantity";
    public static final String COLUMN_NAME_REQUIRED_DATE ="required_date";
    public static final String COLUMN_NAME_DESCRIPTION ="description";
    public static final String COLUMN_NAME_TOTAL_PRICE = "total_price";

    public PurchaseOrderDatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_SITE_NAME + " TEXT,"
                + COLUMN_NAME_ITEM_NAME + " TEXT," + COLUMN_NAME_SUPPLIER_NAME + " INTEGER," + COLUMN_NAME_DELIVERY_ADDRESS + " TEXT,"+ COLUMN_NAME_QUANTITY + " INTEGER,"+ COLUMN_NAME_REQUIRED_DATE + " INTEGER," + COLUMN_NAME_DESCRIPTION + " TEXT," + COLUMN_NAME_TOTAL_PRICE + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addPurchaseOrder(PurchaseOrder purchaseOrder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_SITE_NAME, purchaseOrder.getSiteName()); // Contact Name
        values.put(COLUMN_NAME_ITEM_NAME, purchaseOrder.getItemName()); // Contact Phone
        values.put(COLUMN_NAME_SUPPLIER_NAME,purchaseOrder.getSupplierName());
        values.put(COLUMN_NAME_DELIVERY_ADDRESS,purchaseOrder.getDeliveryAddress());
        values.put(COLUMN_NAME_QUANTITY,purchaseOrder.getQuantity());
        values.put(COLUMN_NAME_REQUIRED_DATE,purchaseOrder.getRequiredDate());
        values.put(COLUMN_NAME_DESCRIPTION,purchaseOrder.getDescription());
        values.put(COLUMN_NAME_TOTAL_PRICE,purchaseOrder.getPrice());
        long l = db.insert(TABLE_NAME, null, values);
        db.close();
        return l;
    }


    public List<PurchaseOrder> getAllPurchaseOrders() {

        List<PurchaseOrder> purchaseResults = new ArrayList<PurchaseOrder>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                PurchaseOrder purchaseOrder = new PurchaseOrder();
                purchaseOrder.setId(Integer.parseInt(cursor.getString(0)));
                purchaseOrder.setSiteName(cursor.getString(1));
                purchaseOrder.setItemName(cursor.getString(2));
                purchaseOrder.setSupplierName(cursor.getString(3));
                purchaseOrder.setDeliveryAddress(cursor.getString(4));
                purchaseOrder.setQuantity(Integer.parseInt(cursor.getString(5)));
                purchaseOrder.setRequiredDate(Integer.parseInt(cursor.getString(6)));
                purchaseOrder.setDescription(cursor.getString(7));
                purchaseOrder.setPrice(Integer.parseInt(cursor.getString(8)));
                purchaseResults.add(purchaseOrder);
            } while (cursor.moveToNext());
        }
        return purchaseResults;
    }


}

package com.example.csse_project;

import android.provider.BaseColumns;



public final class PurchaseOderMaster {
    private PurchaseOderMaster(){}

    public static class PurchaseOrders implements BaseColumns{
        public static final String TABLE_NAME ="Purchase Orders";
        public static final String COLUMN_NAME_SITE_NAME ="Site Name";
        public static final String COLUMN_NAME_ITEM_NAME ="Item name";
        public static final String COLUMN_NAME_SUPPLIER_NAME ="Supplier name";
        public static final String COLUMN_NAME_DELIVERY_ADDRESS ="Delivery Address";
        public static final String COLUMN_NAME_QUANTITY ="Quantity";
        public static final String COLUMN_NAME_REQUIRED_DATE ="Required Date";
        public static final String COLUMN_NAME_DESCRIPTION ="Description";
        public static final String COLUMN_NAME_TOTAL_PRICE = "Total Price";


    }
}

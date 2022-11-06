package com.example.csse_project;

import static java.lang.Boolean.TRUE;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CreatePurchaseOder extends AppCompatActivity {

    Button send;
    Button clear;

    EditText edtn1;
    EditText edtn2;
    EditText edtn3;
    EditText edta1;
    EditText etn1;
    EditText etd1;
    EditText edtm1;
    EditText etn2;

    DBHelper db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_purchase_oder);

        send = findViewById(R.id.btn3);
        clear  = findViewById(R.id.btn4);

        edtn1 = findViewById(R.id.edtn1);
        edtn2 = findViewById(R.id.edtn2);
        edtn3 = findViewById(R.id.edtn3);
        edta1 = findViewById(R.id.edta1);
        etn1 = findViewById(R.id.etn1);
        etd1 = findViewById(R.id.etd1);
        edtm1 = findViewById(R.id.edtm1);
        etn2 = findViewById(R.id.etn2);

        db = new DBHelper(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String siteName = edtn1.getText().toString();
                String itemName = edtn2.getText().toString();
                String supplierName = edtn3.getText().toString();
                String dAddress = edta1.getText().toString();
                int quantity = Integer.parseInt(etn1.getText().toString());
                String rDate = etd1.getText().toString();
                String description = edtm1.getText().toString();
                int tPrice = Integer.parseInt(etn2.getText().toString());

                JSONArray items = new JSONArray();
                JSONObject purchaseOrder = new JSONObject();
                JSONObject item = new JSONObject();
                try {
                    item.put("name",itemName);
                    item.put("description",description);
                    item.put("quantity",quantity);
                    item.put("amount",tPrice);
                    items.put(item);
                    purchaseOrder.put("name","");
                    purchaseOrder.put("date",rDate);
                    purchaseOrder.put("siteName",siteName);
                    purchaseOrder.put("status","");
                    purchaseOrder.put("supplierName",supplierName);
                    purchaseOrder.put("deliveryAddress",dAddress);
                    purchaseOrder.put("items",items);
                    APICall.sendJsonPostRequest(getApplicationContext(),purchaseOrder);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                PurchaseOrder order = new PurchaseOrder();
                order.setSiteName(siteName);
                order.setItemName(itemName);
                order.setSupplierName(supplierName);
                order.setDeliveryAddress(dAddress);
                order.setQuantity(quantity);
                order.setRequiredDate(Integer.parseInt(rDate));
                order.setDescription(description);
                order.setPrice(tPrice);
                PurchaseOrderDatabaseHelper db = new PurchaseOrderDatabaseHelper(view.getContext());
                long l = db.addPurchaseOrder(order);
                System.out.println(l);

            }
        });

    }
}
package com.example.csse_project;

import static java.lang.Boolean.TRUE;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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

                Boolean checkInsertData = db.insertData(siteName,itemName,supplierName,dAddress,quantity,rDate,description,
                        tPrice);
                if(checkInsertData==TRUE){
                    Toast.makeText(CreatePurchaseOder.this,"New Entry Inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CreatePurchaseOder.this,"New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
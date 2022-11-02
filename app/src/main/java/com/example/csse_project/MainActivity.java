package com.example.csse_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;

    DBHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCreatePurchaseOder();
            }
        });
    }

    public void openCreatePurchaseOder(){
        Intent intent = new Intent(this,CreatePurchaseOder.class);
        startActivity(intent);
    }


//    btn2.setOnClickListener(new View.OnClickListener(){
//        @Override
//        public void onClick(View v){
//            openRequisiteOder();
//        }
//    });
//}
//
//    public void openRequisiteOder(){
//        Intent intent = new Intent(this, .class);
//        startActivity(intent);
//    }

}


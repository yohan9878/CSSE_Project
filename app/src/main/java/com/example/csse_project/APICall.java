package com.example.csse_project;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class APICall {

    public static void sendJsonPostRequest(Context context,JSONObject jsonObject){

        try {
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    "http://192.168.43.209:8080/purchase_orders/new_purchase_order",
                    jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                        }
                    },

                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });


            Volley.newRequestQueue(context).
                    add(request);

        } catch(Exception ex){
            // Catch if something went wrong with the params
            System.out.println(ex.toString());
        }

    }
}

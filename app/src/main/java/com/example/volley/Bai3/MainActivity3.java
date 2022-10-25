package com.example.volley.Bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView rcv_model3;
    Model3 model3;
    Phone phone;
    ArrayList<Model3> list;
    Model3Adapter model3Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rcv_model3 = findViewById(R.id.rcv_model3);

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity3.this);
        String url = "https://thanhluan5983.000webhostapp.com/Lab6/list_person.json";

        list = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){

                    try {
                        model3 = new Model3();
                        JSONObject objModel3 = response.getJSONObject(i);

                        model3.setId(objModel3.getString("id"));
                        model3.setName(objModel3.getString("name"));
                        model3.setEmail(objModel3.getString("email"));

                        phone = new Phone();
                        JSONObject objPhone =objModel3.getJSONObject("phone");
                        phone.setMobile(objPhone.getString("mobile"));
                        phone.setHome(objPhone.getString("home"));

                        model3.setPhone(phone);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    list.add(model3);
                    model3Adapter = new Model3Adapter(list);
                    rcv_model3.setAdapter(model3Adapter);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity3.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}
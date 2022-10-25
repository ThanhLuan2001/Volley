package com.example.volley.Bai2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {

    TextView tvKetqua;

    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvKetqua = findViewById(R.id.tvKetqua);

        Bai2();
    }

    private void Bai2() {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
        String url = "https://api.nationalize.io/?name=nathaniel";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET
                , url
                , null
                , (Response.Listener<JSONObject>) response -> {

            try {
                JSONArray jsonArray = response.getJSONArray("country");
                for (int i = 0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    data = data +
                          "country_id: "+jsonObject.getString("country_id")+"\n"
                         +"probability: "+jsonObject.getString("probability")+"\n";
                }
                data = data + "name: "+response.getString("name");

                tvKetqua.setText(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
                , error -> {

            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
        );

        requestQueue.add(jsonObjectRequest);
    }
}
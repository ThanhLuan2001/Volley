package com.example.volley.Bai1;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity1 extends AppCompatActivity {

    TextView tvKetqua;
    RequestQueue requestQueue;
    String url = "https://www.boredapi.com/api/activity";
    JsonObjectRequest jsonObjectRequest;//vì api trả về dạng object
    // nên phải dùng JsonObjectRequest nha,dấu ngoặc nhọn là trả về object
    //dấu ngoặc vuông là trả về array


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        tvKetqua = findViewById(R.id.tvKetqua);
        requestQueue = Volley.newRequestQueue(this);
        jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET
                , url
                , null
                , (Response.Listener<JSONObject>) response -> {
            try {
                //lưu ý: tên key (name) ở trong ứng dụng phải giống với tên ở trên api
                //nếu sai thì sẽ không lấy được dữ liệu về đâu nhé
                tvKetqua.setText(
                        "activity: "+response.getString("activity")+"\n"
                       +"type: "+response.getString("type")+"\n"
                       +"participants: "+response.getString("participants")+"\n"
                       +"price: "+response.getString("price")+"\n"
                       +"link: "+response.getString("link")+"\n"
                       +"key: "+response.getString("key")+"\n"
                       +"accessibility: "+response.getString("accessibility")+"\n"
                );
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
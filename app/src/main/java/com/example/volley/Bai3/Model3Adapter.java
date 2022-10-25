package com.example.volley.Bai3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volley.R;

import java.util.ArrayList;

public class Model3Adapter extends RecyclerView.Adapter<Model3Adapter.Model3ViewHolder> {

    ArrayList<Model3> list;

    public Model3Adapter(ArrayList<Model3> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Model3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_model3,parent,false);
        return new Model3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Model3ViewHolder holder, int position) {

        Model3 model3 = list.get(position);
        holder.tv_id.setText("id: "+model3.getId()+"");
        holder.tv_name.setText("name: "+model3.getName()+"");
        holder.tv_email.setText("email: "+model3.getEmail()+"");
        holder.tv_mobile.setText("mobile: "+model3.getPhone().getMobile()+"");
        holder.tv_home.setText("home: "+model3.getPhone().getHome()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Model3ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id,tv_name,tv_email,tv_mobile,tv_home;
        public Model3ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_mobile = itemView.findViewById(R.id.tv_mobile);
            tv_home = itemView.findViewById(R.id.tv_home);
        }
    }
}

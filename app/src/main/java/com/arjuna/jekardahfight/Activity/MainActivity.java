package com.arjuna.jekardahfight.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.arjuna.jekardahfight.Model.DataItem;
import com.arjuna.jekardahfight.Model.ResponseJakFight;
import com.arjuna.jekardahfight.Network.ApiService;
import com.arjuna.jekardahfight.Network.InstanceRetrofit;
import com.arjuna.jekardahfight.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcViewnya;
    private String token = "5h30dB4K4Uwuhj4KkmHmFlEdjxyD+IV/rgCnkhya6acUDZDpPemZ3CgChrEjo/tE";
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcViewnya = findViewById(R.id.rcViewJekfight);
        getDataFighter();
    }

    private void getDataFighter() {
        ApiService api = InstanceRetrofit.getInstance();
        Call<ResponseJakFight> call = api.requestPostPetugas(token);
        call.enqueue(new Callback<ResponseJakFight>() {
            @Override
            public void onResponse(Call<ResponseJakFight> call, Response<ResponseJakFight> response) {
                if (response.body().getStatus().equals("success")){
                    List<DataItem> dataItems = response.body().getData();
                    adapter = new CustomAdapter(rcViewnya, MainActivity.this, dataItems);
                    rcViewnya.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rcViewnya.setAdapter(adapter);
                    rcViewnya.setHasFixedSize(true);
                }else{
                    Toast.makeText(MainActivity.this, ""+response.body().getStatus(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseJakFight> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
        RecyclerView rcView;
        Context context;
        List<DataItem> dataItems;

        public CustomAdapter(RecyclerView recyclerView, Context context, List<DataItem> itemsItems) {
            this.rcView = recyclerView;
            this.context = context;
            this.dataItems = itemsItems;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpetugas, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.petugasnya.setText(dataItems.get(position).getNama());

        }

        @Override
        public int getItemCount() {
            return dataItems.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView petugasnya;
            public MyViewHolder(View itemView) {
                super(itemView);
                petugasnya = itemView.findViewById(R.id.namapetugasnya);
            }
        }
    }
}

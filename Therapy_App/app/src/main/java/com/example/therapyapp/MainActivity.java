package com.example.therapyapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyapp.Model.Datum;
import com.example.therapyapp.Model.Root;
import com.example.therapyapp.networkstate.CheckNetwork;
import com.example.therapyapp.repository.remotedata;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Datum> arraylist = new ArrayList<Datum>();
    RecyclerView recyclerview;

    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(CheckNetwork.isInternetAvailable(this)) //returns true if internet available
        {
            setContentView(R.layout.activity_main);
            recyclerview = findViewById(R.id.recyclerview);
            recyclerview.setHasFixedSize(true);
            recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
            adapter = new Adapter(getApplicationContext(), arraylist);
            recyclerview.setAdapter(adapter);
            getImage();
        } else
        {
            Toast.makeText(this,"No Internet Connection", Toast.LENGTH_SHORT).show();
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
    private void getImage(){
        remotedata.getAPIinterface().getImage().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                arraylist.clear();
                arraylist.addAll(response.body().getData());
                recyclerview.getRecycledViewPool().clear();
                adapter.notifyDataSetChanged();
                findViewById(R.id.progressBar1).setVisibility(View.GONE);
                Log.d(TAG, Integer.toString(response.code()));
                Log.d("myTag", response.toString());
                Log.d(TAG, Integer.toString(response.code())+(response.raw().request().url()).toString());


            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });

    }
}
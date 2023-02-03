package com.example.therapyapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.therapyapp.data.remote;
import com.example.therapyapp.repository.remotedata;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void getrecipe(String query){
        remotedata.getAPIinterface().getImage2("61a2ba9ae7794bbe914353e4ce889564", true, query).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {

                arraylist.clear();
                arraylist.addAll(response.body().getResults());
                recyclerview.getRecycledViewPool().clear();
                adapter.notifyDataSetChanged();

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
package com.example.therapyapp.repository;

import com.example.therapyapp.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class remotedata {
    private static  String BASE_URL="https://mindmyscape.localserverpro.com/api/doctor/therapies";
    private static Retrofit retrofit = null;
    public static remote getAPIinterface(){
        if(retrofit==null){
            retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(remote.class);
    }
}
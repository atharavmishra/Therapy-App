package com.example.therapyapp.data;



import com.example.therapyapp.Model.Root;

import retrofit2.Call;
import retrofit2.http.GET;


public interface remote {

    @GET("therapies")
    Call<Root> getImage(

    );

}

package com.example.minimo2dsa_cgm;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("users/{Username}")
    Call<User> userInfo (@Path("Username") String username);

    @GET("users/{Username}/repos")//trae la info de los followers
    Call<List<Repos>> followersInfo (@Path("Username") String username); //devuelve un response del server, una lista con los datos de los followers

}

package com.olehovnagmail.anya.data.rest;


import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Url;

public interface RestApi {

    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);

}

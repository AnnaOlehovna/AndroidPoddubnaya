package com.olehovnagmail.anya.data.rest;


import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import retrofit2.Call;


@Singleton
public class RestService {


    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

   public Call<ResponseBody> downloadFile(String url){
       return restApi.downloadFile(url);
    }



}

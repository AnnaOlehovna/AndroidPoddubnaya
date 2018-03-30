package com.olehovnagmail.anya.data.homework6.download;


import java.io.File;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface BaseDownload {

    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String url);

}

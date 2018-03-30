package com.olehovnagmail.anya.data.homework6.download;


import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class Download {


    private BaseDownload baseDownload;

    @Inject
    public Download(BaseDownload baseDownload) {
        this.baseDownload = baseDownload;
    }


    public Call<ResponseBody> downloadFile(String url) {
        return baseDownload.downloadFile(url);
    }

}

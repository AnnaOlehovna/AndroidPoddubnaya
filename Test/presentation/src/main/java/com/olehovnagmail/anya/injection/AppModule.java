package com.olehovnagmail.anya.injection;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.olehovnagmail.anya.BuildConfig;
import com.olehovnagmail.anya.data.homework6.download.BaseDownload;
import com.olehovnagmail.anya.data.homework6.download.Download;
import com.olehovnagmail.anya.data.homework6.weatherRepository.WeatherRepositoryImpl;

import com.olehovnagmail.anya.data.rest.RestApi;
import com.olehovnagmail.anya.data.rest.RestService;
import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.executor.UIThread;
import com.olehovnagmail.anya.domain.homework6.weatherRepository.WeatherRepository;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {


    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUIThread() {
        return new UIThread();
    }

//    то же самое, что и метод выше
//    @Binds
//    public abstract PostExecutionThread getUIThread2(UIThread uiThread);
//

    @Provides
    @Singleton
    public WeatherRepository getWeatherRepository(Context context, RestService restService) {
        return new WeatherRepositoryImpl(context,restService);
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public BaseDownload getDownload(Retrofit retrofit) {
        return retrofit.create(BaseDownload.class);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))//gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//Rx
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient getOkHttp() {
//        OkHttpClient как и HttpUrlConnection
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder
//                .readTimeout(10, TimeUnit.SECONDS)
//                .writeTimeout(10, TimeUnit.SECONDS)
//
//                .connectTimeout(10, TimeUnit.SECONDS);

        //это позволит в логах печатать какие запросы отправляются на сервер
       if(BuildConfig.DEBUG) {
           HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

           httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
           builder.addInterceptor(httpLoggingInterceptor);
       }
       return builder.build();
    }


    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder()
                //здесь можно регистировать адаптеры и конвертеры для даты и прочего
                .create();
    }



}

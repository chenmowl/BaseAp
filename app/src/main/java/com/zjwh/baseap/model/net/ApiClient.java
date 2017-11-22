package com.zjwh.baseap.model.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.zjwh.baseap.model.net.converter.FastJsonConverterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by dijiaoliang on 17/3/2.
 */
public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit checkInstance() {
        if(retrofit==null){
            synchronized (ApiClient.class){
                if(retrofit==null){
                    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                    if (ApiConfig.DEBUG) {
                        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        builder.addInterceptor(httpLoggingInterceptor);
//                        builder.addInterceptor(httpLoggingInterceptor).addNetworkInterceptor(new StethoInterceptor());
                    }
                    OkHttpClient client = builder.build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl(ApiConfig.QINIU_HOST)
                            .addConverterFactory(FastJsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(client)
                            .build();
                }
            }
        }
        return retrofit;
    }

}

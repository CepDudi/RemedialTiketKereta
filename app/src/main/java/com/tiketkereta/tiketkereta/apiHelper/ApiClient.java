package com.tiketkereta.tiketkereta.apiHelper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public static final String URL      = " http://192.168.43.25/ta-api-server/api/";
    public static Retrofit RETROFIT     = null;

    public static Retrofit getClient(String URL){
        if(RETROFIT==null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .build();
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }

    public static BaseApiService getAPIService(){
        return ApiClient.getClient(URL).create(BaseApiService.class);
    }


}

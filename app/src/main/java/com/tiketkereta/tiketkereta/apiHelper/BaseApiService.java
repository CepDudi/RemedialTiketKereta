package com.tiketkereta.tiketkereta.apiHelper;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import com.tiketkereta.tiketkereta.apiHelper.pojo.Login.Login;
import com.tiketkereta.tiketkereta.apiHelper.pojo.Register.Value;


public interface BaseApiService {


    @FormUrlEncoded
    @POST("Login/proses")
    Call<Login> postLogin(@Field("username") String username,
                          @Field("password") String password);


    @FormUrlEncoded
    @POST("Siswa")
    Call<Value>register(@Field("id_level") String id_level,
                        @Field("id_kelas") String id_kelas,
                        @Field("nama_user") String nama_siswa,
                        @Field("username") String username,
                        @Field("password") String password,
                        @Field("alamat") String alamat,
                        @Field("no_hp_user") String no_hp_siswa,
                        @Field("no_hp_ortu") String no_hp_ortu,
                        @Field("jk") String jk);









}



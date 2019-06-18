package com.tiketkereta.tiketkereta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.tiketkereta.tiketkereta.apiHelper.ApiClient;
import com.tiketkereta.tiketkereta.apiHelper.BaseApiService;
import com.tiketkereta.tiketkereta.apiHelper.pojo.Login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etPassword;
    EditText etUsername;
    TextView tvRegister;

    Context mContext;
    BaseApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        mApiService = ApiClient.getClient(ApiClient.URL).create(BaseApiService.class);;
        initComponents();

    }

    private void initComponents(){
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Login> postKontakCall = mApiService.postLogin(etUsername.getText().toString(), etPassword.getText().toString());
                postKontakCall.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        Integer status = response.body().getSuccess();
                        String message = response.body().getMessage();
                        String level = response.body().getLevel();
                        String nisn = response.body().getNisn();
                        String kelas = response.body().getKelas();
                        String alamat = response.body().getAlamat();
                        String no = response.body().getNo();
                        String nama = response.body().getNama();
                        String id = response.body().getId();
                        String username = response.body().getUsername();


                        if(status.equals(1)){
                            if (level.equals("1")){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                Toast.makeText(LoginActivity.this, "Login Berhasil" , Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(LoginActivity.this, "Login Berhasil" , Toast.LENGTH_SHORT).show();
                                Intent i = null;
                                i = new Intent(LoginActivity.this, MainActivity.class);
                                Bundle b = new Bundle();
                                b.putString("parse_nama", nama);
                                b.putString("parse_nisn", nisn);
                                b.putString("parse_kelas", kelas);
                                b.putString("parse_alamat", alamat);
                                b.putString("parse_no", no);
                                b.putString("parse_id", id);
                                b.putString("parse_username", username);

                                i.putExtras(b);
                                startActivity(i);
                            }
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Log.e("Retrofit Get ", t.toString());
                    }
                });

            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, DaftarActivity.class));
            }
        });
    }





}

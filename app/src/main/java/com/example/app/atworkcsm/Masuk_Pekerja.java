package com.example.app.atworkcsm;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.atworkcsm.Utils.ApiUtils;
import com.example.app.atworkcsm.Utils.AuthService;
import com.example.app.atworkcsm.Utils.SessionManager;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class Masuk_Pekerja extends AppCompatActivity implements View.OnClickListener{
    AuthService mAuthAPIService;
    ProgressDialog progressDialog;
    String status, message;
    EditText etUsername, etPassword;
    Button bLogin;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk__pekerja);
        bLogin = (Button) findViewById(R.id.B_login);
        etUsername = (EditText) findViewById(R.id.ET_username);
//        etPassword = (EditText) findViewById(R.id.ET_password);

        bLogin.setOnClickListener(this);

        sessionManager = new SessionManager(Masuk_Pekerja.this);
        progressDialog = new ProgressDialog(Masuk_Pekerja.this);
        progressDialog.setMessage("Mohon Tunggu");
    }

//    public void loginHandler(final String username, String password) {
//        if (username == null || password == null) {
//            dialogAlert("Masukkan Username dan Password");
//            progressDialog.dismiss();
//        } else {
//            Map<String, Object> jsonParams = new ArrayMap<>();
//            jsonParams.put("u", username);
//            jsonParams.put("p", password);
//
//            mAuthAPIService = ApiUtils.getAuthAPIService();
//
//            Call<ResponseBody> response = mAuthAPIService.loginData(username, password);
//
//            response.enqueue(new Callback<ResponseBody>() {
//                @Override
//                public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
//                    if (rawResponse.isSuccessful()) {
//                        try {
//
//                            JSONObject jsonObject = new JSONObject(rawResponse.body().string());
//                            status = jsonObject.getString("status");
//                            message = jsonObject.getString("message");
//
//                            new CountDownTimer(1000, 1000) {
//
//                                public void onTick(long millisUntilFinished) {
//                                    // You don't need anything here
//                                }
//
//                                public void onFinish() {
//                                    sessionManager.setUser(username);
//                                    Toast.makeText(Masuk_Pekerja.this, message,
//                                            Toast.LENGTH_LONG).show();
//                                    progressDialog.dismiss();
//                                    Intent movin = new Intent(Masuk_Pekerja.this, Login_Pekerja.class);
//                                    startActivity(movin);
//                                    finish();
//                                }
//                            }.start();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    } else {
//                        dialogAlert("Login Gagal");
//                        progressDialog.dismiss();
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                }
//            });
//        }
//    }
//
//    public void dialogAlert(String warn){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Error");
//                builder.setMessage(warn);
//                builder.setNegativeButton("Coba Lagi", null);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.B_login:
                Intent movin = new Intent(Masuk_Pekerja.this, Login_Pekerja.class);
                startActivity(movin);
//                progressDialog.show();
//                loginHandler(etUsername.getText().toString(), etPassword.getText().toString());
                break;
        }
    }
}

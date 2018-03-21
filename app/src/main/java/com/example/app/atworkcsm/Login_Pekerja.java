package com.example.app.atworkcsm;

import android.app.Activity;
import android.app.Notification;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.atworkcsm.Utils.ApiUtils;
import com.example.app.atworkcsm.Utils.AuthService;
import com.example.app.atworkcsm.Utils.SessionManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.zxing.client.android.Intents;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class Login_Pekerja extends AppCompatActivity {
    String status, message, code;
    AuthService mAuthAPIService;
    ProgressDialog progressDialog;
    private GoogleApiClient client;
    SessionManager sessionManager;
    Button bScanPekerja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__pekerja);
        final Activity activity = this;
        bScanPekerja = (Button) findViewById(R.id.b_scanpekerja);

        sessionManager = new SessionManager(Login_Pekerja.this);
        progressDialog = new ProgressDialog(Login_Pekerja.this);
        progressDialog.setMessage("Mohon Tunggu");

        bScanPekerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.setCaptureActivity(captureActivityPotrait.class);
                integrator.initiateScan();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_config:
                Toast.makeText(this, "Config Sedang Dibuat", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void loginHandler(String username) {
            Map<String, Object> jsonParams = new ArrayMap<>();
            jsonParams.put("u", username);

            mAuthAPIService = ApiUtils.getAuthAPIService();

            Call<ResponseBody> response = mAuthAPIService.userData(username);

            response.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                    if (rawResponse.isSuccessful()) {
                        try {

                            JSONObject jsonObject = new JSONObject(rawResponse.body().string());
                            status = jsonObject.getString("status");
                            message = jsonObject.getString("message");
                            code = jsonObject.getString("code");

                            new CountDownTimer(1000, 1000) {

                                public void onTick(long millisUntilFinished) {
                                    // You don't need anything here
                                }

                                public void onFinish() {
                                    sessionManager.setCode(code);
                                    Toast.makeText(Login_Pekerja.this, message,
                                            Toast.LENGTH_LONG).show();
                                    progressDialog.dismiss();
                                    Intent movinou = new Intent(Login_Pekerja.this, Login_kamar.class);
                                    startActivity(movinou);
                                    finish();
                                }
                            }.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        dialogAlert("Absen Gagal");
                        progressDialog.dismiss();
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }

    public void dialogAlert(String warn){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage(warn);
        builder.setNegativeButton("Coba Lagi", null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents().equalsIgnoreCase("p3rusah44n")){
                progressDialog.show();
                //Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                loginHandler(sessionManager.getUser());
            } else {
                Toast.makeText(this, "GAGAL", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    }

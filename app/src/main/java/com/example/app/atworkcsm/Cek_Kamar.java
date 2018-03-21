package com.example.app.atworkcsm;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
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

import com.example.app.atworkcsm.Utils.SessionManager;

public class Cek_Kamar extends AppCompatActivity implements View.OnClickListener {
    SessionManager sessionManager;
    boolean doubleBackToExitPressedOnce = false;
    TextView petugas;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek__kamar);
        Button selesai = (Button) findViewById(R.id.btn_selesai);

        sessionManager = new SessionManager(Cek_Kamar.this);
        progressDialog = new ProgressDialog(Cek_Kamar.this);
        progressDialog.setMessage("Mohon Tunggu");

        petugas = (TextView) findViewById(R.id.petugas2);
        petugas.setText(sessionManager.getUser());

        selesai.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_hislog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_logout:
                Intent keluar = new Intent(this, Login_Pekerja.class);
                startActivity(keluar);

            case R.id.menu_History:
                Toast.makeText(this, "History Sedang Dibuat", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_DaftarKamar:
                Toast.makeText(this, "Daftar Kamar Sedang Dibuat", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_selesai:

//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Keluar");
//                builder.setMessage("Apakah Anda Yakin ?");
//                builder.setNegativeButton("Tidak", null);
//                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Intent keluar = new Intent(Cek_Kamar.this, Login_kamar.class);
//                                startActivity(keluar);
//
//                            }
//                        });

                Intent selesai = new Intent(this, Login_kamar.class);
                startActivity(selesai);
                break;
        }
    }

    @Override
    public void onBackPressed(){
        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this,"Tekan tombol kembali lagi untuk keluar",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                doubleBackToExitPressedOnce = false;
            }
        },2000);
    }
}

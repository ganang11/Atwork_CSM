package com.example.app.atworkcsm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cek_Kamar extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek__kamar);
        Button selesai = (Button) findViewById(R.id.btn_selesai);

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
                Intent selesai = new Intent(this, Login_kamar.class);
                startActivity(selesai);
                break;
        }
    }
}

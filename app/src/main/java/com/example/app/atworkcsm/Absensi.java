package com.example.app.atworkcsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;

public class Absensi extends AppCompatActivity {

    AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);
        analogClock = (AnalogClock)findViewById(R.id.jam);
        analogClock.setVisibility(View.VISIBLE);
    }
}

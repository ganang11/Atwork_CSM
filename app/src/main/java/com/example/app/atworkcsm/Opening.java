package com.example.app.atworkcsm;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/**
 * Created by Ganang on 16/03/2018.
 */


public class Opening extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        ImageView logoatwork = (ImageView) findViewById(R.id.logo);

        logoatwork.setAlpha(0f);

        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(logoatwork, "alpha", 3f, 0f);

        fadeAnim.setDuration(4000);

        fadeAnim.start();


        Thread timer = new Thread() {
            public void run() {
                try {

                    sleep(2300);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    PrefManager prefManager = new PrefManager(getApplicationContext());

                    // make first time launch TRUE
                    prefManager.setFirstTimeLaunch(true);

                    startActivity(new Intent(Opening.this, Login_Pekerja.class));
                    finish();


                }
            }
        };
        timer.start();


    }



    private int getDisplayHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}

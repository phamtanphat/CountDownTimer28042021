package com.example.countdowntimer28042021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountDownTimer countDownTimer = new CountDownTimer(5500,1000) {
            @Override
            public void onTick(long l) {
                if (l > 500){
                    Log.d("BBB",l + "");
                }
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }
}
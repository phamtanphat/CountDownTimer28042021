package com.example.countdowntimer28042021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher mImageSwitcher;
    Button mBtnStart;
    CountDownTimer mCountDownTimer;
    int [] mArrImage = {R.drawable.hinh_1,R.drawable.hinh_2,R.drawable.hinh_3,R.drawable.hinh_4,R.drawable.hinh_5};
    int mIndexImage = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageSwitcher = findViewById(R.id.imageSwitcher);
        mBtnStart = findViewById(R.id.buttonStartBanner);

//        mImageSwitcher.setImageResource(R.drawable.hinh_1);
        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                return imageView;
            }
        });

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer = new CountDownTimer(mArrImage.length * 1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        mIndexImage += 1;
                        mImageSwitcher.setImageResource(mArrImage[mIndexImage]);
                        Log.d("BBB","OnTich " + mIndexImage);

                    }

                    @Override
                    public void onFinish() {
                        if (mIndexImage < mArrImage.length - 1){
                            mIndexImage += 1;
                            mImageSwitcher.setImageResource(mArrImage[mIndexImage]);
                        }
                        Log.d("BBB","onFinish " + mIndexImage);
                    }
                };
                mCountDownTimer.start();
            }
        });


    }
}
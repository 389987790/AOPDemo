package com.example.kongjian.aopdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @BehaviorTrace("摇一摇")
    public void mShake(View v) {
       SystemClock.sleep(2000);
    }
    @BehaviorTrace("视频通话")
    public void mAudio(View v) {
        SystemClock.sleep(1000);
    }
}

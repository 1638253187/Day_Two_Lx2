package com.example.day_two_lx;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * 1
     */
    private TextView mTvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvTimer = (TextView) findViewById(R.id.tv_timer);
        new CountDownTimer(6000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTvTimer.setText(millisUntilFinished/1000+"");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }
}

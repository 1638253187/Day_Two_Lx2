package com.example.day_two_lx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Wz extends AppCompatActivity {

    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wz);
        initView();
    }

    private void initView() {
        mWeb = (WebView) findViewById(R.id.web);
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.loadUrl("https://www.baidu.com/");
    }
}

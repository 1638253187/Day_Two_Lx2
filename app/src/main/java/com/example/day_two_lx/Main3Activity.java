package com.example.day_two_lx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main3Activity extends AppCompatActivity {

    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mWeb = (WebView) findViewById(R.id.web);
        mWeb.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        String web = intent.getStringExtra("web");
        mWeb.loadUrl(web);
    }
}

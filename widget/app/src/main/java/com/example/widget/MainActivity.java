package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    EditText edt_url;
    Button btn_Move, btn_Back;
    WebView web_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edt_url = findViewById(R.id.edt_url);
        btn_Move = findViewById(R.id.btn_Move);
        btn_Back = findViewById(R.id.btn_Back);
        web_View = findViewById(R.id.web_View);


        web_View.setWebViewClient(new CookWebViewClient());

        WebSettings webset = web_View.getSettings();
        webset.setBuiltInZoomControls(true);
        webset.setJavaScriptEnabled(true);



        btn_Move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web_View.loadUrl(edt_url.getText().toString());
            }
        });

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web_View.goBack();
            }
        });

    }

    private class CookWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
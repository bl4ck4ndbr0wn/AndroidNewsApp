package com.alphaclicksolutions.ju5tu5.androidnewsapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alphaclicksolutions.ju5tu5.androidnewsapp.Model.WebSite;

import dmax.dialog.SpotsDialog;

public class DetailArticle extends AppCompatActivity {
    WebView webView;
    SpotsDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);

        dialog = new SpotsDialog(this);
        dialog.show();

        //WebView
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
            }
        });

        if (getIntent() != null) {
            if (!getIntent().getStringExtra("webURL").isEmpty())
                webView.loadUrl(getIntent().getStringExtra("webURL"));
        }
    }
}

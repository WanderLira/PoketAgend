package com.example.josewanderlucio.poketagend;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main4Activity extends AppCompatActivity {
    private WebView webview;
    private ProgressDialog progress;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewCustomClient());
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setSupportZoom(true);
        progress = new ProgressDialog(this);
        progress.setTitle("Atenção!");
        progress.setMessage("carregando a página...");
        progress.show();
        webview.loadUrl("http://www.facebook.com");
    }

    private class WebViewCustomClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);

            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progress.dismiss();
        }
    }
}

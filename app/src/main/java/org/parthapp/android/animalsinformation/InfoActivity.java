package org.parthapp.android.animalsinformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.parthapp.android.animalsinformation.R;

public class InfoActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        webView= (WebView)findViewById(R.id.webView);
        Bundle bundle= getIntent().getExtras();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(bundle.getString("URL"));
    }
}

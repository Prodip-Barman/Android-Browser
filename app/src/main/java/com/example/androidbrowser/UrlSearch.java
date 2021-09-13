package com.example.androidbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UrlSearch extends AppCompatActivity implements View.OnClickListener{

    EditText inputEditText;
    Button searchButton, homeButton;
    WebView webView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_search);


        inputEditText = findViewById(R.id.inputEditText);
        searchButton = findViewById(R.id.searchButton);
        homeButton = findViewById(R.id.homeButton);
        webView = findViewById(R.id.webView);

        url = getIntent().getExtras().get("Url").toString();
        inputEditText.setText(url);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());

        searchButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == homeButton){
            finish();

            Intent homepage = new Intent(UrlSearch.this, MainActivity.class);
            startActivity(homepage);
        }else {

            String url_address = inputEditText.getText().toString();

            if (TextUtils.isEmpty(url_address)){
                Toast.makeText(UrlSearch.this, "Please enter Url or Web Address", Toast.LENGTH_LONG).show();
            }else {

                String url_withOut_https = url_address.replaceAll("https://www.", "");
                String https = "https://";
                String www = "www.";

                Intent search = new Intent(UrlSearch.this, UrlSearch.class);
                search.putExtra("Url", https+www+url_withOut_https);
                startActivity(search);

                inputEditText.setText("");
                inputEditText.requestFocus();
            }
        }
    }
}
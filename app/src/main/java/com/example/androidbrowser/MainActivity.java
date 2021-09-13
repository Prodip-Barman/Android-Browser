package com.example.androidbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText inputUrl;
    Button searchButton, facebook, youtube, instagram, snapchat, google, yahoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUrl = findViewById(R.id.editText);
        searchButton = findViewById(R.id.search);
        facebook = findViewById(R.id.facebook);
        youtube = findViewById(R.id.youtube);
        instagram = findViewById(R.id.instagram);
        snapchat = findViewById(R.id.snapchat);
        google = findViewById(R.id.google);
        yahoo = findViewById(R.id.yahoo);


        searchButton.setOnClickListener(this);
        facebook.setOnClickListener(this);
        youtube.setOnClickListener(this);
        instagram.setOnClickListener(this);
        snapchat.setOnClickListener(this);
        google.setOnClickListener(this);
        yahoo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == searchButton){
            openWebsite();
        }
        if (v == facebook){
            Intent openFacebook = new Intent(MainActivity.this, UrlSearch.class);
            openFacebook.putExtra("Url", "https://www.facebook.com");
            startActivity(openFacebook);
        }
        if (v == youtube){
            Intent openYoutube = new Intent(MainActivity.this, UrlSearch.class);
            openYoutube.putExtra("Url", "https://www.youtube.com");
            startActivity(openYoutube);
        }
        if (v == instagram){
            Intent openInstagram = new Intent(MainActivity.this, UrlSearch.class);
            openInstagram.putExtra("Url", "https://www.instagram.com");
            startActivity(openInstagram);
        }
        if (v == snapchat){
            Intent openSnapchat = new Intent(MainActivity.this, UrlSearch.class);
            openSnapchat.putExtra("Url", "https://www.snapchat.com");
            startActivity(openSnapchat);
        }
        if (v == google){
            Intent openGoogle = new Intent(MainActivity.this, UrlSearch.class);
            openGoogle.putExtra("Url", "https://www.google.com");
            startActivity(openGoogle);
        }
        if (v == yahoo){
            Intent openYahoo = new Intent(MainActivity.this, UrlSearch.class);
            openYahoo.putExtra("Url", "https://www.yahoo.com");
            startActivity(openYahoo);
        }
    }

    private void openWebsite() {

        String url_address = inputUrl.getText().toString();

        if (TextUtils.isEmpty(url_address)){
            Toast.makeText(MainActivity.this, "Please enter Url or Web Address", Toast.LENGTH_LONG).show();
        }else {

            String url_withOut_https = url_address.replaceAll("https://www.", "");
            String https = "https://";
            String www = "www.";

            Intent search = new Intent(MainActivity.this, UrlSearch.class);
            search.putExtra("Url", https+www+url_withOut_https);
            startActivity(search);

            inputUrl.setText("");
            inputUrl.requestFocus();
        }
    }
}
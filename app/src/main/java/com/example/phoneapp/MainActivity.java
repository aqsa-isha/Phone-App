package com.example.phoneapp;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Phone App (20SW36)");
        Button dialButton = findViewById(R.id.dialButton);
        Button saveButton = findViewById(R.id.saveButton);
        Button websiteButton = findViewById(R.id.websiteButton);
        Button searchButton = findViewById(R.id.searchButton);
        dialButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);
        websiteButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialButton:
                // Dial a number
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:1234567890")
                );
                startActivity(dialIntent);
                break;
            case R.id.saveButton:
                // Save a phone number
                Intent saveIntent = new Intent(Intent.ACTION_INSERT);
                saveIntent.setType("vnd.android.cursor.dir/contact");
                saveIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, "1234567890");
                startActivity(saveIntent);
                break;
            case R.id.websiteButton:
                // Open a website
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                websiteIntent.setData(Uri.parse("https://www.example.com"));
                startActivity(websiteIntent);
                break;
            case R.id.searchButton:
                // Search a query on Google
                Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                searchIntent.putExtra("query", "your search query");
                startActivity(searchIntent);
                break;
        }
    }
}


package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CookieActivity extends AppCompatActivity {

    private TextView points;
    private ImageView cookies;
    private int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie_activity);

        this.points = (TextView) findViewById(R.id.points);
        this.cookies = (ImageView) findViewById(R.id.cookies);

        cookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks ++;
                points.setText("Points : "+clicks);
            }
        });
    }
}

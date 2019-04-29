package com.example.myfirstapp;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private LinearLayout myLayout;
    private MainActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.myLayout = (LinearLayout) findViewById(R.id.myDynamicLayout);
        this.activity = this;

        ImageView image = new ImageView(this);
        ViewGroup.LayoutParams params = new ActionBar.LayoutParams(200, 200);
        image.setLayoutParams(params);
        image.setBackgroundResource(R.drawable.logo);
        myLayout.addView(image);

        TextView text = new TextView(this);
        text.setText(getResources().getString(R.string.dynamicText));
        text.setTextColor(getResources().getColor(R.color.colorRed));
        text.setTextSize(25);
        myLayout.addView(text);

        int textSize = 10;

        for(int i = 0; i <6; i++){
            Button button = new Button(this);
            button.setText("Button "+i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final CustomPopup customPopup = new CustomPopup(activity);
                    customPopup.setTitle("Bonne année 2018");
                    customPopup.setSubTitle("Venez jouer au Rugby");
                    customPopup.getYesButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "OUI !", Toast.LENGTH_SHORT).show();
                            customPopup.dismiss();
                        }
                    });
                    customPopup.getNoButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            customPopup.dismiss();
                        }
                    });
                    customPopup.build();
                }
            });
            button.setTextSize(textSize);
            myLayout.addView(button);
            textSize +=5;
        }
    }
}

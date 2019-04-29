package com.example.myfirstapp;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

public class CustomPopup extends Dialog {

    //fields
    private String title;
    private String subTitle;
    private Button yesButton;
    private Button noButton;
    private TextView titleView, subTitleView;

    //constructor
    public CustomPopup(Activity activity){
        super(activity, R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.my_popup_template);
        this.title = "Mon titre";
        this.subTitle = "Mon super sous-titre";
        this.yesButton = findViewById(R.id.yesButton);
        this.noButton = findViewById(R.id.noButton);
        this.titleView = findViewById(R.id.title);
        this.subTitleView = findViewById(R.id.subTitle);
    }
    public void setTitle(String title){this.title = title;}

    public void setSubTitle(String subTitle){this.subTitle = subTitle;}

    public Button getYesButton(){return yesButton;}

    public Button getNoButton(){return noButton;}

    public void build(){
        show();
        titleView.setText(title);
        subTitleView.setText(subTitle);
    }

}

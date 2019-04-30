package com.example.myshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myshop.adapteur.HightTechItemAdapter;
import com.example.myshop.models.HighTechItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List of items

        List<HighTechItem> highTechItemList = new ArrayList<>();
        highTechItemList.add((new HighTechItem("ordinateur Fixe", "computer",1000)));
        highTechItemList.add((new HighTechItem("Souris", "mouse",30)));
        highTechItemList.add(new HighTechItem("Clavier", "keyboard",70));

        //get list view
        ListView shopListView = findViewById(R.id.shop_list_view);
        shopListView.setAdapter(new HightTechItemAdapter(this, highTechItemList));
    }
}

package com.example.myshop.adapteur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshop.R;
import com.example.myshop.models.HighTechItem;

import java.util.List;

public class HightTechItemAdapter extends BaseAdapter {

    //fields
    private Context context;
    private List<HighTechItem> hightTechItemList;
    private LayoutInflater inflater;

    //constructor
    public HightTechItemAdapter(Context context, List<HighTechItem> hightTechItemList){
        this.context = context;
        this.hightTechItemList = hightTechItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return hightTechItemList.size();
    }

    @Override
    public HighTechItem getItem(int position) {
        return hightTechItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_item, null);

        //Récuper des info dans a list
        HighTechItem currItem = getItem(i);
        final String itemName = currItem.getName();
        String mnenonic = currItem.getMnemonic();
        final double itemPrice = currItem.getPrice();

        //get item icon view
        ImageView itemIconView = view.findViewById(R.id.item_icon);
        String resourceName = "item_" + mnenonic + "_icon";
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        //get item name view
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        //get item price view
        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice+" €");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Vous essayer d'acheter un " + itemName+ ", pour le prix de " + itemPrice +" €",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

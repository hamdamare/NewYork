package com.example.hamdamare.newyorknewyork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by hamdamare on 2018-01-04.
 */

public class itemadapter extends BaseAdapter {
    LayoutInflater minflator;
    String[] places;
    String[] prices;
    String[] description;




    public itemadapter(Context c, String[] p, String[] d, String[] r){
        places = p;
        prices = r;
        description = d;
        minflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        //how many items in this list
        //so we just return thelength of the items
        return places.length;


    }

    @Override
    //get particular item in the list
    public Object getItem(int i) {
        //returns items at index i
        return places[i];

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    //we explain to android how to prsent this infor
    //we need a layout inflator
    public View getView(int i, View view, ViewGroup viewGroup) {
        //how we are gonna inflate the view and put stuff in it

        View v = minflator.inflate(R.layout.mylistview_details,null);
        TextView placestextview= (TextView)v.findViewById(R.id.placestextview);
        TextView pricestextview = (TextView)v.findViewById(R.id.pricestextview);
        TextView descriptiontextview = (TextView)v.findViewById(R.id.descriptiontextview);



        String place = places[i];
        String desc = description[i];
        String price = prices[i];

        placestextview.setText(place);
        pricestextview.setText(price);
        descriptiontextview.setText(desc);

        //return the view
        return v;
    }
}



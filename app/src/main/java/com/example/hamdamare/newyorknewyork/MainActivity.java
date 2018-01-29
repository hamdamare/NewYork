package com.example.hamdamare.newyorknewyork;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mylistview;
    String[] places;
    String[] prices;
    String[] description;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        mylistview = (ListView) findViewById(R.id.listview_mylist);
        places = res.getStringArray(R.array.Places);
        prices = res.getStringArray(R.array.Prices);
        description = res.getStringArray(R.array.Description);

        itemadapter itemadapter = new itemadapter(this,places,prices,description);
        mylistview.setAdapter(itemadapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showpics = new Intent(getApplicationContext(),com.example.hamdamare.newyorknewyork.Main2Activity.class);
                showpics.putExtra("com.example.hamdamare",i);
                startActivity(showpics);
            }
        });

    }

}


package com.example.egante.practica02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class SecondActivity extends Activity {
    ListView itemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle extra = getIntent().getExtras();


        if(extra != null) {

            ArrayList<String> itemList = extra.getStringArrayList("items");
            ArrayAdapter<String> itemsAdapter =
                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);

            itemListView = findViewById(R.id.itemsListView);
            itemListView.setAdapter(itemsAdapter);


            itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String testString = Integer.toString(position);

                    Toast.makeText(SecondActivity.this, testString, Toast.LENGTH_SHORT).show();

                }
            });
        } else {
            System.out.println("Error");
        }
    }


}

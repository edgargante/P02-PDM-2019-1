package com.example.egante.practica02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    EditText userInputEditText;
    ArrayList<String> itemsAL = new ArrayList<String>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        userInputEditText = findViewById(R.id.addItemEditText);
        lv = findViewById(R.id.itemsListView);

    }

    public void goToList(View v) {
        if(v.getId() == R.id.SeeList) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("items", itemsAL);
            startActivity(intent);        }
    }

    public void addItem(View v) {
        if(isEmpty(userInputEditText)) {
            Toast.makeText(MainActivity.this, "Debes ingresar un item", Toast.LENGTH_LONG).show();
        } else {
            String newItem = userInputEditText.getText().toString();
            itemsAL.add(newItem);
            System.out.println(itemsAL);

            Intent intent = new Intent (MainActivity.this, SecondActivity.class);
            intent.putExtra("items", itemsAL);
            startActivity(intent);
            userInputEditText.getText().clear();

        }
    }



    private boolean isEmpty(EditText field) {
        return field.getText().toString().trim().length() == 0;
    }
}

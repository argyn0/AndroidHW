package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityTask2 extends AppCompatActivity {
    private ArrayList<Product> products;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.sample_image, "Product 1", 29.99));
        adapter = new CustomAdapter(this, products);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            products.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}

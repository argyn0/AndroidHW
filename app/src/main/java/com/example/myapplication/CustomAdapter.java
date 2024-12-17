package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> products;

    public CustomAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() { return products.size(); }

    @Override
    public Object getItem(int position) { return products.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.productImage);
        TextView nameView = convertView.findViewById(R.id.productName);
        TextView priceView = convertView.findViewById(R.id.productPrice);

        Product product = products.get(position);
        imageView.setImageResource(product.getImage());
        nameView.setText(product.getName());
        priceView.setText(String.valueOf(product.getPrice()));

        return convertView;
    }
}


package com.example.labreport2;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.productList = list;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        ImageView image;
        TextView title, price;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final Product product = productList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.product_image);
            holder.title = convertView.findViewById(R.id.product_title);
            holder.price = convertView.findViewById(R.id.product_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setImageResource(product.imageResId);
        holder.title.setText(product.title);
        holder.price.setText(product.price);

        convertView.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle(product.title)
                    .setMessage("Price: " + product.price)
                    .setIcon(product.imageResId)
                    .setPositiveButton("OK", null)
                    .show();
        });

        return convertView;
    }
}
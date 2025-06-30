package com.example.labreport2;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity11 extends AppCompatActivity {

    // GridView gridView;
    ListView listView;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        listView = findViewById(R.id.listView);

        productList = new ArrayList<>();

        // Add 20 dummy products (you can use same drawable for simplicity)
        for (int i = 1; i <= 20; i++) {
            productList.add(new Product("Product " + i, "Rs. " + (100 * i), R.drawable.sample_image));
        }

        ProductAdapter adapter = new ProductAdapter(this, productList);
        listView.setAdapter(adapter);
    }
}

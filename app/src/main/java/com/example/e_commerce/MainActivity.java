package com.example.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnAddToCartHoodie, btnAddToCartFridge, btnAddToCartLaptop, btnAddToCartHeadPhones,
    btnAll, btnClothing, btnElectronics, btnHome;
    private ImageView imageViewHoodie, imageViewFridge, imageViewLaptop, imageViewHeadPhones;
    private TextView textViewHoodie, textViewPriceHooide, textViewFridge, textViewPriceFridge, textViewLaptop,
    textViewPriceLaptop, textViewHeadPhones, textViewPriceHeadPhones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewHoodie = findViewById(R.id.textViewHoodie);
        textViewPriceHooide = findViewById(R.id.textViewPriceHoodie);
        textViewFridge = findViewById(R.id.textViewFridge);
        textViewPriceFridge = findViewById(R.id.textViewPriceFridge);
        textViewLaptop = findViewById(R.id.textViewLaptop);
        textViewPriceLaptop = findViewById(R.id.textViewPriceLaptop);
        textViewHeadPhones = findViewById(R.id.textViewPriceHeadPhones);

        imageViewFridge = findViewById(R.id.imageViewFridge);
        imageViewHoodie = findViewById(R.id.imageViewHoodie);
        imageViewLaptop = findViewById(R.id.imageViewLaptop);
        imageViewHeadPhones = findViewById(R.id.imageViewHeadPhones);

        imageViewHoodie.setOnClickListener(v -> openProductDetails("Casual Hoodie", "$29.99",
                R.drawable.clothes));

        imageViewFridge.setOnClickListener(v -> openProductDetails("Fridge", "$199.99",
                R.drawable.fridge));

        imageViewLaptop.setOnClickListener(v -> openProductDetails("Laptop", "$49.99",
                R.drawable.laptop));

        imageViewHeadPhones.setOnClickListener(v -> openProductDetails("HeadPhones" ,"$59.99",
                R.drawable.headphones));

    }

    public void openProductDetails(String name, String price,int image){
        Intent intent = new Intent(MainActivity.this,ProductDetailActivity.class);
        intent.putExtra("productName", name);
        intent.putExtra("productPrice", price);
        intent.putExtra("productImg", image);
        startActivity(intent);
    }
}
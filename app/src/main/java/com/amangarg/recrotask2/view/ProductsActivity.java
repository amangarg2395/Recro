package com.amangarg.recrotask2.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amangarg.recrotask2.R;
import com.amangarg.recrotask2.models.ProductsResponse;
import com.amangarg.recrotask2.presenter.ProductsContract;

public class ProductsActivity extends AppCompatActivity implements ProductsContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
    }

    @Override
    public void showMainLoader() {

    }

    @Override
    public void showProductListView(ProductsResponse productsResponse) {


    }
}

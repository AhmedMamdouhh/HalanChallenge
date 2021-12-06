package com.example.halanchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONObject;

public class ProductsListActivity extends AppCompatActivity {

    String response;

    TextView userName, phoneNumber, email;
    RecyclerView productsListRV;
    ImageView userIV,logoutIV;

    LoginResponse loginResponse;
    ProductsList productsList;

    ProductsAdapter productsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            response = bundle.getString("RESPONSE");
        }

        Gson gson = new Gson();
        loginResponse = gson.fromJson(response, LoginResponse.class);

        userName = findViewById(R.id.tv_profile_user_name);
        phoneNumber = findViewById(R.id.tv_profile_user_phone);
        email = findViewById(R.id.tv_profile_user_email);
        userIV= findViewById(R.id.iv_profile_user_image);
        logoutIV = findViewById(R.id.iv_profile_logout);

        Glide.with(this).load(loginResponse.profile.image).into(userIV);

        productsListRV = findViewById(R.id.rv_profile_products_list);

        logoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        productsListRV.setLayoutManager(mLayoutManager);

        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.get("https://assessment-sn12.halan.io/products")
                .addHeaders("Authorization", "Bearer " + loginResponse.token)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {

                    @Override
                    public void onResponse(JSONObject response) {
                        productsList = gson.fromJson(String.valueOf(response), ProductsList.class);
                        productsListAdapter = new ProductsAdapter(getBaseContext(), productsList.products);
                        productsListAdapter.notifyDataSetChanged();
                        productsListRV.setAdapter(productsListAdapter);
                        productsListAdapter.setClickListener(new ProductsAdapter.ItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                            }
                        });

                    }

                    @Override
                    public void onError(ANError error) {
                        Log.e("FastError", error.getMessage());
                    }
                });

        userName.setText(loginResponse.profile.name);
        phoneNumber.setText(loginResponse.profile.phone);
        email.setText(loginResponse.profile.email);


    }


}
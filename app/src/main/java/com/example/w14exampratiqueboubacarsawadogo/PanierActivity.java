package com.example.w14exampratiqueboubacarsawadogo;


import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.w14exampratiqueboubacarsawadogo.adapter.PanierAdapter;
import com.example.w14exampratiqueboubacarsawadogo.entities.Panier;
import com.example.w14exampratiqueboubacarsawadogo.manager.PanierManager;
import com.example.w14exampratiqueboubacarsawadogo.services.ConnexionBd;

public class PanierActivity extends AppCompatActivity {

    PanierAdapter panierAdapter;
    ListView lv;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ctx= this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        ConnexionBd.importDatabase(ctx);

        lv = findViewById(R.id.lv_panier);
        lv.setOnCreateContextMenuListener(this);
        panierAdapter = new PanierAdapter(this, R.layout.row_item_cart, PanierManager.getAll(this));
        lv.setAdapter(panierAdapter);



    }
}

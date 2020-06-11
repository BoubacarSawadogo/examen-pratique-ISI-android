package com.example.w14exampratiqueboubacarsawadogo.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.w14exampratiqueboubacarsawadogo.entities.Panier;
import com.example.w14exampratiqueboubacarsawadogo.entities.Produit;
import com.example.w14exampratiqueboubacarsawadogo.services.ConnexionBd;

import java.util.ArrayList;
import java.util.List;

public class PanierManager {

    private final static String queryGetAll = "select * from produit";

    public static List<Panier> getAll(Context ctx) {
        ArrayList<Panier> paniers = new ArrayList<>();

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);

        Cursor cursor = bd.rawQuery(queryGetAll, null);

        while (cursor.moveToNext()) {
            paniers.add(new Panier(ctx, cursor.getInt(0), cursor.getInt(1), cursor.getInt(2)));
        }

        return paniers;
    }


    public static Boolean addItemPanier(Panier panier, Context ctx) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        cv.put("id_produit", panier.getId_produit());
        cv.put("quantite", panier.getQuantite());

        long resultat = bd.insert("panier", null, cv);
        ConnexionBd.closeBd();
        if(resultat ==-1) return false;
        else return true;

    }
}

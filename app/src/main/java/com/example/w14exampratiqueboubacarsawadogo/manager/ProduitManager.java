package com.example.w14exampratiqueboubacarsawadogo.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.w14exampratiqueboubacarsawadogo.entities.Produit;
import com.example.w14exampratiqueboubacarsawadogo.services.ConnexionBd;

import java.util.ArrayList;
import java.util.List;

public class ProduitManager {

    private final static String queryGetAll = "select * from produit";
    private final static  String queryGetMidiMenu = "select * from produit where id_type_menu =" + 0 + ";" ;
    private final static  String queryGetBrunchMenu = "select * from produit where id_type_menu=" + 1+ ";";
    private final static  String queryGetDessertsMenu = "select * from produit where id_type_menu=" + 2+ ";";



    public static List<Produit> getAll(Context ctx) {
        ArrayList<Produit> produits = new ArrayList<>();

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);

        Cursor cursor = bd.rawQuery(queryGetAll, null);

        while (cursor.moveToNext()) {
            produits.add(new Produit(ctx, cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getInt(4), cursor.getString(5)));
        }

        return produits;
    }

    public static List<Produit> getMenuMidi(Context ctx) {
        ArrayList<Produit> produits = new ArrayList<>();

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);

        Cursor cursor = bd.rawQuery(queryGetMidiMenu, null);

        while (cursor.moveToNext()) {
            produits.add(new Produit(ctx, cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getInt(4), cursor.getString(5)));
        }

        return produits;
    }

    public static List<Produit> getMenuBrunch(Context ctx) {
        ArrayList<Produit> produits = new ArrayList<>();

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);

        Cursor cursor = bd.rawQuery(queryGetBrunchMenu, null);

        while (cursor.moveToNext()) {
            produits.add(new Produit(ctx, cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getInt(4), cursor.getString(5)));
        }

        return produits;
    }

    public static List<Produit> getMenuSoir(Context ctx) {
        ArrayList<Produit> produits = new ArrayList<>();

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);

        Cursor cursor = bd.rawQuery(queryGetDessertsMenu, null);

        while (cursor.moveToNext()) {
            produits.add(new Produit(ctx, cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getInt(4), cursor.getString(5)));
        }

        return produits;
    }

    public static void deleteProdui(int id,Context ctx){
        SQLiteDatabase bd=ConnexionBd.getBd(ctx);
        bd.delete("produit","id"+"=?",new String[]{String.valueOf(id)});
        ConnexionBd.closeBd();
    }


}

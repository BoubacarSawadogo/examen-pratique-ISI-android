package com.example.w14exampratiqueboubacarsawadogo.entities;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;

public class Produit {

    int id;
    String titre;
    String description;
    double prix;
    int id_type_menu;
    String nom_image;
    private Drawable imgDrawable;


    public Produit() {
    }


    public Produit(Context ctx, int id, String titre, String description, double prix, int id_type_menu, String nom_image) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.id_type_menu = id_type_menu;
        this.nom_image = nom_image;
        try {
            this.imgDrawable = Drawable.createFromStream(ctx.getAssets().open("img/"+nom_image), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Produit(String titre, String nom_image) {
        this.titre = titre;
        this.nom_image = nom_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId_type_menu() {
        return id_type_menu;
    }

    public void setId_type_menu(int id_type_menu) {
        this.id_type_menu = id_type_menu;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public Drawable getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(Drawable imgDrawable) {
        this.imgDrawable = imgDrawable;
    }
}

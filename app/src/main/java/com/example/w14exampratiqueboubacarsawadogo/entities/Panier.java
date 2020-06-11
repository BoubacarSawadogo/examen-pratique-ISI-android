package com.example.w14exampratiqueboubacarsawadogo.entities;

import android.content.Context;

public class Panier {
    int id, id_produit, quantite;

    public Panier() {
    }

    public Panier(Context ctx, int id, int id_produit, int quantite) {
        this.id = id;
        this.id_produit = id_produit;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}

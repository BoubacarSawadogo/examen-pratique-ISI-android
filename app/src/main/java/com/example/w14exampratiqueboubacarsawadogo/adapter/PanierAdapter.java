package com.example.w14exampratiqueboubacarsawadogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.w14exampratiqueboubacarsawadogo.R;
import com.example.w14exampratiqueboubacarsawadogo.entities.Panier;
import com.example.w14exampratiqueboubacarsawadogo.entities.Produit;

import java.util.List;

public class PanierAdapter  extends ArrayAdapter<Panier> {


    int idLayout;
    public PanierAdapter(@NonNull Context context, int resource, @NonNull List<Panier> objects) {
        super(context, resource, objects);
        idLayout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Panier paniers = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, null);
        TextView quantite_panier = convertView.findViewById(R.id.quantite_panier);
//////////// a revoir
        quantite_panier.setText(""+paniers.getQuantite());

        return convertView;
    }
}

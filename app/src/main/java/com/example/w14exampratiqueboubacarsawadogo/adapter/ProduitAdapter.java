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
import com.example.w14exampratiqueboubacarsawadogo.entities.Produit;

import java.util.List;

public class ProduitAdapter  extends ArrayAdapter<Produit> {


    int idLayout;
    public ProduitAdapter(@NonNull Context context, int resource, @NonNull List<Produit> objects) {
        super(context, resource, objects);
        idLayout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Produit produit = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, null);
        ImageView img = convertView.findViewById(R.id.image_item);
        TextView tv = convertView.findViewById(R.id.item_name);

        img.setImageDrawable(produit.getImgDrawable());
        tv.setText(produit.getTitre());
        return convertView;
    }
}

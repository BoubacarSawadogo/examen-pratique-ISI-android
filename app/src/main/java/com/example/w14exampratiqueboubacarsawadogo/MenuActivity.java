package com.example.w14exampratiqueboubacarsawadogo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.w14exampratiqueboubacarsawadogo.adapter.PanierAdapter;
import com.example.w14exampratiqueboubacarsawadogo.adapter.ProduitAdapter;
import com.example.w14exampratiqueboubacarsawadogo.entities.Panier;
import com.example.w14exampratiqueboubacarsawadogo.entities.Produit;
import com.example.w14exampratiqueboubacarsawadogo.manager.PanierManager;
import com.example.w14exampratiqueboubacarsawadogo.manager.ProduitManager;
import com.example.w14exampratiqueboubacarsawadogo.services.ConnexionBd;
import com.example.w14exampratiqueboubacarsawadogo.services.ExamBdAndroidDatabaseHelper;


public class MenuActivity extends AppCompatActivity {

    ProduitAdapter produitAdapter;
    ProduitAdapter produitAdaterb;
    ProduitAdapter produitAdaterc;
    ProduitAdapter produitAdaterd;
    GridView gv;
    Context ctx;
    TextView midisoir;
    TextView brunch;
    TextView desserts;
    Produit produit;
    View layoutFromXml;
    TextView tv_voir_panier;
    Panier panier;
    PanierAdapter panierAdapter;
    int quantiteProduct = 0;
    String quantiteProduct_total="0";
   // ExamBdAndroidDatabaseHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ctx = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ConnexionBd.importDatabase(ctx);

        gv = findViewById(R.id.gv);
        gv.setOnCreateContextMenuListener(this);
        midisoir = findViewById(R.id.midisoir);
        brunch = findViewById(R.id.brunch);
        desserts = findViewById(R.id.dessert);
        tv_voir_panier = findViewById(R.id.tv_voir_panier);

       // bd = new ExamBdAndroidDatabaseHelper(this, "exambdandroid", null, 1);

        produitAdapter = new ProduitAdapter(this, R.layout.activity_item_layout, ProduitManager.getAll(this));

       produitAdaterb =  new ProduitAdapter(this, R.layout.activity_item_layout, ProduitManager.getMenuMidi(this));
       produitAdaterc =  new ProduitAdapter(this, R.layout.activity_item_layout, ProduitManager.getMenuBrunch(this));
       produitAdaterd =  new ProduitAdapter(this, R.layout.activity_item_layout, ProduitManager.getMenuSoir(this));
       panierAdapter = new PanierAdapter(this, R.layout.row_item_cart, PanierManager.getAll(this));
        gv.setAdapter(produitAdapter);
        produitAdapter.notifyDataSetChanged();

        midisoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setAdapter(produitAdaterb);
                produitAdapter.notifyDataSetChanged();
            }
        });

        brunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setAdapter(produitAdaterc);
                produitAdapter.notifyDataSetChanged();
            }
        });
        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setAdapter(produitAdaterd);
                produitAdapter.notifyDataSetChanged();
            }
        });

        tv_voir_panier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versPanier = new Intent(ctx, PanierActivity.class);
                startActivity(versPanier);
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                produit = produitAdapter.getItem(position);
         //       panier = panierAdapter.getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                LayoutInflater inflater = getLayoutInflater();
                layoutFromXml = inflater.inflate(R.layout.alert_select_product, null);
                builder.setView(layoutFromXml);


                TextView titre = layoutFromXml.findViewById(R.id.titre_alert);
                TextView description = layoutFromXml.findViewById(R.id.description_alert);
                ImageView image = layoutFromXml.findViewById(R.id.image_alert);
                final TextView quantite = layoutFromXml.findViewById(R.id.quantite_alert);
                Button btn_plus = layoutFromXml.findViewById(R.id.btn_plus_alert);
                Button btn_moins = layoutFromXml.findViewById(R.id.btn_moins_alert);
                final TextView quantite_total_alert = layoutFromXml.findViewById(R.id.quantite_total_alert);

                titre.setText(produit.getTitre());
                description.setText(produit.getDescription());
                image.setImageDrawable(produit.getImgDrawable());

                btn_plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            quantiteProduct++;
                            quantite.setText(Integer.toString(quantiteProduct));
                            quantite_total_alert.setText(Integer.toString(quantiteProduct));


                    }
                });
                btn_moins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(quantiteProduct>0){
                            quantiteProduct--;
                            quantite.setText( Integer.toString(quantiteProduct));
                            quantite_total_alert.setText(Integer.toString(quantiteProduct));

                        }
                    }
                });

               quantite_total_alert.setText(quantiteProduct_total);
               String aa = quantiteProduct_total + quantiteProduct;



                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog ad = (AlertDialog) dialog;
                    }
                });
                builder.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog ad = (AlertDialog) dialog;
                    }
                });
                builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog ad2 = (AlertDialog) dialog;

                       // venteB = new Vente();
                        Panier panier = new Panier();
                    //    panier = panierAdapter.getItem(position);


                        TextView titre = layoutFromXml.findViewById(R.id.titre_alert);
                        TextView description = layoutFromXml.findViewById(R.id.description_alert);
                        ImageView image = layoutFromXml.findViewById(R.id.image_alert);
                        final TextView quantite = layoutFromXml.findViewById(R.id.quantite_alert);
                        Button btn_plus = layoutFromXml.findViewById(R.id.btn_plus_alert);
                        Button btn_moins = layoutFromXml.findViewById(R.id.btn_moins_alert);
                        final TextView quantite_total_alert = layoutFromXml.findViewById(R.id.quantite_total_alert);

                        String quantiteA = quantite.getText().toString();

                       panier.setQuantite(Integer.parseInt(quantiteA));
                        panier.setId_produit(produit.getId());


                        PanierManager.addItemPanier(panier, ctx);
                        panierAdapter.notifyDataSetChanged();
                        Toast.makeText(ctx, "Ajouter au panier", Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog dialog1 = builder.create();
                dialog1.show();
            }
        });

    }
}

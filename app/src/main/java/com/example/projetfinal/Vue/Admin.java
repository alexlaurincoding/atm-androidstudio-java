package com.example.projetfinal.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projetfinal.Controleur.ControleGuichet;
import com.example.projetfinal.Model.Client;
import com.example.projetfinal.R;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
    ArrayList<Client> clients = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    }

   public void paiementInterets(View v){
        clients = ControleGuichet.getInstance().getClients();
        for(Client c : clients){
            c.getCompteEpargne().setSoldeCompte(c.getCompteEpargne().getSoldeCompte() * c.getCompteEpargne().getTauxInteret());
        }
       Toast t = Toast.makeText(this, "Paiment des interets effectuer avec succes", Toast.LENGTH_SHORT);
       t.show();
    }

    public void afficherListeCheque(View v){
        Intent i2 = new Intent(this, ListeCompteCheques.class);

        startActivity(i2);
    }

    public void afficherListeEpargne(View v){
        Intent i3 = new Intent(this, ListeCompteEpargne.class);

        startActivity(i3);
    }

    public void afficherListeClients(View v){
        Intent i4 = new Intent(this, ListeClients.class);

        startActivity(i4);
    }
}

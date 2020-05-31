package com.example.projetfinal.Vue;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetfinal.Adapter.AdapterEpargne;
import com.example.projetfinal.Adapter.AndroidAdapter;
import com.example.projetfinal.Controleur.ControleGuichet;
import com.example.projetfinal.Model.Epargne;
import com.example.projetfinal.R;

import java.util.ArrayList;

public class ListeCompteEpargne extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_epargne);

        ArrayList<Epargne> listeEpargne;
        listeEpargne = ControleGuichet.getInstance().getListeCompteEpargnes();

        AdapterEpargne adapter = new AdapterEpargne(this, R.layout.liste_layout, listeEpargne);
        final ListView liste = findViewById(R.id.maliste);

        liste.setAdapter(adapter);

    }
}

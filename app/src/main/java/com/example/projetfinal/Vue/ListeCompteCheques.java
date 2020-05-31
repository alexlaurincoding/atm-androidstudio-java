package com.example.projetfinal.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetfinal.Adapter.AndroidAdapter;
import com.example.projetfinal.Controleur.ControleGuichet;
import com.example.projetfinal.Model.Cheque;
import com.example.projetfinal.R;

import java.util.ArrayList;

public class ListeCompteCheques extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_cheque);

        ArrayList<Cheque> listeCheque;
        listeCheque = ControleGuichet.getInstance().getListeCompteCheques();

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.liste_layout, listeCheque);
        final ListView liste = findViewById(R.id.maliste);


        liste.setAdapter(adapter);

    }
}


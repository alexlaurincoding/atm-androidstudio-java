package com.example.projetfinal.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetfinal.Adapter.AdapterClient;
import com.example.projetfinal.Adapter.AndroidAdapter;
import com.example.projetfinal.Controleur.ControleGuichet;
import com.example.projetfinal.Model.Cheque;
import com.example.projetfinal.Model.Client;
import com.example.projetfinal.R;

import java.util.ArrayList;

public class ListeClients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_client);

        ArrayList<Client> listeClients;
        listeClients = ControleGuichet.getInstance().getClients();

        AdapterClient adapter = new AdapterClient(this, R.layout.liste_layout, listeClients);
        final ListView liste = findViewById(R.id.maliste);


        liste.setAdapter(adapter);

    }
}

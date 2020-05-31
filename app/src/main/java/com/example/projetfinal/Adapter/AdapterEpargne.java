package com.example.projetfinal.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.projetfinal.Model.Epargne;
import com.example.projetfinal.R;


import java.util.ArrayList;

public class AdapterEpargne extends ArrayAdapter<Epargne> {
    private ArrayList<Epargne> listeCompte;
    private Context context;
    private int viewRes;
    private Resources res;

    public AdapterEpargne(Context context, int textViewResourceId, ArrayList<Epargne> liste) {
        super(context, textViewResourceId, liste);
        this.listeCompte = liste;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.
                    LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }
        final Epargne compteEpargne = listeCompte.get(position);
        if (compteEpargne != null) {
            final TextView noCompte = (TextView) view.findViewById(R.id.noCompte);
            final TextView solde = (TextView) view.findViewById(R.id.solde);

            String numeroCompte = res.getString(R.string.numeroCompte) + " " +compteEpargne.getNumeroCompte();

            noCompte.setText(numeroCompte);
            String soldeCompte = res.getString(R.string.soldeCompte) + " "+compteEpargne.getSoldeCompte();

            solde.setText(soldeCompte);

        }
        return view;
    }

    @Override
    public int getCount() {
        return listeCompte.size();
    }
}

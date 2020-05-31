package com.example.projetfinal.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.projetfinal.Model.Compte;

import java.io.Serializable;

public class Cheque extends Compte {


    public Cheque(String numeroNIP, String numeroCompte, double soldeCompte) {
        super(numeroNIP, numeroCompte, soldeCompte);
    }

    @Override
    public void retrait(double montant) {
        super.retrait(montant);
    }

    @Override
    public void depot(double montant) {
        super.depot(montant);
    }

    @Override
    public String getNumeroNIP() {
        return super.getNumeroNIP();
    }

    @Override
    public void setNumeroNIP(String numeroNIP) {
        super.setNumeroNIP(numeroNIP);
    }

    @Override
    public String getNumeroCompte() {
        return super.getNumeroCompte();
    }

    @Override
    public void setNumeroCompte(String numeroCompte) {
        super.setNumeroCompte(numeroCompte);
    }

    @Override
    public double getSoldeCompte() {
        return super.getSoldeCompte();
    }

    @Override
    public void setSoldeCompte(double soldeCompte) {
        super.setSoldeCompte(soldeCompte);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Cheque";
    }
}

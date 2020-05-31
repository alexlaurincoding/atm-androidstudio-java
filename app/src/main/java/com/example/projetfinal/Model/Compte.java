package com.example.projetfinal.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Compte implements Serializable {
    private String numeroNIP, numeroCompte;
    private double soldeCompte;

    public Compte(String numeroNIP, String numeroCompte, double soldeCompte) {
        this.numeroNIP = numeroNIP;
        this.numeroCompte = numeroCompte;
        this.soldeCompte = soldeCompte;
    }

    public void retrait(double montant){
        this.soldeCompte -= montant;
    }

    public void depot(double montant){
        this.soldeCompte += montant;
    }

    public String getNumeroNIP() {
        return numeroNIP;
    }

    public void setNumeroNIP(String numeroNIP) {
        this.numeroNIP = numeroNIP;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte)) return false;
        Compte compte = (Compte) o;
        return Double.compare(compte.getSoldeCompte(), getSoldeCompte()) == 0 &&
                Objects.equals(getNumeroNIP(), compte.getNumeroNIP()) &&
                Objects.equals(getNumeroCompte(), compte.getNumeroCompte());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getNumeroNIP(), getNumeroCompte(), getSoldeCompte());
    }
}

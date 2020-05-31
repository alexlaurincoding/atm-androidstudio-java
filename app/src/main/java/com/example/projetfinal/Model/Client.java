package com.example.projetfinal.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {

    private String nom;
    private String prenom;
    private String username;
    private String noNIP;
    private Cheque CompteCheque;
    private Epargne compteEpargne;

    public Client(String nom, String prenom, String username, String noNIP, Cheque compteCheque, Epargne compteEpargne) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.noNIP = noNIP;
        this.CompteCheque = compteCheque;
        this.compteEpargne = compteEpargne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoNIP() {
        return noNIP;
    }

    public void setNoNIP(String noNIP) {
        this.noNIP = noNIP;
    }

    public Cheque getCompteCheque() {
        return CompteCheque;
    }

    public void setCompteCheque(Cheque compteCheque) {
        CompteCheque = compteCheque;
    }

    public Epargne getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(Epargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getNoNIP() == client.getNoNIP() &&
                Objects.equals(getNom(), client.getNom()) &&
                Objects.equals(getPrenom(), client.getPrenom()) &&
                Objects.equals(getUsername(), client.getUsername()) &&
                Objects.equals(getCompteCheque(), client.getCompteCheque()) &&
                Objects.equals(getCompteEpargne(), client.getCompteEpargne());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getUsername(), getNoNIP(), getCompteCheque(), getCompteEpargne());
    }
}

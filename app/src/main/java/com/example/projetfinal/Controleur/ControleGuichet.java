package com.example.projetfinal.Controleur;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.projetfinal.Model.Cheque;
import com.example.projetfinal.Model.Client;
import com.example.projetfinal.Model.Compte;
import com.example.projetfinal.Model.Epargne;
import com.example.projetfinal.Vue.Admin;
import com.example.projetfinal.Vue.Guichet;
import com.example.projetfinal.Vue.Login;

import java.util.ArrayList;

public class ControleGuichet {

    private static ControleGuichet Instance = null;
    private Client clientActif;
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Cheque> listeCompteCheques = new ArrayList<>();
    private ArrayList<Epargne> listeCompteEpargnes = new ArrayList<>();

    private ControleGuichet(){
        loadClients();

    }

    public Client getClientActif() {
        return clientActif;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Cheque> getListeCompteCheques(){
        return listeCompteCheques;
    }

    private void loadClients() {
        Cheque cheque1 = new Cheque("1111", "91111", 10000);
        Epargne epargne1 = new Epargne("1111", "81111", 50000);
        Client client1 = new Client("Laurin", "Alexandre", "alex", "1111", cheque1, epargne1);
        Cheque cheque2 = new Cheque("2222", "92222", 10000);
        Epargne epargne2 = new Epargne("2222", "82222", 50000);
        Client client2 = new Client("Bellal", "Toufik", "toufik", "2222", cheque2, epargne2);
        Cheque cheque3 = new Cheque("3333", "93333", 10000);
        Epargne epargne3 = new Epargne("3333", "83333", 50000);
        Client client3 = new Client("Tardif", "Emmanuelle", "emma", "3333", cheque3, epargne3);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        listeCompteCheques.add(cheque1);
        listeCompteCheques.add(cheque2);
        listeCompteCheques.add(cheque3);
        listeCompteEpargnes.add(epargne1);
        listeCompteEpargnes.add(epargne2);
        listeCompteEpargnes.add(epargne3);
    }


    public boolean autentification(String nom, String nip) {

        for (Client c : clients) {

            if (c.getUsername().equals(nom) && c.getNoNIP().equals(nip)) {
                clientActif = c;
                return true;
            }
        }
        return false;
    }



    public static final ControleGuichet getInstance(){
        if(Instance == null){
            Instance = new ControleGuichet();
        }
        return Instance;
    }

    public ArrayList<Epargne> getListeCompteEpargnes() {
        return listeCompteEpargnes;
    }

    public void depot(int montant, Compte compte){
        compte.setSoldeCompte(compte.getSoldeCompte() + montant);
        //Toast t = Toast.makeText(this, "Dépot de " + montant + "$ dans votre compte " + compte.toString() , Toast.LENGTH_SHORT);
        //t.show();
    }

    public void retrait(int montant, Compte compte){
        compte.setSoldeCompte(compte.getSoldeCompte() - montant);
        //Toast t = Toast.makeText(this, "Retrait de " + montant + "$ dans votre compte " + compte.toString() , Toast.LENGTH_SHORT);
        //t.show();
    }

    public void virement(int montant, Compte compteSource, Compte compteDestination){
        compteSource.setSoldeCompte(compteSource.getSoldeCompte() - montant);
        compteDestination.setSoldeCompte(compteDestination.getSoldeCompte() + montant);
       // Toast t = Toast.makeText(this, "Virement de " + montant + "$ de votre compte " + compteSource.toString() + " vers votre compte " + compteDestination.toString() , Toast.LENGTH_SHORT);
        //t.show();
    }

}



package com.example.projetfinal.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetfinal.Controleur.ControleGuichet;
import com.example.projetfinal.Model.Compte;
import com.example.projetfinal.R;

public class Guichet extends AppCompatActivity {
TextView lblBonjour, lblSoldeCheque, lblSoldeEpargne;
EditText txtMontantEntrer;
Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPoint, btnC;
RadioButton rBtnDepot, rBtnRetrait, rBtnVirement, rBtnCheque, rBtnEpargne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guichet);
        lblBonjour = (TextView) findViewById(R.id.lblBonjour);
        lblBonjour.setText("Bonjour "+ ControleGuichet.getInstance().getClientActif().getPrenom() + " " + ControleGuichet.getInstance().getClientActif().getNom());
        init();
    }

    public void init() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnC = (Button) findViewById(R.id.btnC);
        txtMontantEntrer = (EditText) findViewById(R.id.txtMontantEntrer);
        lblSoldeCheque = (TextView) findViewById(R.id.lblSoldeCheque);
        lblSoldeEpargne = (TextView) findViewById((R.id.lblSoldeEpargne));
        rBtnDepot = (RadioButton) findViewById(R.id.rBtnDepot);
        rBtnRetrait = (RadioButton) findViewById(R.id.rBtnRetrait);
        rBtnVirement = (RadioButton) findViewById(R.id.rBtnVirement);
        rBtnCheque = (RadioButton) findViewById(R.id.rBtnCheque);
        rBtnEpargne = (RadioButton) findViewById(R.id.rBtnEpargne);
    }

    public void afficherSolde(View v){
        lblSoldeCheque.setText("Solde compte Chèque : " + ControleGuichet.getInstance().getClientActif().getCompteCheque().getSoldeCompte());
        lblSoldeEpargne.setText("Solde compte Épargne : " + ControleGuichet.getInstance().getClientActif().getCompteEpargne().getSoldeCompte());
    }

    public void clickSoumettre(View v){
        if(txtMontantEntrer.getText().toString().isEmpty()){
            toast("Veuillez entrer un montant");
        }else {
            int montant = Integer.parseInt(txtMontantEntrer.getText().toString());

            if (rBtnCheque.isChecked()) {
                if (rBtnDepot.isChecked()) {
                    ControleGuichet.getInstance().depot(montant, ControleGuichet.getInstance().getClientActif().getCompteCheque());
                    toastOperation("Depot", montant, ControleGuichet.getInstance().getClientActif().getCompteCheque() );
                } else if (montant > ControleGuichet.getInstance().getClientActif().getCompteCheque().getSoldeCompte()) {
                    toast("Manque de fond");
                } else if (rBtnRetrait.isChecked()) {
                    if(montant <= 1000) {
                        if(montant%10 == 0) {
                            ControleGuichet.getInstance().retrait(montant, ControleGuichet.getInstance().getClientActif().getCompteCheque());
                            toastOperation("Retrait", montant, ControleGuichet.getInstance().getClientActif().getCompteCheque());
                        }else{
                            toast("Le retrait doit etre un multiple de 10");
                            }
                    }else{
                        toast("Le montant maximum est de 1000$ pour un retrait");
                    }
                } else if (rBtnVirement.isChecked()) {
                    ControleGuichet.getInstance().virement(montant, ControleGuichet.getInstance().getClientActif().getCompteCheque(), ControleGuichet.getInstance().getClientActif().getCompteEpargne());
                    toastOperation("Virement", montant, ControleGuichet.getInstance().getClientActif().getCompteCheque(), ControleGuichet.getInstance().getClientActif().getCompteEpargne());
            } else {
                toast("Veuillez selectionner une operation a effectuer");
            }

            }else if(rBtnEpargne.isChecked()){
                if(rBtnDepot.isChecked()){
                    ControleGuichet.getInstance().depot(montant, ControleGuichet.getInstance().getClientActif().getCompteEpargne());
                    toastOperation("Depot", montant, ControleGuichet.getInstance().getClientActif().getCompteEpargne());
                }else if (montant > ControleGuichet.getInstance().getClientActif().getCompteEpargne().getSoldeCompte()) {
                    toast("Manque de fond");
                } else if (rBtnRetrait.isChecked()){
                    if(montant <= 1000) {
                        if (montant % 10 == 0) {
                            ControleGuichet.getInstance().retrait(montant, ControleGuichet.getInstance().getClientActif().getCompteEpargne());
                            toastOperation("Retrait", montant, ControleGuichet.getInstance().getClientActif().getCompteEpargne());
                        } else {
                            toast("Le retrait doit etre un multiple de 10");
                        }
                    }else{
                        toast("Le montant maximum est de 1000$");
                    }
                }else if(rBtnVirement.isChecked()){
                    if(montant <= 10000) {
                    ControleGuichet.getInstance().virement(montant, ControleGuichet.getInstance().getClientActif().getCompteEpargne(), ControleGuichet.getInstance().getClientActif().getCompteCheque());
                    toastOperation("Virement", montant, ControleGuichet.getInstance().getClientActif().getCompteEpargne(), ControleGuichet.getInstance().getClientActif().getCompteCheque() );
                    }else{
                        toast("Le montant maximum est de 10000$ pour un virement.");
                    }
                }else{
                    toast("Veuillez selectionner une operation a effectuer");
                }
            }
            txtMontantEntrer.setText("");
        }


    }

    public void toast(String message){
        Toast t = Toast.makeText(this, message, Toast.LENGTH_LONG);
        t.show();
    }

    public void toastOperation(String operation, int montant, Compte compte){

        Toast t = Toast.makeText(this, operation +" de " + montant + "$ dans votre compte " + compte.toString() +"\nSolde compte " + compte.toString() + ": " + compte.getSoldeCompte() + "$", Toast.LENGTH_LONG);
        t.show();
    }

    public void toastOperation(String operation, int montant, Compte compte1, Compte compte2){

        Toast t = Toast.makeText(this, operation +" de " + montant + "$ de votre compte " + compte1.toString() + " a votre compte " + compte2.toString() +
                "\nSolde compte "+ compte1.toString() + ": " + compte1.getSoldeCompte() + "$"
                +"\nSoldeCompte "+ compte2.toString() + ": " + compte2.getSoldeCompte() + "$", Toast.LENGTH_LONG);
        t.show();
    }


    public void numberClick(View v){
        switch(v.getId()){
            case (R.id.btn0):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"0");
                break;
            case (R.id.btn1):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"1");
                break;
            case (R.id.btn2):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"2");
                break;
            case (R.id.btn3):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"3");
                break;
            case (R.id.btn4):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"4");
                break;
            case (R.id.btn5):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"5");
                break;
            case (R.id.btn6):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"6");
                break;
            case (R.id.btn7):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"7");
                break;
            case (R.id.btn8):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"8");
                break;
            case (R.id.btn9):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+"9");
                break;
            case (R.id.btnPoint):
                txtMontantEntrer.setText(txtMontantEntrer.getText()+".");
                break;
            case (R.id.btnC):
                txtMontantEntrer.setText("");
                break;
        }
    }



}

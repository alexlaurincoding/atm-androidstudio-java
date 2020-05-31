package com.example.projetfinal.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.projetfinal.Controleur.ControleGuichet;
import com.example.projetfinal.Model.Client;
import com.example.projetfinal.R;

import java.util.ArrayList;


public class Login extends AppCompatActivity{
    EditText txtUsername, txtPassword;
    Button btnLogin;
    ArrayList<Client> clients = new ArrayList<>();
    int compteur = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtNIP);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    public void clickLogin(View v)  {
        if (isEmpty(txtUsername) && isEmpty(txtPassword)) {
            Toast t = Toast.makeText(this, "Veuillez entrer vos informations!", Toast.LENGTH_SHORT);
            t.show();
        }else if(isEmpty(txtUsername)) {
            Toast t = Toast.makeText(this, "Veuillez entrer votre nom d'utilisateur!", Toast.LENGTH_SHORT);
            t.show();
        }else if(isEmpty(txtPassword)) {
            Toast t = Toast.makeText(this, "Veuillez entrer votre mot de passe!", Toast.LENGTH_SHORT);
            t.show();
        }else{
            String nom = txtUsername.getText().toString();
            String nip = txtPassword.getText().toString();
            if(nom.equals("Admin") && nip.equals("D001")){
                Intent i = new Intent(this, Admin.class);
                i.putExtra("CLIENTS", clients);
                startActivity(i);
            }else if (compteur != 0) {
                int i= 1;
                        if (ControleGuichet.getInstance().autentification(nom, nip)) {
                        Intent intent = new Intent(this, Guichet.class);
                        startActivity(intent);

                    } else {
                            compteur--;
                            if (compteur == 0) {
                                Toast t = Toast.makeText(this, "Vous avez epuiser vos tentatives de connections", Toast.LENGTH_SHORT);
                                t.show();
                            } else {
                                Toast t = Toast.makeText(this, "Information invalide. Il vous reste " + compteur + " essaie.", Toast.LENGTH_SHORT);
                                t.show();
                            }
                        }
            } else {
                Toast t = Toast.makeText(this, "Veuillez reesseiller plus tard.", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}

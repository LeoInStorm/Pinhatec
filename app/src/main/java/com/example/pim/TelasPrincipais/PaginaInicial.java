package com.example.pim.TelasPrincipais;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pim.menus.MenuBaterPonto;
import com.example.pim.menus.MenuDeOpcoes;
import com.example.pim.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.ktx.Firebase;

public class PaginaInicial extends AppCompatActivity {

    ImageView bthome,btrendimentos,btopc,btajuda,Btponto;
    TextView NomeFuncionario,Cargo,cnpj;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String UsuarioiD;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);

        bthome = findViewById(R.id.bthome);
        btrendimentos = findViewById(R.id.btrendimentos);
        btopc = findViewById(R.id.btopc);
        btajuda = findViewById(R.id.btajuda);
        Btponto = findViewById(R.id.Btponto);
        IniciarComponentes();

        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaohome = new Intent(getApplicationContext(), PaginaInicial.class);
                startActivity(botaohome);
            }
        });

        btrendimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaorendimento = new Intent(getApplicationContext(),HistoricoPagamentos.class);
                startActivity(botaorendimento);

            }
        });

        btopc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaopc = new Intent(getApplicationContext(), MenuDeOpcoes.class);
                startActivity(botaopc);

            }
        });

        btajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaoajuda = new Intent(getApplicationContext(),MenuAjuda.class);
                startActivity(botaoajuda);

            }
        });

        Btponto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaoponto = new Intent(getApplicationContext(), MenuBaterPonto.class);
                startActivity(botaoponto
                );

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        UsuarioiD = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(UsuarioiD);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot != null){
                    NomeFuncionario.setText(documentSnapshot.getString("nome"));
                    Cargo.setText(documentSnapshot.getString("cargo"));
                    cnpj.setText(documentSnapshot.getString("cnpj"));
                }
            }
        });
    }

    private void IniciarComponentes(){
        NomeFuncionario = findViewById(R.id.NomeFuncionario);
        Cargo = findViewById(R.id.Cargo);
        cnpj = findViewById(R.id.cpnj);

    }
}
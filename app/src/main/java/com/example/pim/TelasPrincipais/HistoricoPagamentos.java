package com.example.pim.TelasPrincipais;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pim.menus.MenuDeOpcoes;
import com.example.pim.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class HistoricoPagamentos extends AppCompatActivity {

    ImageView bthome,btrendimentos,btopc,btajuda;
    TextView Pagamento03,Pagamento04,Pagamento05,Pagamento06,Pagamento07,Pagamento08;

    String UsuarioiD;

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_pagamentos);

        bthome = findViewById(R.id.bthome);
        btrendimentos = findViewById(R.id.btrendimentos);
        btopc = findViewById(R.id.btopc);
        btajuda = findViewById(R.id.btajuda);


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
                    Pagamento03.setText(documentSnapshot.getString("Pag03"));
                    Pagamento04.setText(documentSnapshot.getString("Pag04"));
                    Pagamento05.setText(documentSnapshot.getString("Pag05"));
                    Pagamento06.setText(documentSnapshot.getString("Pag06"));
                    Pagamento07.setText(documentSnapshot.getString("Pag07"));
                    Pagamento08.setText(documentSnapshot.getString("Pag08"));

                }
            }
        });
    }

    private void IniciarComponentes(){

        Pagamento03 = findViewById(R.id.Pagamento03);
        Pagamento04 = findViewById(R.id.Pagamento04);
        Pagamento05 = findViewById(R.id.Pagamento05);
        Pagamento06 = findViewById(R.id.Pagamento06);
        Pagamento07 = findViewById(R.id.Pagamento07);
        Pagamento08 = findViewById(R.id.Pagamento08);
    }
}
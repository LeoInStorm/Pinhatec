package com.example.pim.menus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pim.R;
import com.example.pim.TelasPrincipais.HistoricoPagamentos;
import com.example.pim.TelasPrincipais.MenuAjuda;
import com.example.pim.TelasPrincipais.PaginaInicial;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MenuDeBeneficios extends AppCompatActivity {

    ImageView bthome,btrendimentos,btopc,btajuda;
    TextView text01,text02,text03,text04,text05;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String UsuarioiD;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_de_beneficios);

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
                Intent botaorendimento = new Intent(getApplicationContext(), HistoricoPagamentos.class);
                startActivity(botaorendimento);

            }
        });

        btopc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaopc = new Intent(getApplicationContext(),MenuDeOpcoes.class);
                startActivity(botaopc);

            }
        });

        btajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaoajuda = new Intent(getApplicationContext(), MenuAjuda.class);
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
                    text01.setText(documentSnapshot.getString("convenioMed"));
                    text02.setText(documentSnapshot.getString("convenioOdo"));
                    text03.setText(documentSnapshot.getString("VA"));
                    text04.setText(documentSnapshot.getString("VR"));
                    text05.setText(documentSnapshot.getString("valeTransporte"));
                }
            }
        });
    }


    private void IniciarComponentes(){
        text01= findViewById(R.id.text01);
        text02= findViewById(R.id.text02);
        text03= findViewById(R.id.text03);
        text04= findViewById(R.id.text04);
        text05= findViewById(R.id.text05);

    }

}
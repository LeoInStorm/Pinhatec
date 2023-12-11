package com.example.pim.TelasPrincipais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pim.menus.MenuDeOpcoes;
import com.example.pim.R;

public class MenuAjuda extends AppCompatActivity {

    ImageView bthome,btrendimentos,btopc,btajuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ajuda);



        bthome = findViewById(R.id.bthome);
        btrendimentos = findViewById(R.id.btrendimentos);
        btopc = findViewById(R.id.btopc);
        btajuda = findViewById(R.id.btajuda);

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
}
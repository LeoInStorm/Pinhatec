package com.example.pim.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pim.R;
import com.example.pim.TelasPrincipais.HistoricoPagamentos;
import com.example.pim.TelasPrincipais.MainActivity;
import com.example.pim.TelasPrincipais.MenuAjuda;
import com.example.pim.TelasPrincipais.PaginaInicial;

public class MenuBaterPonto extends AppCompatActivity {

    ImageView bthome,btrendimentos,btopc,btajuda,bt_entrada,bt_saida,bt_cancela,bt_confirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bater_ponto);

        bthome = findViewById(R.id.bthome);
        btrendimentos = findViewById(R.id.btrendimentos);
        btopc = findViewById(R.id.btopc);
        btajuda = findViewById(R.id.btajuda);
        bt_entrada = findViewById(R.id.bt_entrada);
        bt_saida = findViewById(R.id.bt_saida);
        bt_confirma = findViewById(R.id.bt_confirma);
        bt_cancela = findViewById(R.id.bt_cancela);

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
        bt_saida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        bt_entrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bt_cancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaohome = new Intent(getApplicationContext(), PaginaInicial.class);
                startActivity(botaohome);
            }
        });

        bt_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuBaterPonto.this,"O ponto foi marcado",Toast.LENGTH_LONG).show();

            }
        });


    }
}
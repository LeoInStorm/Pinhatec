package com.example.pim.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pim.R;
import com.example.pim.TelasPrincipais.HistoricoPagamentos;
import com.example.pim.TelasPrincipais.MenuAjuda;
import com.example.pim.TelasPrincipais.MenuPonto;
import com.example.pim.TelasPrincipais.PaginaInicial;

public class MenuDeOpcoes extends AppCompatActivity {

    ImageView bthome, btrendimentos, btopc, btajuda, Bt_opc_cadastro, bt_opc_benef, bt_opc_ponto, bt_opc_rendimentos, bt_opc_ferias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_de_opcoes);


        bthome = findViewById(R.id.bthome);
        btrendimentos = findViewById(R.id.btrendimentos);
        btopc = findViewById(R.id.btopc);
        btajuda = findViewById(R.id.btajuda);
        Bt_opc_cadastro = findViewById(R.id.Bt_opc_cadastro);
        bt_opc_benef = findViewById(R.id.bt_opc_benef);
        bt_opc_ponto = findViewById(R.id.bt_opc_ponto);
        bt_opc_rendimentos = findViewById(R.id.bt_opc_rendimentos);
        bt_opc_ferias = findViewById(R.id.bt_opc_ferias);

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
                Intent botaopc = new Intent(getApplicationContext(), MenuDeOpcoes.class);
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

        Bt_opc_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaocadastro = new Intent(getApplicationContext(), MenuDeCadastro.class);
                startActivity(botaocadastro);

            }
        });
        bt_opc_benef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaobeneficios = new Intent(getApplicationContext(), MenuDeBeneficios.class);
                startActivity(botaobeneficios);

            }
        });

        bt_opc_ponto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaoponto = new Intent(getApplicationContext(), MenuPonto.class);
                startActivity(botaoponto);

            }
        });

        bt_opc_rendimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaorendimentos = new Intent(getApplicationContext(), MenuInformeDeRendimentos.class);
                startActivity(botaorendimentos);

            }
        });

        bt_opc_ferias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botaoferias = new Intent(getApplicationContext(), MenuDeFerias.class);
                startActivity(botaoferias);

            }
        });



    }
}
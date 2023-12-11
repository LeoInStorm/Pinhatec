package com.example.pim.TelasPrincipais;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pim.Db.model.Usuario;
import com.example.pim.Db.dao.UsuarioDAO;
import com.example.pim.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    EditText Login, Senha;
    ImageView btlogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.login);
        Senha = findViewById(R.id.Senha);

        btlogin = findViewById(R.id.btLogin);
        
    }


    public void login(View view) {

        String usuario = Login.getText().toString();
        String senha = Senha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(usuario,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Proxtela();
                }
                else {
                    limpar();
                }
            }
        });


    }

    private void limpar() {
        Toast.makeText(MainActivity.this,"Login ou Senha incorretos",Toast.LENGTH_LONG).show();
        Login.requestFocus();

    }

    private void Proxtela(){
        Intent intent = new Intent(MainActivity.this,PaginaInicial.class);
        startActivity(intent);
        finish();
    }

}







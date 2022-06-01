package com.example.transiotela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etSenha;
    Button btnEntrar;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);

        btnEntrar = findViewById(R.id.btnEntrar);
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("chaveGeral", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("chaveEmail", etEmail.getText().toString());
                editor.putString("chaveSenha", etSenha.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"Gravado com sucesso!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),SegundaTela.class);
                startActivity(intent);


            }
        });

    }

}
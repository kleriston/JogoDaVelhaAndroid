package com.example.marcia.jogodavelha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mult;
    private  Button andro;
    private Button pontuacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mult = (Button) findViewById(R.id.ent);
        andro = (Button) findViewById(R.id.ent1);
        pontuacao = (Button) findViewById(R.id.pont);

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Jogo.class);
                startActivity(i);

            }
        });

        andro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, Andro.class);
                startActivity(j);
            }
        });

        pontuacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent x = new Intent(MainActivity.this, Pontuacao.class);
                startActivity(x);
            }
        });


    }
}

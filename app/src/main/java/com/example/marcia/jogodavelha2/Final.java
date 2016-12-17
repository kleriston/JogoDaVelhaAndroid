package com.example.marcia.jogodavelha2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Marcia on 30/08/2016.
 */
public class Final extends AppCompatActivity {

    private Button voltar;
    private  Button sair;

    private TextView ganhador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i = getIntent();

        String g = (String) i.getExtras().getCharSequence("textView");


        TextView mensagem = (TextView) findViewById(R.id.textView);
        if(g.equals("Jogador 1 Ganhou")){
            mensagem.setTextColor(getResources().getColor(R.color.colorPrimary));
            mensagem.setText(g);
        }if (g.equals("Jogador 2 Ganhou")){
            mensagem.setTextColor(getResources().getColor(R.color.colorAccent));
            mensagem.setText(g);
        } if (g.equals("A  Velha Ganhou")){
            mensagem.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            mensagem.setText(g);
        }



        mensagem.setText(g);

        voltar = (Button) findViewById(R.id.button1);
        sair = (Button) findViewById(R.id.button_sair);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Final.this, Jogo.class);
                startActivity(i);
            }
        });


        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Final.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

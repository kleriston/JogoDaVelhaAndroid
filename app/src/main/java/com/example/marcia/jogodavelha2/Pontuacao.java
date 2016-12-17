package com.example.marcia.jogodavelha2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Marcia on 06/09/2016.
 */
public class Pontuacao extends AppCompatActivity {

    private Button voltar;
    private  Button sair;
    private  Button resetar;
    TextView jog1;
    TextView jog2;
    TextView emp;

    int pont_j1=0;
    int pont_j2=0;
    int empate = 0;
    private List<Resultados> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        Intent i = getIntent();


        jog1 = (TextView) findViewById(R.id.jog1);
        jog2 = (TextView) findViewById(R.id.jog2);
        emp = (TextView)findViewById(R.id.empate);
        lista = new ArrayList<>();


        Iterator<Resultados> listaI = Resultados.findAll(Resultados.class);



        while (listaI.hasNext()){
          Resultados res = listaI.next();
            lista.add(res);

        }
        for (int j=0; j<lista.size();j++) {

            pont_j1 += lista.get(j).getJogador1();
            pont_j2 += lista.get(j).getJogador2();
            empate  += lista.get(j).getVelha();
        }
       jog1.setText("Jogador X:>>>>> "+pont_j1);
        jog2.setText("Jogador O:>>>>> "+pont_j2);
        emp.setText("Empate >>>>> "+ empate);

        voltar = (Button) findViewById(R.id.button1);
        sair = (Button) findViewById(R.id.button_sair);
        resetar =(Button)findViewById(R.id.reset);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Pontuacao.this, Jogo.class);
                startActivity(i);
            }
        });


        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pontuacao.this, MainActivity.class);
                startActivity(i);
            }
        });

        resetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Resultados.deleteAll(Resultados.class);
                    Toast.makeText(getApplicationContext(), "Resete Efetuado com Sucesso", Toast.LENGTH_LONG).show();
                    Intent j = new Intent(Pontuacao.this, MainActivity.class);
                    startActivity(j);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro!", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
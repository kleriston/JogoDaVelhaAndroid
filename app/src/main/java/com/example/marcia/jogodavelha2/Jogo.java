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
 * Created by Marcia on 30/08/2016.
 */
public class Jogo extends AppCompatActivity implements View.OnClickListener{

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;

    private int jogadas;
    private String inicio = "X";
    int cont = 0;

    Resultados res;
    String result1="";
    String result2="Jogador 2 =";

    private TextView ganhador;

    private  List<Resultados> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);


        b1 = (Button) findViewById(R.id.botao1);
        b2 = (Button) findViewById(R.id.botao2);
        b3 = (Button) findViewById(R.id.botao3);
        b4 = (Button) findViewById(R.id.botao4);
        b5 = (Button) findViewById(R.id.botao5);
        b6 = (Button) findViewById(R.id.botao6);
        b7 = (Button) findViewById(R.id.botao7);
        b8 = (Button) findViewById(R.id.botao8);
        b9 = (Button) findViewById(R.id.botao9);

        ganhador = (TextView) findViewById(R.id.textView);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    public int verificaGanhador(int n){

        if (n==9){
            res = new Resultados(0,0,1);
            res.save();
            Intent j = new Intent(Jogo.this, Pontuacao.class);
            startActivity(j);
        }

        List<String> combinaçoes = new ArrayList<>();

        combinaçoes.add(b1.getText().toString() + b2.getText().toString() + b3.getText().toString());
        combinaçoes.add(b4.getText().toString() + b5.getText().toString() + b6.getText().toString());
        combinaçoes.add(b7.getText().toString() + b8.getText().toString() + b9.getText().toString());

        combinaçoes.add(b1.getText().toString() + b4.getText().toString() + b7.getText().toString());
        combinaçoes.add(b2.getText().toString() + b5.getText().toString() + b8.getText().toString());
        combinaçoes.add(b3.getText().toString() + b6.getText().toString() + b9.getText().toString());

        combinaçoes.add(b1.getText().toString() + b5.getText().toString() + b9.getText().toString());
        combinaçoes.add(b3.getText().toString() + b5.getText().toString() + b7.getText().toString());



        for (int i=0; i <combinaçoes.size();i++){
            if(combinaçoes.get(i).equals("XXX")){


                res = new Resultados(1,0,0);
                res.save();
                Intent j = new Intent(Jogo.this, Pontuacao.class);
                startActivity(j);

            }else if(combinaçoes.get(i).equals("OOO")){



                res = new Resultados(0,1,0);
                res.save();

                Intent j = new Intent(Jogo.this, Pontuacao.class);
                startActivity(j);



            }
        }

        return cont;
    }

    @Override
    public void onClick(View v) {



        if(((Button)v).getText().equals("X") || ((Button)v).getText().equals("O") ){
            Toast.makeText(getApplicationContext(),"Opa! Jogue Novamente", Toast.LENGTH_LONG).show();
        }else{

            jogadas = jogadas +1;
            if(inicio.equals("X")){

                ((Button)v).setText("X");
                ((Button)v).setTextColor(getResources().getColor(R.color.colorPrimary));
                verificaGanhador(jogadas);


                inicio="O";

            }else{

                ((Button)v).setText("O");
                ((Button)v).setTextColor(getResources().getColor(R.color.colorAccent));
                verificaGanhador(jogadas);

                inicio="X";
            }
        }
    }



}

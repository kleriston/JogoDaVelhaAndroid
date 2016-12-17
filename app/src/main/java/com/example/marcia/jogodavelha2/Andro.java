package com.example.marcia.jogodavelha2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcia on 05/09/2016.
 */
public class Andro extends AppCompatActivity implements View.OnClickListener {

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

    List<Button> lista = new ArrayList<Button>();

    private TextView ganhador;
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

        lista.add(b1);
        lista.add(b2);
        lista.add(b3);
        lista.add(b4);
        lista.add(b5);
        lista.add(b6);
        lista.add(b7);
        lista.add(b8);
        lista.add(b9);

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
        jogadaAndroid();
    }

    @Override
    public void onClick(View v) {

        ((Button)v).setText("X");
        ((Button)v).setTextColor(getResources().getColor(R.color.colorPrimary));

        jogadaAndroid();
        verificaGanhador(jogadas);
    }

    public void  jogadaAndroid(){

        for (int i=0; i <lista.size();i++){

            if (lista.get(4).getText().equals("")){
               lista.get(4).setTextColor(getResources().getColor(R.color.colorAccent));
                lista.get(4).setText("O");
            }else{
                if(lista.get(3).getText().equals("X") && lista.get(8).getText().equals("")){
                    lista.get(8).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(8).setText("O");
                    break;
                }

                if(lista.get(5).getText().equals("X") && lista.get(0).getText().equals("")){
                    lista.get(0).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(0).setText("O");
                    break;
                }

                if(lista.get(0).getText().equals("X") && lista.get(5).getText().equals("")){
                    lista.get(5).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(5).setText("O");
                    break;
                }

                if(lista.get(1).getText().equals("X") && lista.get(3).getText().equals("") ) {
                    lista.get(3).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(3).setText("O");
                    break;
                }

                if(lista.get(1).getText().equals("X") && lista.get(6).getText().equals("") ) {
                    lista.get(6).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(6).setText("O");
                    break;
                }

                if(lista.get(2).getText().equals("X") && lista.get(5).getText().equals("") ) {
                    lista.get(6).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(6).setText("O");
                    break;
                }

                if(lista.get(6).getText().equals("X") && lista.get(0).getText().equals("") ) {
                    lista.get(0).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(0).setText("O");
                    break;
                }
                if(lista.get(7).getText().equals("X") && lista.get(1).getText().equals("") ) {
                    lista.get(1).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(1).setText("O");
                    break;

                }

                if(lista.get(8).getText().equals("X") && lista.get(3).getText().equals("") ) {
                    lista.get(3).setTextColor(getResources().getColor(R.color.colorAccent));
                    lista.get(3).setText("O");
                    break;

                }

            }
        }
    }

    public void verificaGanhador(int n){


        String vencedor = "";
        if(n == 9){
            vencedor = "A Velha Ganhou";

            Intent i = new Intent(this, FinalAndro.class);
            i.putExtra("textView2", vencedor);
            startActivity(i);
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
                vencedor = "Você Ganhou!";


                Intent j = new Intent(this, FinalAndro.class);


                j.putExtra("textView2", vencedor);
                startActivity(j);

            }else if(combinaçoes.get(i).equals("OOO")){
                vencedor = "Ganhei";

                Intent x = new Intent(this, FinalAndro.class);
                x.putExtra("textView2", vencedor);

                startActivity(x);

            }
        }

    }

}

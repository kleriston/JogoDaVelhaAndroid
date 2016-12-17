package com.example.marcia.jogodavelha2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Marcia on 05/09/2016.
 */
public class FinalAndro extends AppCompatActivity {

    private Button voltar;
    private Button sair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_andro);
        Intent i = getIntent();

        String g = (String) i.getExtras().getCharSequence("textView2");

        TextView ganhador = (TextView) findViewById(R.id.textView2);


        if(g.equals("Você Ganhou!")){
            ganhador.setTextColor(getResources().getColor(R.color.colorPrimary));
            ganhador.setText(g);
        }if (g.equals("Ganhei")){
            ganhador.setTextColor(getResources().getColor(R.color.colorAccent));
            ganhador.setText(g);
        } if (g.equals("A  Velha Ganhou")){
            ganhador.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            ganhador.setText(g);
        }


        voltar = (Button) findViewById(R.id.button2);
        sair = (Button) findViewById(R.id.button_sair);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(FinalAndro.this, Andro.class);
                startActivity(i);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalAndro.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}

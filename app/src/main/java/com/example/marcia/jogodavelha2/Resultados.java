package com.example.marcia.jogodavelha2;

import com.orm.SugarRecord;

/**
 * Created by Marcia on 04/10/2016.
 */
public class Resultados extends SugarRecord {

    public  int jogador1;
    public int jogador2;
    public int velha;


    public Resultados() {
    }

    public Resultados(int jogador1, int jogador2, int velha) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.velha = velha;
    }

    public int getJogador1() {
        return jogador1;
    }

    public void setJogador1(int jogador1) {
        this.jogador1 = jogador1;
    }

    public int getJogador2() {
        return jogador2;
    }

    public void setJogador2(int jogador2) {
        this.jogador2 = jogador2;
    }

    public int getVelha() {
        return velha;
    }

    public void setVelha(int velha) {
        this.velha = velha;
    }
}

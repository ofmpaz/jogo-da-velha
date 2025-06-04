package com.tecnosfera.jogadores;

import com.tecnosfera.enums.SimboloEnum;
import com.tecnosfera.tabuleiro.Tabuleiro;

public abstract class Jogador {

    protected String nome;
    protected SimboloEnum simbolo;

    public Jogador(String nome, SimboloEnum simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public SimboloEnum getSimbolo() {
        return simbolo;
    }

    public abstract void fazerJogada(Tabuleiro tabuleiro);

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSimbolo(SimboloEnum simbolo) {
        this.simbolo = simbolo;
    }
}

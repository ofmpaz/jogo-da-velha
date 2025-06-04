package com.tecnosfera.jogadores;

import com.tecnosfera.enums.SimboloEnum;
import com.tecnosfera.tabuleiro.Tabuleiro;

import java.util.Random;

public class JogadorIA extends Jogador {

    private static final Random random = new Random();

    public JogadorIA(String nome, SimboloEnum simbolo) {
        super(nome, simbolo);
    }

    /**
     * Método que permite ao jogador IA fazer uma jogada no tabuleiro.
     * A IA escolhe aleatoriamente uma posição vazia no tabuleiro para marcar seu símbolo.
     *
     * @param tabuleiro O tabuleiro onde a jogada será feita.
     */

    @Override
    public void fazerJogada(Tabuleiro tabuleiro) {
        while (true) {
            int linha = random.nextInt(3);
            int coluna = random.nextInt(3);

            if (tabuleiro.posicaoVazia(linha, coluna)) {
                System.out.println(nome + " jogou na posição: " + linha + ", " + coluna);
                tabuleiro.marcarPosicao(linha, coluna, getSimbolo());
                break;
            }
        }
    }
}

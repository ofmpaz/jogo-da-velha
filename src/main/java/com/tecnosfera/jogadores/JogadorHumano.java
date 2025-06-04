package com.tecnosfera.jogadores;

import com.tecnosfera.enums.SimboloEnum;
import com.tecnosfera.tabuleiro.Tabuleiro;

import java.util.Scanner;

public class JogadorHumano extends Jogador {

    Scanner scanner = new Scanner(System.in);

    public JogadorHumano(String nome, SimboloEnum simbolo) {
        super(nome, simbolo);
    }

    /**
     * Método que permite ao jogador humano fazer uma jogada no tabuleiro.
     * O jogador deve informar a linha e a coluna onde deseja marcar seu símbolo.
     * O método verifica se a posição é válida e se está vazia antes de marcar.
     *
     * @param tabuleiro O tabuleiro onde a jogada será feita.
     */
    @Override
    public void fazerJogada(Tabuleiro tabuleiro) {
        while (true) {
            System.out.println(nome + ", é a sua vez de jogar! Informe a linha e a coluna (0-2) separadas por espaço:");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro.posicaoVazia(linha, coluna)) {
                tabuleiro.marcarPosicao(linha, coluna, getSimbolo());
                break;
            } else {
                System.out.println("Posição inválida ou já ocupada. Tente novamente.");
            }
        }
    }
}
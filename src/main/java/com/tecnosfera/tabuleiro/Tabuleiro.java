package com.tecnosfera.tabuleiro;

import com.tecnosfera.enums.SimboloEnum;

public class Tabuleiro {

    private SimboloEnum[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new SimboloEnum[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = SimboloEnum.EMPTY;
            }
        }
    }

    public void exibirTabuleiro() {
        System.out.println("\nTabuleiro:");

        // Cabeçalho das colunas
        System.out.print("   ");
        for (int j = 0; j < 3; j++) {
            System.out.print(" C" + j + " ");
        }
        System.out.println();

        // Corpo do tabuleiro com rótulos de linha e separadores
        for (int i = 0; i < 3; i++) {
            System.out.print("L" + i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + tabuleiro[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println();
    }


    public boolean posicaoVazia(int linha, int coluna) {
        return tabuleiro[linha][coluna] == SimboloEnum.EMPTY;
    }

    public void marcarPosicao(int linha, int coluna, SimboloEnum simbolo) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
            tabuleiro[linha][coluna] = simbolo;
        } else {
            throw new IllegalArgumentException("Posição inválida no tabuleiro.");
        }
    }

    public void limparTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = SimboloEnum.EMPTY;
            }
        }
    }

    public boolean empate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == SimboloEnum.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public SimboloEnum jogadorVencedor() {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != SimboloEnum.EMPTY &&
                    tabuleiro[i][0] == tabuleiro[i][1] &&
                    tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0];
            }
        }

        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] != SimboloEnum.EMPTY &&
                    tabuleiro[0][j] == tabuleiro[1][j] &&
                    tabuleiro[1][j] == tabuleiro[2][j]) {
                return tabuleiro[0][j];
            }
        }

        // Verifica diagonais
        if (tabuleiro[0][0] != SimboloEnum.EMPTY &&
                tabuleiro[0][0] == tabuleiro[1][1] &&
                tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0];
        }

        if (tabuleiro[0][2] != SimboloEnum.EMPTY &&
                tabuleiro[0][2] == tabuleiro[1][1] &&
                tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2];
        }

        // Nenhum vencedor
        return null;
    }


}

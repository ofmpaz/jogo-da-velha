package com.tecnosfera.interfacegrafica;

import com.tecnosfera.enums.SimboloEnum;
import com.tecnosfera.jogadores.Jogador;
import com.tecnosfera.tabuleiro.Tabuleiro;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TelaJogo {

    private GridPane layout;
    private Button[][] botoes;
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public TelaJogo(Tabuleiro tabuleiro, Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = tabuleiro;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorAtual = jogador1;

        layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);

        botoes = new Button[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button botao = new Button("");
                botao.setFont(Font.font(30));
                botao.setPrefSize(80, 80);
                final int linha = i;
                final int coluna = j;

                botao.setOnAction(e -> {
                    if (tabuleiro.posicaoVazia(linha, coluna)) {
                        botao.setText(jogadorAtual.getSimbolo().toString());
                        tabuleiro.marcarPosicao(linha, coluna, jogadorAtual.getSimbolo());
                        botao.setDisable(true);

                        SimboloEnum vencedor = tabuleiro.jogadorVencedor();
                        if (vencedor != null) {
                            mostrarMensagem("Parabéns " + jogadorAtual.getNome() + "! Você venceu!");
                            desativarBotoes();
                        } else if (tabuleiro.empate()) {
                            mostrarMensagem("Empate!");
                            desativarBotoes();
                        } else {
                            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
                        }
                    }
                });

                botoes[i][j] = botao;
                layout.add(botao, j, i);
            }
        }
    }

    public GridPane getLayout() {
        return layout;
    }

    private void mostrarMensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Fim de jogo");
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }

    private void desativarBotoes() {
        for (Button[] linha : botoes) {
            for (Button botao : linha) {
                botao.setDisable(true);
            }
        }
    }
}
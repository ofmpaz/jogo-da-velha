package com.tecnosfera.jogo;

import com.tecnosfera.enums.SimboloEnum;
import com.tecnosfera.jogadores.Jogador;
import com.tecnosfera.jogadores.JogadorHumano;
import com.tecnosfera.jogadores.JogadorIA;
import com.tecnosfera.tabuleiro.Tabuleiro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jogo {

    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private static final Scanner sc = new Scanner(System.in);

    public void configurarJogo() {
        String tipo = obterTipoJogador();
        if (tipo.equalsIgnoreCase("HUMANO")) {
            configurarJogadoresHumanos();
        } else {
            configurarJogadorIA();
        }
    }

    public void iniciar() {
        inicializarTabuleiro();
        configurarJogo();

        Jogador jogadorAtual = jogador1;

        while (tabuleiro.jogadorVencedor() == null && !tabuleiro.empate()) {
            tabuleiro.exibirTabuleiro();
            System.out.println("Vez de " + jogadorAtual.getNome() + " com símbolo " + jogadorAtual.getSimbolo());

            jogadorAtual.fazerJogada(tabuleiro);

            if (tabuleiro.jogadorVencedor() != null) {
                tabuleiro.exibirTabuleiro();
                System.out.println("Parabéns " + jogadorAtual.getNome() + "! Você venceu!");
                return;
            }

            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }

        tabuleiro.exibirTabuleiro();
        System.out.println("O jogo empatou!");
    }

    private String obterTipoJogador() {
        while (true) {
            System.out.println("Escolha o tipo de adversário: HUMANO ou IA");
            String tipo = sc.nextLine().trim();
            if (tipo.equalsIgnoreCase("HUMANO") || tipo.equalsIgnoreCase("IA")) {
                return tipo;
            }
            System.out.println("Tipo inválido. Por favor, escolha entre HUMANO ou IA.");
        }
    }

    private void configurarJogadoresHumanos() {
        System.out.println("Digite o nome do Jogador 1:");
        String nomeJogador1 = sc.nextLine();
        System.out.println("Digite o nome do Jogador 2:");
        String nomeJogador2 = sc.nextLine();

        SimboloEnum simbolo1 = escolherSimbolo(nomeJogador1);
        SimboloEnum simbolo2 = (simbolo1 == SimboloEnum.X) ? SimboloEnum.O : SimboloEnum.X;

        jogador1 = new JogadorHumano(nomeJogador1, simbolo1);
        jogador2 = new JogadorHumano(nomeJogador2, simbolo2);
    }

    private void configurarJogadorIA() {
        System.out.println("Digite seu nome:");
        String nomeJogador = sc.nextLine();

        SimboloEnum simbolo = escolherSimbolo(nomeJogador);
        SimboloEnum simboloIA = (simbolo == SimboloEnum.X) ? SimboloEnum.O : SimboloEnum.X;

        jogador1 = new JogadorHumano(nomeJogador, simbolo);
        jogador2 = new JogadorIA("Computador", simboloIA);
    }

    private SimboloEnum escolherSimbolo(String nomeJogador) {
        while (true) {
            System.out.println("Escolha o símbolo para " + nomeJogador + " (X ou O):");
            try {
                return SimboloEnum.valueOf(sc.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Símbolo inválido. Tente novamente.");
            }
        }
    }

    private void inicializarTabuleiro() {
        tabuleiro = new Tabuleiro();
    }
}

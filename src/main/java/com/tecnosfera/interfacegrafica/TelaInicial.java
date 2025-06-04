package com.tecnosfera.interfacegrafica;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaInicial {

    private VBox layout;
    private TextField campoNome;
    private ComboBox<String> escolhaAdversario;
    private ComboBox<String> escolhaSimbolo;
    private Button botaoIniciar;

    public TelaInicial(Stage stage) {
        layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label titulo = new Label("Jogo da Velha - Tecnosfera");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        campoNome = new TextField();
        campoNome.setPromptText("Digite seu nome");

        escolhaAdversario = new ComboBox<>();
        escolhaAdversario.getItems().addAll("Humano", "IA");
        escolhaAdversario.setPromptText("Escolha o adversário");

        escolhaSimbolo = new ComboBox<>();
        escolhaSimbolo.getItems().addAll("X", "O");
        escolhaSimbolo.setPromptText("Escolha seu símbolo");

        botaoIniciar = new Button("Começar Jogo");
        botaoIniciar.setOnAction(e -> {
            String nome = campoNome.getText();
            String adversario = escolhaAdversario.getValue();
            String simbolo = escolhaSimbolo.getValue();

            // Exibição temporária no console (você pode chamar a próxima tela aqui)
            System.out.println("Nome: " + nome + ", Adversário: " + adversario + ", Símbolo: " + simbolo);
        });

        layout.getChildren().addAll(titulo, campoNome, escolhaAdversario, escolhaSimbolo, botaoIniciar);

        // EXIBE a interface no Stage fornecido
        Scene cena = new Scene(layout, 300, 250);
        stage.setScene(cena);
        stage.setTitle("Jogo da Velha - Tecnosfera");
        stage.show();
    }

    public VBox getLayout() {
        return layout;
    }
}

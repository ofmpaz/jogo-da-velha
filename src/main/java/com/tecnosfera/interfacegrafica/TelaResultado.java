package com.tecnosfera.interfacegrafica;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaResultado {

    public TelaResultado(Stage stage, String mensagem) {
        Label label = new Label(mensagem);
        label.setStyle("-fx-font-size: 20px; -fx-text-fill: #333;");

        Button btnMenu = new Button("Voltar ao Menu");
        Button btnSair = new Button("Sair");

        btnMenu.setOnAction(e -> new TelaInicial(stage)); // Volta ao início
        btnSair.setOnAction(e -> stage.close());

        VBox layout = new VBox(20, label, btnMenu, btnSair);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}

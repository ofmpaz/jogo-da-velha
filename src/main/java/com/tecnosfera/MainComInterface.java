package com.tecnosfera;

import com.tecnosfera.interfacegrafica.TelaInicial;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainComInterface extends Application {
    @Override
    public void start(Stage primaryStage) {
        new TelaInicial(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

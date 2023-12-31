package com.example.zoosys.controllers;

import com.example.zoosys.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {

    @FXML
    private AnchorPane homePane;

    @FXML
    public void abrirAnimais(ActionEvent actionEvent) {
        System.out.println("Abrindo animais");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("animais.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) homePane.getScene().getWindow();
            stage.setTitle("Animais");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }

    @FXML
    public void abrirFunc(ActionEvent actionEvent) {
        System.out.println("Abrindo funcionarios");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("funcionarios.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) homePane.getScene().getWindow();
            stage.setTitle("Funcionários");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }

    @FXML
    public void abrirEsp(ActionEvent actionEvent) {
        System.out.println("Abrindo especies");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("especies.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) homePane.getScene().getWindow();
            stage.setTitle("Espécies");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }


}

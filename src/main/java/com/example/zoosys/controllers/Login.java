package com.example.zoosys.controllers;

import com.example.zoosys.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    private TextField usuario;

    @FXML
    private TextField senha;

    public void entrar(ActionEvent actionEvent) {
        System.out.println("Usuario: " + usuario.getText());
        System.out.println("Senha: " + senha.getText());

        if (usuario.getText().equals("admin") && senha.getText().equals("admin")) {
            System.out.println("Logado com sucesso");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Home");
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                System.out.println(e+"Erro ao abrir o FXML");
            }
        } else {
            System.out.println("Usuario ou senha incorretos");
        }
    }
}

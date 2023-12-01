package com.example.zoosys.controllers;

import com.example.zoosys.App;
import com.example.zoosys.models.Db;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Animais {

    @FXML
    private ListView<String> animaisListView;

    @FXML
    private AnchorPane animalPane;

    @FXML
    private void initialize() {
        System.out.println("Animais");
        try {
            listarAnimais();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void atualizar() {
        System.out.println("Atualizar");
        animaisListView.getItems().clear();
        try {
            listarAnimais();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void listarAnimais() throws SQLException {
        System.out.println("Listar Animais");
        String sql = "SELECT * FROM animais";
        PreparedStatement requisicao = Db.conectar().prepareStatement(sql);
        ResultSet resultado = requisicao.executeQuery();
        while (resultado.next()) {
            String nome = resultado.getString("nome");
            String especie = resultado.getString("especie");
            String sexo = resultado.getString("sexo");
            String dataNascimento = resultado.getString("dataNascimento");
            String dataEntrada = resultado.getString("dataEntrada");
            String alimentacao = resultado.getString("alimentacao");
            String id = resultado.getString("id");
            String coisa = String.format("ID: %s\t\tNome: %s\t\tEspecie: %s\t\tSexo: %s\t\tData de Nascimento: %s\t\tData de Entrada: %s\t\tAlimentação: %s", nome, especie, sexo, dataNascimento, dataEntrada, alimentacao, id);
            animaisListView.getItems().add(coisa);
        }
    }

    @FXML
    private void voltarHome(){
        System.out.println("Voltando para home");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) animalPane.getScene().getWindow();
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }

    @FXML
    private void newAnimal() {
        System.out.println("New Animal");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("newAnimal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Novo animal");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }
}

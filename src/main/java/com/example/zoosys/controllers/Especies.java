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

public class Especies {
    @FXML
    private ListView<String> especiesListView;
    @FXML
    private AnchorPane especiePane;

    @FXML
    private void initialize() {
        System.out.println("Especies");
        try {
            listarEspecies();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void atualizar() {
        System.out.println("Atualizar");
        especiesListView.getItems().clear();
        try {
            listarEspecies();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void listarEspecies() throws SQLException {
        System.out.println("Listar Especies");
        String sql = "SELECT * FROM especies";
        PreparedStatement requisicao = Db.conectar().prepareStatement(sql);
        ResultSet resultado = requisicao.executeQuery();
        while (resultado.next()) {
            String nome = resultado.getString("nome");
            String descricao = resultado.getString("descricao");
            String id = resultado.getString("id");
            String coisa = String.format("ID: %s\t\tNome: %s\t\tDescrição: %s", id, nome, descricao);
            especiesListView.getItems().add(coisa);
        }
    }

    @FXML
    private void voltarHome(){
        System.out.println("Voltando para home");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) especiePane.getScene().getWindow();
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }

    @FXML
    private void newEspecie() {
        System.out.println("New Especie");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("newEspecie.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Nova especie");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }
}

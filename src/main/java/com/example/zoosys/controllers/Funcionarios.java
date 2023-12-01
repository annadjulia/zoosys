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

public class Funcionarios {
    @FXML
    private ListView<String> funcionariosListView;
    @FXML
    private AnchorPane funcionarioPane;

    @FXML
    private void initialize() {
        System.out.println("Funcionarios");
        try {
            listarFuncionarios();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void atualizar() {
        System.out.println("Atualizar");
        funcionariosListView.getItems().clear();
        try {
            listarFuncionarios();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void listarFuncionarios() throws SQLException {
        System.out.println("Listar Funcionarios");
        String sql = "SELECT * FROM funcionarios";
        PreparedStatement requisicao = Db.conectar().prepareStatement(sql);
        ResultSet resultado = requisicao.executeQuery();
        while (resultado.next()) {
            String nome = resultado.getString("nome");
            String cpf = resultado.getString("cpf");
            String dataNascimento = resultado.getString("dataNascimento");
            String telefone = resultado.getString("telefone");
            String email = resultado.getString("email");
            String cargo = resultado.getString("cargo");
            String id = resultado.getString("id");
            String coisa = String.format("ID: %s\t\tNome: %s\t\tCPF: %s\t\tData de Nascimento: %s\t\tTelefone: %s\t\tEmail: %s\t\tCargo: %s", id, nome, cpf, dataNascimento, telefone, email, cargo);
            funcionariosListView.getItems().add(coisa);
        }
    }

    @FXML
    private void deletarFunc() throws SQLException {
        int selectedIndex = funcionariosListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            System.out.println(funcionariosListView.getItems().get(selectedIndex));
            String idFunc = funcionariosListView.getItems().get(selectedIndex).split("\t")[0].substring(4);
            String sql = "DELETE FROM funcionarios WHERE id = ?";
            PreparedStatement requisicao = Db.conectar().prepareStatement(sql);
            requisicao.setString(1, idFunc);
            requisicao.execute();
            funcionariosListView.getItems().remove(selectedIndex);
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Nenhum funcionário selecionado para deletar.");
        }
    }

    @FXML
    private void voltarHome(){
        System.out.println("Voltando para home");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) funcionarioPane.getScene().getWindow();
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }

    @FXML
    private void newFunc() {
        System.out.println("New Funcionario");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("newFunc.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Novo funcionario");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.println(e+"Erro ao abrir o FXML");
        }
    }
}

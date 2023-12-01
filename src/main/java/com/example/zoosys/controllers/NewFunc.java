package com.example.zoosys.controllers;

import com.example.zoosys.App;
import com.example.zoosys.models.Db;
import com.example.zoosys.models.Especie;
import com.example.zoosys.models.Funcionario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NewFunc {
    @FXML
    private TextField nome, cpf, dataNascimento, telefone, email, cargo;

    @FXML
    private AnchorPane funcionarioPane;

    @FXML
    private void salvarFunc() {
        System.out.println("Salvar Funcionário");
        System.out.println(nome.getText());
        System.out.println(cpf.getText());
        System.out.println(dataNascimento.getText());
        System.out.println(telefone.getText());
        System.out.println(email.getText());
        System.out.println(cargo.getText());

        if(nome.getText().isEmpty() || cpf.getText().isEmpty() || dataNascimento.getText().isEmpty() || telefone.getText().isEmpty() || email.getText().isEmpty() || cargo.getText().isEmpty()) {
            System.out.println("Preencha todos os campos");
            return;
        }

        try {
            Funcionario funcionario = new Funcionario(Db.conectar());
            funcionario.salvarFuncionario(nome.getText(), cpf.getText(), dataNascimento.getText(), telefone.getText(), email.getText(), cargo.getText());
        } catch (Exception e) {
            System.out.println(e);
        }

        Stage stage = (Stage) funcionarioPane.getScene().getWindow();
        stage.close();
    }
}

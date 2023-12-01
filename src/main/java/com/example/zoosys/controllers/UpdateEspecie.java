package com.example.zoosys.controllers;

import com.example.zoosys.models.Db;
import com.example.zoosys.models.Especie;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UpdateEspecie {
    @FXML
    private TextField nome, descricao;
    @FXML
    private AnchorPane especiePane;

    @FXML
    private void salvarEspecie() {
        System.out.println("Salvar Especie");
        System.out.println(nome.getText());
        System.out.println(descricao.getText());

        if(nome.getText().isEmpty() || descricao.getText().isEmpty()) {
            System.out.println("Preencha todos os campos");
            return;
        }

        try {
            Especie especie = new Especie(Db.conectar());
            especie.editarEspecie(nome.getText(), descricao.getText());
        } catch (Exception e) {
            System.out.println(e);
        }

        Stage stage = (Stage) especiePane.getScene().getWindow();
        stage.close();
    }
}

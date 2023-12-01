package com.example.zoosys.controllers;

import com.example.zoosys.models.Db;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.example.zoosys.models.Animal;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewAnimal {
    @FXML
    private TextField nome, especie, sexo, dataNascimento, dataEntrada, alimentacao;
    @FXML
    private AnchorPane animalPane;

    @FXML
    private void salvarAnimal() {
        System.out.println("Salvar Animal");
        System.out.println(nome.getText());
        System.out.println(especie.getText());
        System.out.println(sexo.getText());
        System.out.println(dataNascimento.getText());
        System.out.println(dataEntrada.getText());
        System.out.println(alimentacao.getText());

        if(nome.getText().isEmpty() || especie.getText().isEmpty() || sexo.getText().isEmpty() || dataNascimento.getText().isEmpty() || dataEntrada.getText().isEmpty() || alimentacao.getText().isEmpty()) {
            System.out.println("Preencha todos os campos");
            return;
        }

        try {
            Animal animal = new Animal(Db.conectar());
            animal.salvarAnimal(nome.getText(), especie.getText(), sexo.getText(), dataNascimento.getText(), dataEntrada.getText(), alimentacao.getText());
        } catch (Exception e) {
            System.out.println(e);
        }

        Stage stage = (Stage) animalPane.getScene().getWindow();
        stage.close();
    }
}

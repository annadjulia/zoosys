package com.example.zoosys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.zoosys.models.Db;
import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bem vindo ao ZOOTRACK!");
        stage.setScene(scene);
        stage.show();
        Db.conectar();
    }

    public static void main(String[] args) {
        launch();
    }
}
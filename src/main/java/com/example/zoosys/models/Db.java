package com.example.zoosys.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {
    private Connection con;

    public void conectar() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/zoosys";
            Connection con = DriverManager.getConnection(url, "Ana", "123");
            System.out.println("Conectado com sucesso");
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
        }
    }
}

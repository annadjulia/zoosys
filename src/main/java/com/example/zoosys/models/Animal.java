package com.example.zoosys.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String sexo;
    private String dataNascimento;
    private String dataEntrada;
    private String alimentacao;
    private Connection con;

    public Animal(String nome, String especie, String sexo, String dataNascimento, String dataEntrada, String alimentacao) {
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataEntrada = dataEntrada;
        this.alimentacao = alimentacao;
    }

    public Animal() {

    }

    public Animal(Connection con) {
        this.con = con;
    }

    public boolean salvarAnimal(String nome, String especie, String sexo, String dataNascimento, String dataEntrada, String alimentacao) throws SQLException {
        System.out.println("Salvar Animal");
        String sql = "INSERT INTO animais (nome, especie, sexo, dataNascimento, dataEntrada, alimentacao) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement requisicao = con.prepareStatement(sql);
        requisicao.setString(1, nome);
        requisicao.setString(2, especie);
        requisicao.setString(3, sexo);
        requisicao.setString(4, dataNascimento);
        requisicao.setString(5, dataEntrada);
        requisicao.setString(6, alimentacao);
        requisicao.executeUpdate();
        return true;
    }

    public boolean editarAnimal(String nome, String especie, String sexo, String dataNascimento, String dataEntrada, String alimentacao) throws SQLException {
        System.out.println("Editar Animal");
        String sql = "UPDATE animais SET nome = ?, especie = ?, sexo = ?, dataNascimento = ?, dataEntrada = ?, alimentacao = ? WHERE id = ?";
        PreparedStatement requisicao = con.prepareStatement(sql);
        requisicao.setString(1, nome);
        requisicao.setString(2, especie);
        requisicao.setString(3, sexo);
        requisicao.setString(4, dataNascimento);
        requisicao.setString(5, dataEntrada);
        requisicao.setString(6, alimentacao);
        requisicao.setInt(7, id);
        requisicao.executeUpdate();
        return true;
    }

    public boolean excluirAnimal() throws SQLException {
        System.out.println("Excluir Animal");
        String sql = "DELETE FROM animais WHERE id = ?";
        PreparedStatement requisicao = con.prepareStatement(sql);
        requisicao.setInt(1, id);
        requisicao.executeUpdate();
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }
}

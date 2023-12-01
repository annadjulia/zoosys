package com.example.zoosys.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Especie {
    private int id;
    private String nome;
    private String descricao;
    private Connection con;

    public Especie(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Especie() {

    }

    public Especie(Connection con) {
        this.con = con;
    }

    public ResultSet listarEspecies() throws SQLException {
        System.out.println("Listar Especies");
        String sql = "SELECT * FROM especies";
        PreparedStatement requisicao = con.prepareStatement(sql);
        ResultSet resultado = requisicao.executeQuery();
        return resultado;
    }

    public boolean salvarEspecie(String nome, String descricao) throws SQLException {
        System.out.println("Salvar Especie");
        String sql = "INSERT INTO especies (nome, descricao) VALUES (?, ?)";
        PreparedStatement requisicao = con.prepareStatement(sql);
        requisicao.setString(1, nome);
        requisicao.setString(2, descricao);
        requisicao.executeUpdate();
        return true;
    }

    public boolean editarEspecie(String nome, String descricao) throws SQLException {
        System.out.println("Editar Especie");
        String sql = "UPDATE especies SET nome = ?, descricao = ? WHERE id = ?";
        PreparedStatement requisicao = con.prepareStatement(sql);
        requisicao.setString(1, nome);
        requisicao.setString(2, descricao);
        requisicao.setInt(3, id);
        requisicao.executeUpdate();
        return true;
    }

    public boolean excluirEspecie() throws SQLException {
        System.out.println("Excluir Especie");
        String sql = "DELETE FROM especies WHERE id = ?";
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package com.example.zoosys.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String cargo;
    private Connection con;

    public Funcionario(String nome, String cpf, String dataNascimento, String telefone, String email, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.cargo = cargo;
    }

    public Funcionario() {

    }

    public Funcionario(Connection con) {
        this.con = con;
    }

    public ResultSet listarFuncionarios() throws SQLException {
        System.out.println("Listar Funcionarios");
        String sql = "SELECT * FROM funcionarios";
        PreparedStatement requisicao = con.prepareStatement(sql);
        ResultSet resultado = requisicao.executeQuery();
        return resultado;
    }

    public boolean salvarFuncionario(String nome, String cpf, String dataNascimento, String telefone, String email, String cargo) throws SQLException, SQLException {
        System.out.println("Salvar Funcionario");
        String sql = "INSERT INTO funcionarios (nome, cpf, dataNascimento, telefone, email, cargo) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement requisicao = con.prepareStatement(sql);
        requisicao.setString(1, nome);
        requisicao.setString(2, cpf);
        requisicao.setString(3, dataNascimento);
        requisicao.setString(4, telefone);
        requisicao.setString(5, email);
        requisicao.setString(6, cargo);
        requisicao.executeUpdate();
        return true;
    }

    public boolean editarFuncionario(String nome, String cpf, String dataNascimento, String telefone, String email, String cargo) throws SQLException {
        System.out.println("Editar Funcionario");
        String sql = "UPDATE funcionarios SET nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, email = ?, cargo = ? WHERE id = ?";
        PreparedStatement requisicao = con.prepareStatement(sql);
        requisicao.setString(1, nome);
        requisicao.setString(2, cpf);
        requisicao.setString(3, dataNascimento);
        requisicao.setString(4, telefone);
        requisicao.setString(5, email);
        requisicao.setString(6, cargo);
        requisicao.setInt(7, id);
        requisicao.executeUpdate();
        return true;
    }

    public boolean excluirFuncionario() throws SQLException {
        System.out.println("Excluir Funcionario");
        String sql = "DELETE FROM funcionarios WHERE id = ?";
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

package com.example.zoosys.models;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String sexo;
    private String dataNascimento;
    private String dataEntrada;
    private String alimentacao;

    public Animal(int id, String nome, String especie, String sexo, String dataNascimento, String dataEntrada, String alimentacao) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataEntrada = dataEntrada;
        this.alimentacao = alimentacao;
    }

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

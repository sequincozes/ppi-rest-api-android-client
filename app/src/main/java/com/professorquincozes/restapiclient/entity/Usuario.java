package com.professorquincozes.restapiclient.entity;

import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("id")
    public int id;

    @SerializedName("nome")
    public String nome;

    @SerializedName("idade")
    public int idade;

    public Usuario(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
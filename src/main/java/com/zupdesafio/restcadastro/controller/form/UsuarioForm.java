package com.zupdesafio.restcadastro.controller.form;

import com.zupdesafio.restcadastro.modelo.Usuario;

public class UsuarioForm {


    private String nome;
    private String cpf;
    private String email;
    private String dataNasc;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Usuario converter() {
        return new Usuario(nome,cpf,email,dataNasc);
    }

}


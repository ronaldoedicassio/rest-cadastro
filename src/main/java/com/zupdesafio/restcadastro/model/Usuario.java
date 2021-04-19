package com.zupdesafio.restcadastro.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity // estamos dizendo que isso e uma entidade
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // identity - delegamos a responsabilidade do BD incrementar o ID
    private int id;
    @NotNull
    private String nome;
    @NotNull
    @Column(unique = true)
    private String cpf;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String dataNasc;

    @OneToMany(mappedBy = "usuario")

    private List<Endereco> endereco;

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
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


}

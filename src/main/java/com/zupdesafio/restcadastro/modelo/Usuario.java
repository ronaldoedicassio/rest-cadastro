package com.zupdesafio.restcadastro.modelo;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // estamos dizendo que isso e uma entidade
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // identity - delegamos a responsabilidade do BD incrementar o ID
    private Long id;
    private String nome;
    @Column(unique = true)
    @NotNull
    private String cpf;
    @Column(unique = true)
    @NotNull
    private String email;
    private String dataNasc;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> endereco = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nome, usuario.nome) && Objects.equals(cpf, usuario.cpf) && Objects.equals(email, usuario.email) && Objects.equals(dataNasc, usuario.dataNasc) && Objects.equals(endereco, usuario.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email, dataNasc, endereco);
    }

    public Usuario(String nome, String cpf, String email, String dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

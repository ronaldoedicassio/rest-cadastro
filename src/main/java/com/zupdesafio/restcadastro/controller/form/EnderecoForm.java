package com.zupdesafio.restcadastro.controller.form;

import com.zupdesafio.restcadastro.modelo.Endereco;
import com.zupdesafio.restcadastro.modelo.Usuario;
import com.zupdesafio.restcadastro.repository.UsuarioRepositoty;

public class EnderecoForm {

    private long id;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Endereco converter(UsuarioRepositoty usuarioRepositoty) {
        Usuario usuario = usuarioRepositoty.findById(getUsuario().getId());
        return logradouro,numero,complemento,bairro,cidade,estado,cep,usuario;
    }
}

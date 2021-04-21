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
    private int usuario_id;

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

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Endereco converter(UsuarioRepositoty usuarioRepositoty) {
        Usuario usuario = usuarioRepositoty.findById(usuario_id);
        return new Endereco(logradouro,numero,complemento,bairro,cidade,estado,cep,usuario);
    }
}

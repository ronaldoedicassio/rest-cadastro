package com.zupdesafio.restcadastro.controller.form;

import com.zupdesafio.restcadastro.modelo.Endereco;
import com.zupdesafio.restcadastro.modelo.Usuario;
import com.zupdesafio.restcadastro.repository.UsuarioRepositoty;

import java.util.Optional;

public class EnderecoForm {

    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private Long usuarioId;

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Endereco converter(UsuarioRepositoty usuarioRepositoty) {
        Optional<Usuario> usuarioOptional = usuarioRepositoty.findById(usuarioId);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new RuntimeException("ID invalido"));
        return new Endereco(logradouro,numero,complemento,bairro,cidade,estado,cep,usuario);
    }
}

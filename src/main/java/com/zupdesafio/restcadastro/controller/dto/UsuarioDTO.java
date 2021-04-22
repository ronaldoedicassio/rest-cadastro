package com.zupdesafio.restcadastro.controller.dto;

import com.zupdesafio.restcadastro.modelo.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String dataNasc;
    private List<EnderecoDTO> enderecoDTO;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.email = usuario.getEmail();
        this.dataNasc = usuario.getDataNasc();
        this.enderecoDTO = usuario.getEndereco().stream().map(EnderecoDTO::new).collect(Collectors.toList());

    }

    public List<EnderecoDTO> getEnderecoDTO() {
        return enderecoDTO;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNasc() {
        return dataNasc;
    }
}

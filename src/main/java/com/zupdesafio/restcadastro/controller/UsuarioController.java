package com.zupdesafio.restcadastro.controller;


import com.zupdesafio.restcadastro.controller.dto.UsuarioDTO;
import com.zupdesafio.restcadastro.controller.form.UsuarioForm;
import com.zupdesafio.restcadastro.modelo.Usuario;
import com.zupdesafio.restcadastro.repository.UsuarioRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

    @Autowired // vai adicionar uma instância automaticamente
    private UsuarioRepositoty usuarioRepositoty;

    @GetMapping
    public List<UsuarioDTO> listar() {

        List<Usuario> usuarios = usuarioRepositoty.findAll();
        return UsuarioDTO.converter(usuarios);

    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = form.converter();
        usuarioRepositoty.save(usuario);

        URI uri = uriComponentsBuilder.path("/cadastro/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }
}

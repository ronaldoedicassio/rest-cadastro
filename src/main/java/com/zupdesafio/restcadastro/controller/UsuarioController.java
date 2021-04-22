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
import java.util.Optional;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

    @Autowired // vai adicionar uma instância automaticamente
    private UsuarioRepositoty usuarioRepositoty;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = form.converter();

        Usuario usuarioCpf = usuarioRepositoty.findBycpf(usuario.getCpf());
        Usuario usuarioEmail = usuarioRepositoty.findByEmail(usuario.getEmail());

        if (usuarioCpf != null || usuarioEmail != null) {
            return ResponseEntity.badRequest().build();
        }

        usuarioRepositoty.save(usuario);
        URI uri = uriComponentsBuilder.path("/cadastro/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public List<UsuarioDTO> listar(@PathVariable Long id) {

        Optional<Usuario> usuarios = usuarioRepositoty.findById(id);
        return UsuarioDTO.converter(usuarios);
       // return new UsuarioDTO(usuarios);
    }

}

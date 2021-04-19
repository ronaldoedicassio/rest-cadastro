package com.zupdesafio.restcadastro.controller;


import com.zupdesafio.restcadastro.model.Usuario;
import com.zupdesafio.restcadastro.repository.UsuarioRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired // vai adicionar uma instância automaticamente
    private UsuarioRepositoty usuarioRepositoty;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepositoty.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody Usuario usuario) { // o corpo da requisição vai ser convertido do tipo java para tipo usuario
        return usuarioRepositoty.save(usuario);
    }

    @DeleteMapping("/usuario")
    public void removerUsuario(@RequestBody Usuario usuario){
        usuarioRepositoty.delete(usuario);
    }
}
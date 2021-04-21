package com.zupdesafio.restcadastro.controller;

import com.zupdesafio.restcadastro.controller.dto.EnderecoDTO;
import com.zupdesafio.restcadastro.controller.dto.UsuarioDTO;
import com.zupdesafio.restcadastro.controller.form.EnderecoForm;
import com.zupdesafio.restcadastro.controller.form.UsuarioForm;
import com.zupdesafio.restcadastro.modelo.Endereco;
import com.zupdesafio.restcadastro.modelo.Usuario;
import com.zupdesafio.restcadastro.repository.EnderecoRepository;
import com.zupdesafio.restcadastro.repository.UsuarioRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cadastro/endereco")
public class EnderecoContoller {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepositoty usuarioRepositoty;

    @PostMapping
    public ResponseEntity<EnderecoDTO> cadastrar(@RequestBody EnderecoForm form, UriComponentsBuilder uriComponentsBuilder) {
        Endereco endereco = form.converter(usuarioRepositoty);
        enderecoRepository.save(endereco);

        URI uri = uriComponentsBuilder.path("/cadastro/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(endereco));
    }
}

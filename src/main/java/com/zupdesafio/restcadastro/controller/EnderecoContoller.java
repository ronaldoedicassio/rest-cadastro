package com.zupdesafio.restcadastro.controller;

import com.zupdesafio.restcadastro.model.Endereco;
import com.zupdesafio.restcadastro.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro/endereco")
public class EnderecoContoller {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> listarEnd(){
        return enderecoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@RequestBody Endereco endereco){
        return enderecoRepository.save(endereco);
    }
//
//    @DeleteMapping("/{id}")
//    public void removerEndereco(@PathVariable int id){
//        enderecoRepository.deleteById(id);
//    }
//
//    @PutMapping
//    public Endereco atualizarEndereco(@RequestBody Endereco endereco){
//        return enderecoRepository.save(endereco);
//    }
}

package com.zupdesafio.restcadastro.repository;

import com.zupdesafio.restcadastro.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // componente do spring, tipo repositorio, responsavel por interagir com banco de dados
public interface UsuarioRepositoty extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEndereco(String nomeUsuario);
}


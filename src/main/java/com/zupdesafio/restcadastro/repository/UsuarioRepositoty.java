package com.zupdesafio.restcadastro.repository;

import com.zupdesafio.restcadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // componente do spring, tipo repositorio, responsavel por interagir com banco de dados
public interface UsuarioRepositoty extends JpaRepository<Usuario, Integer> {
    Usuario findById(long id);
}


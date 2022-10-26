package com.example.edsoncabrejos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edsoncabrejos.model.Usuario;

@Repository
public interface UsuarioReposiroty extends JpaRepository<Usuario, Integer>{

}

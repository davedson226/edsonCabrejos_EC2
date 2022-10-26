package com.example.edsoncabrejos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edsoncabrejos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	

}

package com.example.edsoncabrejos.service;

import java.util.List;

import com.example.edsoncabrejos.model.Producto;



public interface ProductoService {

	void guardar(Producto producto);
    void actualizar(Producto producto);
    void eliminar(Integer id);
    List<Producto> listar();
    Producto obtener(Integer id);
}

package com.example.edsoncabrejos.service;

import java.util.List;

import com.example.edsoncabrejos.model.Bodega;


public interface BodegaService {
	
	void guardar(Bodega bodega);
    void actualizar(Bodega bodega);
    void eliminar(Integer id);
    List<Bodega> listar();
    Bodega obtener(Integer id);

}

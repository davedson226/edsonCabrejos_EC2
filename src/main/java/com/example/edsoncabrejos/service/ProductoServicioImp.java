package com.example.edsoncabrejos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edsoncabrejos.model.Producto;
import com.example.edsoncabrejos.repository.ProductoRepository;
@Service
public class ProductoServicioImp implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	public void guardar(Producto producto) {
		repository.save(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(producto);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Producto obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}

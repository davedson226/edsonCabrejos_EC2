package com.example.edsoncabrejos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edsoncabrejos.model.Bodega;
import com.example.edsoncabrejos.repository.BodegaRepository;
@Service
public class BodegaServicioImp implements BodegaService {

	
	@Autowired
	private BodegaRepository repository;
	
	@Override
	public void guardar(Bodega bodega) {
		// TODO Auto-generated method stub
		repository.save(bodega);

	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(bodega);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Bodega> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Bodega obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}

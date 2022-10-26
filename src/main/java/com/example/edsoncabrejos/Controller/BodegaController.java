package com.example.edsoncabrejos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.edsoncabrejos.model.Bodega;
import com.example.edsoncabrejos.service.BodegaService;

@RestController
@RequestMapping("/api/v1/bodega")
public class BodegaController {

	
	@Autowired
    private BodegaService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Bodega>> obtenerProductos() {
        return new ResponseEntity<List<Bodega>>(service.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bodega> buscarProducto(@PathVariable Integer id) {
    	Bodega bodega = service.obtener(id);

        if (bodega != null) {
            return new ResponseEntity<Bodega>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<Bodega>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Bodega b) {
        if (b != null) {
            service.guardar(b);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Bodega p) {
    	Bodega bodega = service.obtener(p.getIdBodega());

        if (bodega != null) {
            service.actualizar(p);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	Bodega b = service.obtener(id);
        if (b != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}

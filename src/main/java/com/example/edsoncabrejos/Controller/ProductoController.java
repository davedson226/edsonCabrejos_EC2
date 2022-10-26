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

import com.example.edsoncabrejos.model.Producto;
import com.example.edsoncabrejos.service.ProductoService;


@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
	@Autowired
    private ProductoService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> obtener() {
        return new ResponseEntity<List<Producto>>(service.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Producto> buscar(@PathVariable Integer id) {
        Producto producto = service.obtener(id);

        if (producto != null) {
            return new ResponseEntity<Producto>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Producto p) {
        if (p != null) {
            service.guardar(p);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Producto p) {
        Producto producto = service.obtener(p.getIdProducto());

        if (producto != null) {
            service.actualizar(p);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Producto p = service.obtener(id);
        if (p != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}

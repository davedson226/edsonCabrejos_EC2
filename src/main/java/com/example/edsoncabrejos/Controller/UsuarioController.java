package com.example.edsoncabrejos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.edsoncabrejos.security.TokenUtil;
import com.example.edsoncabrejos.security.UserDetailService;
import com.example.edsoncabrejos.dto.UsuarioDTO;
@RestController
public class UsuarioController {
	  @Autowired
		 private UserDetailService detail;
	  
	  @Autowired
	     private TokenUtil tokenUtil;
	  
	  @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	    public ResponseEntity<?> crearToken(@RequestBody UsuarioDTO request) {
	    	
	    	UserDetails user = detail.loadUserByUsername(request.getUsuario());
	    	if(user.getPassword().equals(request.getContrasena()))
	    		return ResponseEntity.ok(tokenUtil.generateToken(user.getUsername()));
	    	else
	    		throw new UsernameNotFoundException("No valido");
	    }
	
}

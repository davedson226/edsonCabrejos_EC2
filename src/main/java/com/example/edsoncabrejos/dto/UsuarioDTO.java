package com.example.edsoncabrejos.dto;

public class UsuarioDTO {
 private String usuario;
 private String contrasena;
 
 
public UsuarioDTO(String usuario, String contrasena) {
	super();
	this.usuario = usuario;
	this.contrasena = contrasena;
}

public UsuarioDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getContrasena() {
	return contrasena;
}
public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}
 
 
}

package com.provafinal.testesoftware;

import java.util.ArrayList;
import java.util.List;

public class CrudUsuario { 
	private List <Usuario> usuarioLista = new ArrayList<>();	
	
	public boolean create(Usuario criacao) {
		for(int i = 0 ; i < usuarioLista.size() ; i++) {			
			if(usuarioLista.get(i).getUsername() == criacao.getUsername()) {
				throw new IllegalArgumentException("Username ja existente");
			}
		}
		usuarioLista.add(criacao);
		return true;
	}
	
	public boolean update(int id, Usuario usuario) {
		for(int i = 0 ; i < usuarioLista.size() ; i++) {
			if(usuarioLista.get(i).getId() == id) {
				usuarioLista.set(i, usuario);
				return true;
			}
		}
		
		return false;	
	}
	
	public boolean delete(int id) {
		for(int i = 0 ; i < usuarioLista.size() ; i++) {
			if(usuarioLista.get(i).getId() == id) {
				usuarioLista.remove(i);
				
				return true;
			}		
		}
		
		return false;
			
	}
	
	public String findById(int id) {
		
		for(int i = 0 ; i < usuarioLista.size() ; i++) {
			if(usuarioLista.get(i).getId() == id) {
				return usuarioLista.get(i).toString();
			}		
			
		}
		return "id nao encontrado";

	}

}

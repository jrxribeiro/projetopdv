package com.isidrocorp.projetopdv.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.isidrocorp.projetopdv.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByRacfAndSenha(String racf, String senha);
	public ArrayList<Usuario> findByNomeContaining(String nome);
	public ArrayList<Usuario> findByEmailContaining(String email);
	public Usuario findByRacfOrEmail(String racf, String email);
	

}

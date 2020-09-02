package com.isidrocorp.projetopdv.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.isidrocorp.projetopdv.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	
	// para buscar por racf e senha
	public Usuario findByRacfAndSenha(String racf, String senha);
	// para buscar apenas por email
	public Usuario findByEmail(String email);
	// para buscar com nome contendo um determinado termo
	public ArrayList<Usuario> findByNomeContaining(String nome);
	// para buscar com email contendo um determinado termo
	public ArrayList<Usuario> findByEmailContaining(String email);
	
	// para buscar por racf ou por email
	public Usuario findByRacfOrEmail(String racf, String email);
	
}

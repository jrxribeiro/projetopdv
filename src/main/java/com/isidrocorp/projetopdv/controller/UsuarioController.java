package com.isidrocorp.projetopdv.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isidrocorp.projetopdv.dao.UsuarioDAO;
import com.isidrocorp.projetopdv.model.Usuario;

@RestController
public class UsuarioController {
	
	// injeção de dependência = basicamente delego à máquina Virtual a instanciação do objeto (dar new)
	// neste caso, como não tem nenhuma classe que implementa a interface UsuarioDAO, o SpringBOOT cria
	// dinamicamente a lógica dos métodos necessários para a manipulação
	
	@Autowired   
	private UsuarioDAO dao;

	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperarTodos(){
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario dadosLogin) {
		System.out.println("recebido = "+dadosLogin.getRacf()+"/"+dadosLogin.getSenha());
		Usuario resultado = dao.findByRacfAndSenha(dadosLogin.getRacf(), dadosLogin.getSenha());
		return resultado;
	}
}

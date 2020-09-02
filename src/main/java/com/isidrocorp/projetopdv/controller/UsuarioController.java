package com.isidrocorp.projetopdv.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// exemplo de montagem da URL parametrizando o ID do usuário a ser recuperado
	// a anotação @PathVariable indica que o "termo" {id} é uma variável que será mapeada para o parametro id do método
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> recuperarPeloId(@PathVariable int id) {
		Usuario resultado = dao.findById(id).orElse(null);
		if (resultado != null) {
			resultado.setSenha("********");
			return ResponseEntity.ok(resultado);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario dadosLogin) {
		Usuario resultado = dao.findByEmail(dadosLogin.getEmail());
		// encontrei o usuario?
		if (resultado != null) {
			// a senha passada na requisição bate com a senha armazenada no banco?
			if (resultado.getSenha().equals(dadosLogin.getSenha())) {
				return ResponseEntity.ok(resultado);
			}
			else {
				return ResponseEntity.status(403).build(); // as senhas não batem - retorno Forbidden(403)
			}
		}
		else {
			return ResponseEntity.notFound().build(); // se não encontrou , retorne código 404
		}
		
	}
}

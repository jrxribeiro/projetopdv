package com.isidrocorp.projetopdv.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isidrocorp.projetopdv.dao.SolicitacaoDAO;
import com.isidrocorp.projetopdv.model.Solicitacao;

@RestController
public class SolicitacaoController {

	
	@Autowired
	SolicitacaoDAO dao;
	
	@GetMapping("/solicitacao/todas")
	public ArrayList<Solicitacao> recuperarTodas(){
		ArrayList<Solicitacao> lista;
		lista = (ArrayList<Solicitacao>)dao.findAll();
		return lista;
	}
	
	@GetMapping("/solicitacao/status/{situacao}")
	public ArrayList<Solicitacao> recuperarPorSituacao(@PathVariable int situacao){
		ArrayList<Solicitacao> lista;
		lista = dao.findBySituacao(situacao);
		return lista;
	}
	
	@PostMapping("/solicitacao/nova")
	public ResponseEntity<Solicitacao> adicionarNova(@RequestBody Solicitacao novaSolicitacao){
		try {
			dao.save(novaSolicitacao);
			return ResponseEntity.status(201).body(novaSolicitacao);
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	/* para atualizar uma solicitação, eu preciso preservar os dados originais, correto?
	 * como proceder: já que eu passo apenas o ID e a SITUAÇÃO, como devo atualizar sem perder os dados
	 * 1 - recuperar a solicitação do banco
	 * 2 - atualizar com novo STATUS
	 * 3 - regravar
	 */
	@PutMapping("/solicitacao/atualiza")
	public ResponseEntity<Solicitacao> atualizarSolicitacao(@RequestBody Solicitacao solicitacao){
		try {
			Solicitacao original = dao.findById(solicitacao.getNumSeq()).orElse(null);
			if (original != null) {
				original.setSituacao(solicitacao.getSituacao()); // aqui eu atribuo para a solicitação original o novo valor do STATUS
				dao.save(original);
				return ResponseEntity.ok(original);
			}
			else {
				return ResponseEntity.notFound().build();
			}
			
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}

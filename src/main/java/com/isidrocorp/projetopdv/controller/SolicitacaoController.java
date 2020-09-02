package com.isidrocorp.projetopdv.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

package com.isidrocorp.projetopdv.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itmn880_solic")
public class Solicitacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "num_seq")
	private int numSeq;
	
	@Column(name="nome_tecnico", length=100)
	private String nomeTecnico;
	
	@Column(name="operadora", length=50)
	private String operadora;
	
	@Column(name="telefone", length=20)
	private String telefone;
	
	@Column(name="doc", length=20)
	private String documento;
	
	@Column(name="data_solic")
	private LocalDate dataSolicitacao;
	
	@Column(name="hora_solic")
	private LocalTime horaSolicitacao;
	
	
	/*
	 *  A relaçao é: PDV--1--<>---N-Solicitacao
	 *  Do ponto de vista do PDV é 1:N
	 *  Do ponto de vista de Solicitacao é N:1, portanto usamos a notação @ManyToOne
	 *  
	 *  entretanto na estrutura da tabela já existe uma coluna chamada pdv_id que é
	 *  a efetetiva coluna de junção das tabelas. Dessa forma, somos obrigados a especificar
	 *  isso também através da anotação @JoinColumn
	 *  
	 */
	@ManyToOne                 
	@JoinColumn(name="pdv_id")
	private Pdv pdv;

	
	public Pdv getPdv() {
		return pdv;
	}

	public void setPdv(Pdv pdv) {
		this.pdv = pdv;
	}

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public LocalTime getHoraSolicitacao() {
		return horaSolicitacao;
	}

	public void setHoraSolicitacao(LocalTime horaSolicitacao) {
		this.horaSolicitacao = horaSolicitacao;
	}
	

	
}

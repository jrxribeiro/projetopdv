package com.isidrocorp.projetopdv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                      // indicando que a classe será armazenável em banco
@Table(name="tbl_usuario")   // especifico o nome da tablea
public class Usuario {
	
	@Id                 // significa que é chave primária
	@GeneratedValue(strategy= GenerationType.IDENTITY)  // valor é auto_increment
	@Column(name="id")
	private int    id;
	
	@Column(name="nome", length=100, nullable=false)
	private String nome;
	
	@Column(name="email", length=100, unique=true)
	private String email;
	
	@Column(name="racf", length=7, unique=true)
	private String racf;
	
	@Column(name="senha", length=30, nullable=false)
	private String senha;
	
	@Column(name="telefone", length=20)
	private String telefone;
	
	@Column(name="link_foto", length=255)
	private String linkFoto;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	

}

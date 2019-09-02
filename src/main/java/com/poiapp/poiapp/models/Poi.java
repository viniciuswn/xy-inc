package com.poiapp.poiapp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Poi implements Serializable{
	
	private static final Integer serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@NotNull
    @Size(min=2, max=50)
	private String nome;
	
	@NotNull
    @Min(0)
	private Integer PontoX;
	
	@NotNull
    @Min(0)
	private Integer PontoY;
	
			
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPontoX() {
		return PontoX;
	}
	public void setPontoX(Integer pontoX) {
		PontoX = pontoX;
	}
	public Integer getPontoY() {
		return PontoY;
	}
	public void setPontoY(Integer pontoY) {
		PontoY = pontoY;
	}
	
	
}

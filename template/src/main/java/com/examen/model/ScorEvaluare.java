package com.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scoruri")
public class ScorEvaluare {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_scor", unique = true, nullable = false)
	private Long id;
	@Column(name = "valoare", nullable = false)
	private int valoare;
	@Column(name = "nume", length = 50)
	private String nume;
	@Column(name = "descriere", length = 1000)
	private String descriere;

	public ScorEvaluare() {

	}

	public ScorEvaluare(int valoare, String nume, String descriere) {
		super();
		this.valoare = valoare;
		this.nume = nume;
		this.descriere = descriere;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValoare() {
		return valoare;
	}

	public void setValoare(int valoare) {
		this.valoare = valoare;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

}
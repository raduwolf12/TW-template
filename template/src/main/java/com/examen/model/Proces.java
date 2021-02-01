package com.examen.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "procese")
public class Proces {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_proces", unique = true, nullable = false)
	private Long id;
	@Column(name = "nume", length = 100)
	private String nume;

	@Column(name = "date", length = 100)
	private String date;

	@ManyToOne(optional = false, cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_scor")
	private ScorEvaluare id_scor;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) { 
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public ScorEvaluare getId_scor() {
		return id_scor;
	}

	public void setId_scor(ScorEvaluare id_scor) {
		this.id_scor = id_scor;
	}

	public Proces(String nume, ScorEvaluare id_scor) {
		super();
		this.nume = nume;
		this.id_scor = id_scor;
	}

	public Proces() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

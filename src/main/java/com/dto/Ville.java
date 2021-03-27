package com.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ville {

	private String insee;
	private String nom;
	private String codePostal;
	private String libelle;
	private String ligne;
	private Coordonnees coord;

	@JsonCreator
	public Ville(@JsonProperty("insee") String insee, @JsonProperty("nom") String nom,
			@JsonProperty("codePostal") String code, @JsonProperty("libelle") String libelle,
			@JsonProperty("ligne") String ligne, @JsonProperty("coordonnees") Coordonnees coord) {
		this.insee = insee;
		this.nom = nom;
		this.codePostal = code;
		this.libelle = libelle;
		this.ligne = ligne;
		this.coord = coord;
	}

	public String getInsee() {
		return insee;
	}

	public void setInsee(String insee) {
		this.insee = insee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public Coordonnees getCoord() {
		return coord;
	}

	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}


}

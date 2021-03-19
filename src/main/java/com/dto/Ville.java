package com.dto;

public class Ville {

	private String insee;
	private String nom;
	private String codePostal;
	private String libelle;
	private String latitude;
	private String longitude;

	public Ville(String insee, String nom, String code, String libelle, String lat, String longi) {
		this.insee = insee;
		this.nom = nom;
		this.codePostal = code;
		this.libelle = libelle;
		this.latitude = lat;
		this.longitude = longi;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}

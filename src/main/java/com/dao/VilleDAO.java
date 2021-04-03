package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	ArrayList<Ville> findAllVilles();

	ArrayList<Ville> getVilleByCodePostal(String code);

	void ajouterVille(Ville ville);

	void modifierVille(Ville ville, String insee);

	void supprimerVille(String insee);
}

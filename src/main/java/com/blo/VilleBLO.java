package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	ArrayList<Ville> getInfoVille(String param);

	void ajouterVille(Ville ville);
	
	void modifierVille(Ville ville, String insee);
	
	void supprimerVille(String insee);
}

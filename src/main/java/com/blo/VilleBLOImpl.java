package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	public ArrayList<Ville> getInfoVille(String monParam) {
		ArrayList<Ville> listeVille = null;

		if (monParam == null) {
			listeVille = villeDAO.findAllVilles();
		} else {
			listeVille = villeDAO.getVilleByInsee(monParam);
		}
		return listeVille;
	}

	public void ajouterVille(Ville ville) {
		villeDAO.ajouterVille(ville);
	}

	public void modifierVille(Ville ville, String insee) {
		villeDAO.modifierVille(ville, insee);
	}

	public void supprimerVille(String insee) {
		villeDAO.supprimerVille(insee);
	}

}

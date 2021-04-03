package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Méthode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String codePostal) {
		System.out.println("Appel GET");
		return villeBLOService.getInfoVille(codePostal);
	}

	// Méthode POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	public void appelPost(@RequestBody Ville newVille) {
		System.out.println("Appel POST");
		villeBLOService.ajouterVille(newVille);
	}

	// Méthode PUT
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	public void appelPut(@RequestBody Ville newVille, @RequestParam(required = true, value = "insee") String insee) {
		System.out.println("Appel PUT");
		villeBLOService.modifierVille(newVille, insee);
	}

	// Méthode DELETE
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	public void appelDelete(@RequestParam(required = true, value = "insee") String insee) {
		System.out.println("Appel DELETE");
		villeBLOService.supprimerVille(insee);
	}
}

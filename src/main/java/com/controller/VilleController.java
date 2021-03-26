package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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

	// Méthode Post
	@RequestMapping(value = "/ville_post", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ArrayList<Ville> appelPost() {
		System.out.println("Appel POST");
		villeBLOService.ajouterVille();
		return villeBLOService.getInfoVille("44680");
	}
}

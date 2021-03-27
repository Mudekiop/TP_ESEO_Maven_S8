package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.config.JDBCConfiguration;
import com.dto.Coordonnees;
import com.dto.Ville;

@Service
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> liste = new ArrayList<Ville>();
		Coordonnees coord = null;
		Connection con = new JDBCConfiguration().getCo();
		try {
			Statement st = con.createStatement();
			ResultSet resultat = st.executeQuery("SELECT * FROM ville_france;");
			while (resultat.next()) {
				coord = new Coordonnees(resultat.getString("Latitude"), resultat.getString("Longitude"));
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5), coord);
				liste.add(ville);
			}
			return liste;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Ville> getVilleByCodePostal(String code) {
		ArrayList<Ville> liste = new ArrayList<Ville>();
		Coordonnees coord = null;
		Connection con = new JDBCConfiguration().getCo();

		try {
			Statement st = con.createStatement();
			ResultSet resultat = st.executeQuery("SELECT * FROM ville_france WHERE Code_postal='" + code + "';");
			while (resultat.next()) {
				coord = new Coordonnees(resultat.getString("Latitude"), resultat.getString("Longitude"));
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5), coord);
				liste.add(ville);
			}
			return liste;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void ajouterVille(Ville ville) {
		Connection con = new JDBCConfiguration().getCo();

		try {
			Statement st = con.createStatement();
			System.out.println(
					"INSERT INTO `ville_france`(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES ('"
							+ ville.getInsee() + "','" + ville.getNom() + "','" + ville.getCodePostal() + "','"
							+ ville.getLibelle() + "','" + ville.getLigne() + "','" + ville.getCoord().getLatitude()
							+ "','" + ville.getCoord().getLongitude() + "';");
			st.executeUpdate(
					"INSERT INTO `ville_france`(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES ('"
							+ ville.getInsee() + "','" + ville.getNom() + "','" + ville.getCodePostal() + "','"
							+ ville.getLibelle() + "','" + ville.getLigne() + "','" + ville.getCoord().getLatitude()
							+ "','" + ville.getCoord().getLongitude() + "');");
			System.out.println("Ajout Réussi");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter la ville à la base de donnée");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Fermeture impossible");
			}
		}
	}

}

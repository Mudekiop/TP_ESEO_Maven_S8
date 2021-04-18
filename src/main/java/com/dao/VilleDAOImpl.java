package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.config.JDBCConfiguration;
import com.dto.Coordonnees;
import com.dto.Ville;

@Service
public class VilleDAOImpl implements VilleDAO {

	private Logger logger = LoggerFactory.getLogger(VilleDAOImpl.class);
	private Statement st = null;
	private ResultSet resultat = null;
	private ArrayList<Ville> liste = new ArrayList<Ville>();
	private Coordonnees coord = null;

	public ArrayList<Ville> findAllVilles() {
		Connection con = new JDBCConfiguration().getCo();
		liste = new ArrayList<Ville>();
		try {
			this.st = con.createStatement();
			this.resultat = this.st.executeQuery("SELECT * FROM ville_france;");
			while (resultat.next()) {
				this.coord = new Coordonnees(resultat.getString("Latitude"), resultat.getString("Longitude"));
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5), coord);
				this.liste.add(ville);
			}
			return this.liste;
		} catch (SQLException e) {
			this.logger.error("Impossible de réaliser la requête.", e);
		} finally {
			try {
				this.st.close();
				con.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}
		return null;
	}

	public ArrayList<Ville> getVilleByInsee(String code) {
		Connection con = new JDBCConfiguration().getCo();
		liste = new ArrayList<Ville>();

		try {
			this.st = con.createStatement();
			this.resultat = this.st.executeQuery("SELECT * FROM ville_france WHERE Code_commune_INSEE='" + code + "';");
			while (resultat.next()) {
				this.coord = new Coordonnees(resultat.getString("Latitude"), resultat.getString("Longitude"));
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5), coord);
				this.liste.add(ville);
			}
			return this.liste;
		} catch (SQLException e) {
			this.logger.error("Impossible de réaliser la requête.", e);
		} finally {
			try {
				this.st.close();
				con.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}
		return null;
	}

	public void ajouterVille(Ville ville) {
		Connection con = new JDBCConfiguration().getCo();

		try {
			this.st = con.createStatement();
			this.st.executeUpdate(
					"INSERT INTO `ville_france`(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES ('"
							+ ville.getInsee() + "','" + ville.getNom() + "','" + ville.getCodePostal() + "','"
							+ ville.getLibelle() + "','" + ville.getLigne() + "','" + ville.getCoord().getLatitude()
							+ "','" + ville.getCoord().getLongitude() + "');");
		} catch (SQLException e) {
			this.logger.error("Impossible de réaliser la requête.", e);
		} finally {
			try {
				this.st.close();
				con.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}
	}

	public void modifierVille(Ville ville, String insee) {
		Connection con = new JDBCConfiguration().getCo();

		try {
			this.st = con.createStatement();
			this.st.executeUpdate("UPDATE ville_france SET Code_commune_INSEE='" + ville.getInsee()
					+ "', Nom_commune ='" + ville.getNom() + "',Code_postal='" + ville.getCodePostal()
					+ "',Libelle_acheminement='" + ville.getLibelle() + "',Ligne_5='" + ville.getLigne()
					+ "',Latitude='" + ville.getCoord().getLatitude() + "',Longitude='"
					+ ville.getCoord().getLongitude() + "' WHERE Code_commune_INSEE='" + insee + "';");
		} catch (SQLException e) {
			this.logger.error("Impossible de réaliser la requête.", e);
		} finally {
			try {
				this.st.close();
				con.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}
	}

	public void supprimerVille(String insee) {
		Connection con = new JDBCConfiguration().getCo();

		try {
			this.st = con.createStatement();
			this.st.executeUpdate("DELETE FROM ville_france WHERE Code_commune_INSEE='" + insee + "';");
		} catch (SQLException e) {
			this.logger.error("Impossible de réaliser la requête.", e);
		} finally {
			try {
				this.st.close();
				con.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}
	}

}

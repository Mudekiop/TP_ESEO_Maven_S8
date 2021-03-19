package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Service
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> liste = new ArrayList<Ville>();

		Connection con = new JDBCConfiguration().getCo();
		try {
			Statement st = con.createStatement();
			ResultSet resultat = st.executeQuery("SELECT * FROM ville_france;");
			while (resultat.next()) {
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(6), resultat.getString(7));
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
		Connection con = new JDBCConfiguration().getCo();

		try {
			Statement st = con.createStatement();
			ResultSet resultat = st.executeQuery("SELECT * FROM ville_france WHERE Code_postal='" + code + "';");
			while (resultat.next()) {
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(6), resultat.getString(7));
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

}

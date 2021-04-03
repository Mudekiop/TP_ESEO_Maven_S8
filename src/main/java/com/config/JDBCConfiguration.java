package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.VilleDAOImpl;

public class JDBCConfiguration {

	private Connection co;
	private Logger logger = LoggerFactory.getLogger(JDBCConfiguration.class);


	public JDBCConfiguration() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			this.logger.error("La classe Driver n'existe pas.", e);
		}
		try {
			this.co = DriverManager.getConnection("jdbc:mysql://localhost/Projet_Maven?user=root&password=root");
		} catch (SQLException e) {
			this.logger.error("Impossible de se connecter à la base de données.", e);
		}
	}

	public Connection getCo() {
		return co;
	}
}

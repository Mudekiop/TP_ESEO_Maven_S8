package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			String user = Configuration.getString("user");
			String mdp = Configuration.getString("password");
			this.co = DriverManager
					.getConnection("jdbc:mysql://localhost/Projet_Maven?user=" + user + "&password=" + mdp);
		} catch (SQLException e) {
			this.logger.error("Impossible de se connecter à la base de données.", e);
		}
	}

	public Connection getCo() {
		return co;
	}
}

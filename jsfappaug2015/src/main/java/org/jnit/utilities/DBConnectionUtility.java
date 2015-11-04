package org.jnit.utilities;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionUtility {

	public static Connection getConnection() throws SQLException,
			NamingException {
		Context initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("javatraining");
		return ds.getConnection();
	}
}

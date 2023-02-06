package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConection {

	public static Connection getConnection() throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@localhost:8080/xe";
		String driver = "oracle:jdbc:driver:OracleDriver";
		
		Class.forName(driver);
		
		//Connection connection = DriverManager.getConnection(url, user, password);
		return DriverManager.getConnection(url, user, password); //connection;
	}
	
	public static void disConnect (Connection con, PreparedStatement st, ResultSet rs) throws Exception {
		rs.close();
		st.close();
		con.close();
	}
	
	public static void disConnect (Connection con, PreparedStatement st) throws Exception {
		st.close();
		con.close();
	}
	
	
}

package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	//클래스 메서드 객체를 생성하지 않고 사용 클라스명.메서드명으로 사용.
	public static Connection getConnection () throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //sid면 : service면 /
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. driver를 메모리에 로딩
		Class.forName(driver); //문자열로 된걸 클래스로 만듬
		
		return DriverManager.getConnection(url, user, password); //		Connection connection = DriverManager.getConnection(url, username, password);

	}
	
	public static void disConnection (Connection con, PreparedStatement st) throws Exception {
		st.close();
		con.close();
	}
	
	public static void disConnection (Connection con, PreparedStatement st, ResultSet rs)throws Exception {
		rs.close();
		st.close();
		con.close();
	}
	
	
	//배포전 삭제하세요.
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection();
			System.out.println(con != null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

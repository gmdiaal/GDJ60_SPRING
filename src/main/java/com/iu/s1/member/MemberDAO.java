package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {

	public int setAddMember(MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ? ,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(connection, st);
		return result;
	}
	
}

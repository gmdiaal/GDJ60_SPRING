package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	public MemberDTO getMemberDetail (MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		PreparedStatement st= connection.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		ResultSet rs = st.executeQuery();

		if(rs.next()) { //객체 생성 해야하나? 
			memberDTO.setId(rs.getString("ID"));
			memberDTO.setId(rs.getString("PW"));
			memberDTO.setId(rs.getString("NAME"));
			memberDTO.setId(rs.getString("PHONE"));
			memberDTO.setId(rs.getString("EMAIL"));
		}else {memberDTO = null;}
		
		DBConnection.disConnection(connection, st);
		return memberDTO;
		
	}

	public List<MemberDTO> getMemberList() throws Exception{
		List<MemberDTO> ar = new ArrayList<MemberDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("ID"));
			memberDTO.setPw(rs.getString("PW"));
			memberDTO.setName(rs.getString("NAME"));
			memberDTO.setPhone(rs.getString("PHONE"));
			memberDTO.setEmail(rs.getString("EMAIL"));
			System.out.println(memberDTO.getName());
			ar.add(memberDTO);
			
		}
		DBConnection.disConnection(connection, st, rs);
		return ar;
	}
	
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

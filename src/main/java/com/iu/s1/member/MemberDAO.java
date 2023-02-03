package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConection;

@Repository
public class MemberDAO {

	
	public List<memberDTO> getMemberList () throws Exception {
		List<memberDTO> ar = new ArrayList<memberDTO>();
		
		Connection connection = DBConection.getConnection();
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			memberDTO dto = new memberDTO();
			dto.setId(rs.getString("ID"));
			dto.setPw(rs.getString("PW"));
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getString("PHONE"));
			dto.setEmail(rs.getString("EMAIL"));
			ar.add(dto);
		}
		return ar;
				
	}
	
}

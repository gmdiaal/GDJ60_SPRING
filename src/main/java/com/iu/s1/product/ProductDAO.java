package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	public Long getProductNum () throws Exception { //시퀀스 구하기 (찾을 상품)
//		Connection connection = DBConnection.getConnection();
//		String sql = "SELECT PUBLIC_SEQ.NEXTVAL FROM DUAL";
//		PreparedStatement st = connection.prepareStatement(sql);
//		ResultSet rs = st.executeQuery();
//		Long result = rs.getLong("MAX(PRODUCT_NUM)"); //1
//		
//		DBConnection.disConnection(connection, st, rs);
//		return result;
		Connection con = DBConnection.getConnection();
		String sql = "SELECT PUBLIC_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(con, st, rs);
		return num;
	}
	
	public ProductDTO getProductDetail(ProductDTO dto) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NUM=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, dto.getProduct_num());
		ResultSet rs = st.executeQuery();
		
//		if(rs.next()) {
//			ProductDTO productDTO = new ProductDTO();
//			productDTO.setProduct_num(rs.getLong("PRODUCT_NUM"));
//			productDTO.setProduct_name(rs.getString("PRODUCT_NAME"));
//			productDTO.setProduct_detail(rs.getString("PRODUCT_DETAIL"));
//			productDTO.setProduct_score(rs.getDouble("PRODUCT_SCORE"));
//			dto = productDTO;
//		}else {dto = null;}

		if(rs.next()) { //객체 생성 해야하나? 할필요없다.
			dto.setProduct_num(rs.getLong("PRODUCT_NUM"));
			dto.setProduct_name(rs.getString("PRODUCT_NAME"));
			dto.setProduct_detail(rs.getString("PRODUCT_DETAIL"));
			dto.setProduct_score(rs.getDouble("PRODUCT_SCORE"));
		}else {dto = null;}
		
		DBConnection.disConnection(connection, st);
		
//		System.out.println(dto.getProduct_num());
//		System.out.println(dto.getProduct_name());
		
		return dto;
	}

	public List<ProductOptionDTO> getProductOptionList () throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTOPTION";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ProductOptionDTO dto = new ProductOptionDTO();
			dto.setOption_num(rs.getLong("OPTION_NUM"));
			dto.setProduct_num(rs.getLong("PRODUCT_NUM"));
			dto.setName(rs.getString("NAME"));
			dto.setPrice(rs.getLong("PRICE"));
			dto.setStock(rs.getLong("STOCK"));
			ar.add(dto);
		}
		DBConnection.disConnection(connection, st, rs);
		return ar;
	}
	
	public int setProductOption (ProductOptionDTO dto) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTOPTION "
				+ "VALUES (PUBLIC_SEQ.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, dto.getProduct_num());
		st.setString(2, dto.getName());
		st.setLong(3, dto.getPrice());
		st.setLong(4, dto.getStock());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(connection, st);
		return result;
	}
	
	public List<ProductDTO> getProductList () throws Exception {
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT PRODUCT_NUM, PRODUCT_NAME, PRODUCT_SCORE "
				+ "FROM PRODUCT ORDER BY PRODUCT_SCORE DESC";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setProduct_num(rs.getLong("PRODUCT_NUM"));
			dto.setProduct_name(rs.getString("PRODUCT_NAME"));
			dto.setProduct_score(rs.getDouble("PRODUCT_SCORE"));
			ar.add(dto);
		}
		DBConnection.disConnection(connection, st, rs);
		return ar;		
	}
	

	public int setProduct (ProductDTO dto) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCT VALUES (PUBLIC_SEQ.NEXTVAL, ?, ?, 0.0)";
		PreparedStatement ps = connection.prepareStatement(sql);
		//ps.setLong(1, dto.getProduct_num());
		ps.setString(1, dto.getProduct_name());
		ps.setString(2, dto.getProduct_detail());
		//ps.setDouble(3, dto.getProduct_score());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnection(connection, ps);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		ProductDTO productDTO = new ProductDTO();
		ProductDAO productDAO = new ProductDAO();
		

		try {
			
			

			
//조회					
//			List<ProductDTO> ar = productDAO.getProductList();
//			System.out.println(ar.size() != 0);
//			productDTO = ar.get(0);
//			System.out.println(productDTO.getProduct_name());
//조회

//set 상품
			//productDTO.setProduct_num((long) 2);
//			productDTO.setProduct_name("test1");
//			productDTO.setProduct_detail("test1");
//			productDTO.setProduct_score( (double) 1 );
//			
//			int result = productDAO.setProduct(productDTO);
//			System.out.println(result !=0);
//set 상품			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

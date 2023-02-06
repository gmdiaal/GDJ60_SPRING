package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete (Long productNum) throws Exception {
		return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
	
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
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(con, st, rs);
		return num;
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
		//selectone --> product_num이 pk라서 하나만 나옴. 만약 두개나오면 에러
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
		//ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		//Connection connection = dataSource.getConnection();

		return sqlSession.selectList(NAMESPACE+"getProductList");		
	}
	

	public int setProduct (ProductDTO dto) throws Exception { //다른데서 seq만들어서 넣어줌 PUBLIC_SEQ.NEXTVAL 하지마

		return sqlSession.update(NAMESPACE+"setProduct", dto);
	}
	
}

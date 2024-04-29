package service;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.List;

import dao.CartDAO;
import dao.CartDAOImpl;
import dto.CartDTO;

public class CartServiceImpl implements CartService {

	CartDAO cartDAO = new CartDAOImpl();
	
	@Override
	public List<CartDTO> selectAll(int userSeq) throws SQLException {
		
		List<CartDTO> list = cartDAO.selectAll(userSeq);
		
		
		
		return list;
	}

	@Override
	public int delete(int furnitureSeq) throws SQLException {

		cartDAO.delete(furnitureSeq);
		
		return 0;
	}

	@Override
	public int insertCart(CartDTO cartDTO) throws SQLException {
		

		int result = cartDAO.insertCart(cartDTO);
		if (result == 0) throw new SQLException("회원정보 삭제 실패하였습니다.");
		return result;
	}

}
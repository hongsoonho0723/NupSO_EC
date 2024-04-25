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

}

package service;

import java.sql.SQLException;

import java.util.List;

import dao.WishListDAO;
import dao.WishListDAOImpl;
import dto.WishListDTO;

public class WishListServiceImpl implements WishListService {
	
	WishListDAO wishListDAO = new WishListDAOImpl();
	
	@Override
	public List<WishListDTO> selectAll(int userSeq) throws SQLException {
		List<WishListDTO> list = wishListDAO.selectAll(userSeq);

		return list;
	}

	@Override
	public int delete(int furnitureSeq) throws SQLException {
		wishListDAO.delete(furnitureSeq);
		return 0;
	}

}

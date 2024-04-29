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
		System.out.println("서비스호출테스트");
		List<WishListDTO> list = wishListDAO.selectAll(userSeq);

		return list;
	}

	@Override
	public int delete(int furnitureSeq) throws SQLException {
		wishListDAO.delete(furnitureSeq);
		return 0;
	}

	@Override
	public int insert(WishListDTO wishlistDTO) throws SQLException {
		int result = wishListDAO.insert(wishlistDTO);
		if (result == 0) throw new SQLException("관심목록 등록 실패");
		return result;
	}
	
	
}

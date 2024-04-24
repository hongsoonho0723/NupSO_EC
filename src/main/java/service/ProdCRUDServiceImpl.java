package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProdCRUDDAO;
import dao.ProdCRUDDAOImpl;
import dto.FurnitureDTO;

public class ProdCRUDServiceImpl implements ProdCRUDService{
	private ProdCRUDDAO prodCRUDDAO = new ProdCRUDDAOImpl();
	
	@Override
	public List<FurnitureDTO> selectAll() throws SQLException {
		List<FurnitureDTO> list = prodCRUDDAO.selectAll();
		return list;
	}
	
}

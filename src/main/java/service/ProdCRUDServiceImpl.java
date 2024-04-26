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
		 System.out.println("Service에서 DAO로부터 받은 데이터: " + list); 
		return list;
	}
	
	@Override
    public void delete(int furnitureSeq) throws SQLException {
        int result = prodCRUDDAO.delete(furnitureSeq);
        if (result == 0) throw new SQLException("상품 삭제에 실패했습니다.");
    }
	
}

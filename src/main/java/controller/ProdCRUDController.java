package controller;

import java.sql.SQLException;
import java.util.List;

import dto.FurnitureDTO;
import dto.QnADTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProdCRUDService;
import service.ProdCRUDServiceImpl;

public class ProdCRUDController implements Controller{
	ProdCRUDService service = new ProdCRUDServiceImpl();
	
	public ProdCRUDController() {}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
	public ModelAndView selectAll (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<FurnitureDTO> list = service.selectAll();
		request.setAttribute("list", list);
		return new ModelAndView("/WEB-INF/views/admin/adminCRUD.jsp");
	}
}

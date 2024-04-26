package controller;

import java.sql.SQLException;
import java.util.List;

import dto.FurnitureDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProdCRUDService;
import service.ProdCRUDServiceImpl;

public class ProdCRUDController implements Controller{
	ProdCRUDService service = new ProdCRUDServiceImpl();
	
	public ProdCRUDController() {}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        List<FurnitureDTO> list = service.selectAll();
	        request.setAttribute("list", list);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return new ModelAndView("admin/adminCRUD.jsp");
	}
	
	public ModelAndView selectAll (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// System.out.println("controller 오니?");
		List<FurnitureDTO> list = service.selectAll();
		/*
		 * for (FurnitureDTO furnitureDTO : list) { System.out.println(furnitureDTO); }
		 */
		request.setAttribute("list", list);
		return new ModelAndView("admin/adminCRUD.jsp");
	}
	
	public ModelAndView delete (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("controller 오니?");
		int furnitureSeq = Integer.parseInt(request.getParameter("furnitureSeq"));
		
		service.delete(furnitureSeq);
		
		List<FurnitureDTO> list = service.selectAll();
		request.setAttribute("list", list);
		
		return new ModelAndView("admin/adminCRUD.jsp");
	}
}

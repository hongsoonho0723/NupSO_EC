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
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        List<FurnitureDTO> list = service.selectAll();
	        request.setAttribute("list", list);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // SQL 예외 처리 로직 추가
	        // 예외 처리 후 적절한 뷰 경로를 설정할 수 있습니다.
	    }
	    return new ModelAndView("admin/adminCRUD.jsp");
	}
	
	public ModelAndView selectAll (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<FurnitureDTO> list = service.selectAll();
		request.setAttribute("list", list);
		return new ModelAndView("admin/adminCRUD.jsp");
	}
}

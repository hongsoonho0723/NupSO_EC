package controller;

import java.sql.SQLException;
import java.util.List;


import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AdminUserService;
import service.AdminUserServiceImpl;

public class AdminuserController implements Controller {
	AdminUserService service = new AdminUserServiceImpl();
	
	
    public AdminuserController() {}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	List<UsersDTO> list = service.selectUser(); 	
    	request.setAttribute("list", list);
		return new ModelAndView("admin/adminUser.jsp");
    }
    
	public ModelAndView searchByState(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("체크박스 컨트롤러 테스트");
    	String userState = request.getParameter("userState");
		
		List <UsersDTO> list = service.findUserSeqByState(userState);
		request.setAttribute("list", list);
    	
    	return new ModelAndView("admin/adminUser.jsp");
    	
    }
	
	 public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws SQLException{
	    	int userSeq = Integer.parseInt(request.getParameter("userSeq"));
	    	
	    	service.delete(userSeq);
	    	
	    	List<UsersDTO> list = service.selectUser(); 	
	    	request.setAttribute("list", list);
			return new ModelAndView("admin/adminUser.jsp");
	    }
}

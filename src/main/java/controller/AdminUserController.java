package controller;

import java.sql.SQLException;
import java.util.List;


import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AdminUserService;
import service.AdminUserServiceImpl;

public class AdminUserController implements Controller {
	AdminUserService service = new AdminUserServiceImpl();
	
	
	
    public AdminUserController() {}

	@Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
	
	
    public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	List<UsersDTO> list = service.selectUser(); 	
    	request.setAttribute("list", list);
		return new ModelAndView("admin/adminUser.jsp");
    }
    
    
    public ModelAndView searchByState(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String userState = request.getParameter("userState");
		
		service.findUserSeqByState(userState);
		request.setAttribute("userState", userState);
    	
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

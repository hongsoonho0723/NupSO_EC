package controller;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class AdminLogInOutController implements Controller {
	
	 private String correctAdminId="admin@kosta.com";		
	 private String correctAdminPwd="admin1234";
	
	public AdminLogInOutController() {}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
    
	/*
	 * 로그인
	 */

	
	public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String adminId = request.getParameter("inputEmail");
    	 String adminPwd = request.getParameter("inputPassword");
    	
    	 if(adminId.equals(correctAdminId) && adminPwd.equals(correctAdminPwd)) {
     		
    		 // 세션 정보 설정
    		 HttpSession session = request.getSession();
    		 session.setAttribute("adminId", adminId);
    		 session.setAttribute("adminPassword", adminPwd);
    		 
    		OrderController order = new OrderController();
    		ModelAndView mv = order.selectOrderFurnitureName(request, response);
    		return mv; 
    	 }else {
    		 response.setContentType("text/html;charset=UTF-8");
    		 PrintWriter out = response.getWriter();
    		 //예외메시지  출력
    		 out.println("<script>");
    		 out.println("alert('정보를 다시 확인해주세요')");
    		
    		 out.println("history.back();");//뒤로가기
    		 out.println("</script>");
    		 
    	 	}	 
    	 return null;
	}

	/*
	 * 로그인 아웃
	 */

	public ModelAndView adminLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그아웃테스트입니다.");
		HttpSession session = request.getSession(false);
		 if(session != null) {
			 session.invalidate();
			 
			// 캐시 관련 헤더 추가
		        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		        response.setDateHeader("Expires", 0); // Proxies.
			 
		        
		        FurnitureController furniture = new FurnitureController();
	    		ModelAndView mv = furniture.indexPage(request, response);
	    		return mv; 
			
			 
		 }
		 
		  return new ModelAndView("admin/adminLogin.jsp");
		
	}
}

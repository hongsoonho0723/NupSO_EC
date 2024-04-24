package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/adminlogout" , loadOnStartup = 1)
public class AdminLogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그아웃테스트");
		
		HttpSession session = request.getSession(false);
		 if(session != null) {
			 session.invalidate();
			 
			// 캐시 관련 헤더 추가
		        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		        response.setDateHeader("Expires", 0); // Proxies.
			 
			 response.sendRedirect(request.getContextPath() + "/Index.jsp");//폼으로이동
			 
		 }else {
		 response.sendRedirect(request.getContextPath() + "/admin/adminLogin.jsp");
		 }
	}
}




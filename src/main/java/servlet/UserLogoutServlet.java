package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/userLogout", loadOnStartup = 1)
public class UserLogoutServlet extends HttpServlet {
	
   
       @Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		System.out.println("유저 로그아웃");
    		
    		HttpSession session = request.getSession();
    		session.invalidate();//모든세션정보 삭제
    		
    		response.sendRedirect("index.jsp");
    	}
       
}

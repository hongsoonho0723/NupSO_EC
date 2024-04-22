package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/adminLogin", loadOnStartup = 1)
public class AdminLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private String correctAdminId="admin@kosta.com";		
    private String correctAdminPwd="admin1234";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
         //전송된 데이터 받기 
    	
    	System.out.println("서블릿 옴");
    	
    	 String adminId = request.getParameter("inputEmail");
    	 String adminPwd = request.getParameter("inputPassword");
    	
    	 
    	 if(adminId.equals(correctAdminId) && adminPwd.equals(correctAdminPwd)) {

    		response.sendRedirect(request.getContextPath() + "/front?key=order&methodName=selectOrderFunitureName");
    		 
    	 }else {
    		 response.setContentType("text/html;charset=UTF-8");
    		 PrintWriter out = response.getWriter();
    		 //예외메시지  출력
    		 out.println("<script>");
    		 out.println("alert('정보를 다시 확인해주세요')");
    		
    		 out.println("history.back();");//뒤로가기
    		 out.println("</script>");
    		 
    	 	}	 
    	 
    	
    }

}

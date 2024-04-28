
package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/ajax/cart")
public class UserLogin implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		System.out.println("filter call");
	    HttpServletRequest req=(HttpServletRequest)request;
	    HttpSession session=req.getSession();
	    int id=0;
	    
	    try {
	    	id=(int) session.getAttribute("userSeq");
	    }catch(Exception e) {};
	    
	    	System.out.println("id = "+ id);
	    	
	    	if(id != 0) {
	    	  System.out.println("filter1 id !=null");
	    	  chain.doFilter(request, response);
	    	}else {
	    		System.out.println("filter2 id !=null");
	        	HttpServletResponse res = (HttpServletResponse) response;
	        	String path = req.getContextPath();
	        	System.out.println("Context path = " + path);
	        	res.sendRedirect(path + "/login.jsp");
	      }

	}

	
  
  }


package filter;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/ajax/cart","/ajax/checkout"})
public class UserLogin implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("filter call");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		int userSeq = 0;

		Object obj = session.getAttribute("userSeq");
	

		System.out.println("userSeq = " + userSeq);

		if (obj != null) {
			System.out.println("filter1 userSeq !=null");
			
			chain.doFilter(request, response);//다음 서블릿을 호출
			
		} else {
			System.out.println("filter2 userSeq ==null");
			HttpServletResponse res = (HttpServletResponse) response;
			
			 Gson gson = new Gson();
			  JsonObject gsonObj = new JsonObject();
			PrintWriter out = res.getWriter();
			 gsonObj.addProperty("info", "로그인하고 이용해주세요.");
			 out.print( gson.toJson(gsonObj) );
			
		}

	}

}

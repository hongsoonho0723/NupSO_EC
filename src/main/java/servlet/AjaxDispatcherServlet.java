/*
 * package servlet;
 * 
 * import java.io.IOException; import java.lang.reflect.Method; import
 * java.util.Map;
 * 
 * import controller.RestController; import jakarta.servlet.ServletConfig;
 * import jakarta.servlet.ServletContext; import
 * jakarta.servlet.ServletException; import
 * jakarta.servlet.annotation.WebServlet; import
 * jakarta.servlet.http.HttpServlet; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 *//**
	 * 사용자의 모든 ajax 요청을 처리할 진입점 Controller이다(FrontController의 역할한다)
	 *//*
		 * @WebServlet(urlPatterns = "/ajax" , loadOnStartup = 1) public class
		 * AjaxDispatcherServlet extends HttpServlet { private static final long
		 * serialVersionUID = 1L;
		 * 
		 * private Map<String, RestController> ajaxMap; private Map<String, Class<?>>
		 * clzMap;
		 * 
		 * 
		 * 
		 * @Override public void init(ServletConfig config) throws ServletException {
		 * ServletContext applicaion = config.getServletContext(); ajaxMap =
		 * (Map<String, RestController>)applicaion.getAttribute("ajaxMap"); clzMap =
		 * (Map<String, Class<?>>)applicaion.getAttribute("ClzMap");
		 * 
		 * }
		 * 
		 * protected void service(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { String key =
		 * request.getParameter("key"); String methodName =
		 * request.getParameter("methodName");
		 * 
		 * System.out.println("AjaxDispatcher key " + key);
		 * System.out.println("AjaxDispatcher methodName " + methodName);
		 * 
		 * try {
		 * 
		 * RestController controller = ajaxMap.get(key); Class<?> clz = clzMap.get(key);
		 * 
		 * Method method = clz.getMethod(methodName,HttpServletRequest.class,
		 * HttpServletResponse.class);
		 * 
		 * method.invoke(controller, request,response);
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace(); //비동기는 페이지 이동할 필요가 없다 . catch로
		 * 오면 실행오류인거고 ajax의 error로 간다 }
		 * 
		 * 
		 * }//service 메소드 끝
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 */

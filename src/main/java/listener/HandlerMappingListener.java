package listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import controller.Controller;
import controller.RestController;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HandlerMappingListener implements ServletContextListener {
	public HandlerMappingListener() {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		

		Map<String, Controller> map = new HashMap<String, Controller>();
		Map<String, RestController> ajaxMap = new HashMap<String, RestController>();
		Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();

		
		 ResourceBundle rb = ResourceBundle.getBundle("actionMapping");
		 ResourceBundle ajaxRb = ResourceBundle.getBundle("ajaxMapping");
		 
		 try{ 
			 for(String key : rb.keySet()){ 
				 System.out.println("key "+key);
				 String value = rb.getString(key);
				 System.out.println("value "+value);
				 Class<?> className = Class.forName(value);
			 
				 Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
				 System.out.println("actionMapping key " + key + " value "+value);
				 map.put(key, controller); 
				 clzMap.put(key, className); 
				 
			 }
			 
			 //ajax Class<?> , RestController 넣기
		 	for(String key : ajaxRb.keySet()){ 
		 		 System.out.println("key "+key);
				 String value = ajaxRb.getString(key);
				 System.out.println("value "+value);
				 Class<?> className = Class.forName(value);
			 
				 RestController controller = (RestController)className.getDeclaredConstructor().newInstance();
				 System.out.println("ajaxMapping key " + key + " value "+value);
				 ajaxMap.put(key, controller); 
				 clzMap.put(key, className); 
				 
			 } 

			 
		 }catch(Exception e){
			 e.printStackTrace(); 
		 }
		 

		ServletContext application = sce.getServletContext();
		application.setAttribute("map", map);
		application.setAttribute("clzMap", clzMap);
		application.setAttribute("ajaxMap", ajaxMap);
		application.setAttribute("path", sce.getServletContext().getContextPath());
	}
}


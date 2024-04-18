package listener;

import controller.Controller;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@WebListener
public class HandlerMappingListener implements ServletContextListener {
    public HandlerMappingListener() {}

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("HandlerMappingListener contextInitialized");

        Map<String, Controller> map = new HashMap<String,Controller>();
        Map<String, Class<?>> clzMap = new HashMap<String,Class<?>>();

		/*오류나는 부분
		 * ResourceBundle rb = ResourceBundle.getBundle("actionMapping");
		 * 
		 * try{ for(String key : rb.keySet()){ String value = rb.getString(key);
		 * 
		 * Class<?> className = Class.forName(value);
		 * 
		 * Controller controller = (Controller)
		 * className.getDeclaredConstructor().newInstance();
		 * 
		 * map.put(key, controller); clzMap.put(key, className); } }catch(Exception e){
		 * e.printStackTrace(); }
		 */

        ServletContext application = sce.getServletContext();
        application.setAttribute("map", map);
        application.setAttribute("clzMap", clzMap);
        application.setAttribute("path",sce.getServletContext().getContextPath());
    }
}

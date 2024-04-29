package controller;

import java.sql.SQLException;
import java.util.List;

import dto.ReviewDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ReviewService;
import service.ReviewServiceImpl;

public class ReviewController implements Controller {
	ReviewService service = new ReviewServiceImpl();
	
	
	
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	List<ReviewDTO> list = service.selectAll(); 	
    	request.setAttribute("list", list);
		return new ModelAndView("admin/adminReview.jsp");
    }
    
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws SQLException{
    	int reviewSeq = Integer.parseInt(request.getParameter("reviewSeq"));
    	
    	service.delete(reviewSeq);
    	
    	List<ReviewDTO> list = service.selectAll(); 	
    	request.setAttribute("list", list);
		return new ModelAndView("admin/adminReview.jsp");
    }
    
}

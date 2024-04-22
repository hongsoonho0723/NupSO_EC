package controller;

import dto.FurnitureDTO;
import dto.ImgDTO;
import dto.ReviewDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FurnitureController implements Controller {
    FurnitureService furnitureService = new FurnitureServiceImpl();
    ImgService imgService = new ImgServiceImpl();

    ReviewService reviewService = new ReviewServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public FurnitureController() throws IOException {}

    /*
    상품 상세 조회 페이지
     */
    public ModelAndView furnitureInfo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("FurnitureController productInfo");

        String furnitureNumber = request.getParameter("furnitureNumber");
        try {
            FurnitureDTO furnitureDTO = furnitureService.selectFurnitureNumber(furnitureNumber);
            int furnitureSeq = furnitureService.findFurnitureSeqByNumber(furnitureNumber);

            List<ImgDTO> imgList = imgService.selectImg(furnitureSeq);
            List<ImgDTO> imgDetailList = imgService.selectDetailImg(furnitureSeq);

            List<ReviewDTO> reviewList = reviewService.selectAllReviews(furnitureSeq);
            int userSeq = reviewService.findUserSeq(furnitureSeq);
            String userName = userService.findUserNameBySeq(userSeq);

            request.setAttribute("furnDTO", furnitureDTO);

            request.setAttribute("imgList",imgList);
            request.setAttribute("imgDetailList",imgDetailList);

            request.setAttribute("reviewList",reviewList);
            request.setAttribute("userName",userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("furniture/furniture.jsp");
    }
    
    public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	List<FurnitureDTO> list = furnitureService.selectAll();
    	
    	 request.setAttribute("list", list);
    	
    	return new ModelAndView("admin/adminCharts.jsp");
    }
}

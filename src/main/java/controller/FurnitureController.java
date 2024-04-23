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

        String furnitureName = request.getParameter("furnitureName");
        try {
            FurnitureDTO furnitureDTO = furnitureService.selectFurnitureName(furnitureName);
            // 상세페이지 설명 사진 가져오기
            furnitureDTO.setImgDetailList(imgService.selectImgDetail(furnitureDTO));

            // 상세페이지 슬라이드 사진 가져오기
            furnitureDTO.setImgList(imgService.selectImg(furnitureDTO));
            
            // 상세페이지 사이즈 가져오기
            furnitureDTO.setColorList(furnitureService.selectColorList(furnitureName));
            //List<ReviewDTO> reviewList = reviewService.selectAllReviews(furnitureDTO.getFurnitureSeq());
            //int userSeq = reviewService.findUserSeq(furnitureSeq);
            //String userName = userService.findUserNameBySeq(userSeq);

            request.setAttribute("furnitureDTO", furnitureDTO);

//            request.setAttribute("imgList",imgList);
//            request.setAttribute("imgDetailList",imgDetailList);
//
//            request.setAttribute("reviewList",reviewList);
//            request.setAttribute("userName",userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("furniture.jsp");
    }
    
    public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	List<FurnitureDTO> list = furnitureService.selectAll();
    	
    	 request.setAttribute("list", list);
    	
    	return new ModelAndView("admin/adminCharts.jsp");
    }
    
    /*
     * 상품 전체보기 select문
     * */
    public ModelAndView selectFurnitureList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	
    	List<FurnitureDTO> list = furnitureService.selectFurnitureList();
    	System.out.println(list);
    	 request.setAttribute("list", list);
    	
    	return new ModelAndView("shop.jsp");
    }
    
}

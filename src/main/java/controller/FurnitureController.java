package controller;

import dto.FurnitureDTO;
import dto.ImgDTO;
import dto.ReviewDTO;
import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FurnitureController implements Controller {
    FurnitureService furnitureService = new FurnitureServiceImpl();
    ImgService imgService = new ImgServiceImpl();

    ReviewService reviewService = new ReviewServiceImpl();
    UserService userService = new UserServiceImpl();
    QnAService qnaService = new QnAServiceImpl();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public FurnitureController() throws IOException {}

    /*
    상품 상세 조회 페이지
     */
    public ModelAndView furnitureInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        System.out.println("FurnitureController productInfo");
        
        String furnitureName = request.getParameter("furnitureName");

    
            FurnitureDTO furnitureDTO = furnitureService.selectFurnitureName(furnitureName);
            // 상세페이지 설명 사진 가져오기
            furnitureDTO.setImgDetailList(imgService.selectImgDetail(furnitureDTO));

            // 상세페이지 슬라이드 사진 가져오기
            furnitureDTO.setImgList(imgService.selectImg(furnitureDTO));
            
            // 상세페이지 색상 가져오기
            furnitureDTO.setColorList(furnitureService.selectColorList(furnitureName));
            
            // 상세페이지 사이즈 가져오기
            furnitureDTO.setSizeList(furnitureService.selectSizeList(furnitureName));
            
            // 상세페이지 가구에 대한 모든 리뷰 이미지 가져오기
            // 리뷰안에 리뷰상세이미지는 회원이 작성한 리뷰사진이다.
            int reviewSeq = furnitureService.findReviewSeqByfurnitureSeq(furnitureDTO.getFurnitureSeq());
            int furnitureSeq = furnitureDTO.getFurnitureSeq();
            
            furnitureDTO.setReviewList(reviewService.selectReviewUser(reviewSeq,furnitureSeq));
            
            // 상세페이지 QnA 가져오기
            furnitureDTO.setQnaList(qnaService.selectAll(furnitureSeq));
            
            request.setAttribute("furnitureDTO", furnitureDTO);
            


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
    
    /**
     * 상품 메인 페이지로 연결
     */
    public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	
		/*
		 * List<FurnitureDTO> list = furnitureService.selectFurnitureList();
		 * System.out.println(list); request.setAttribute("list", list);
		 */
    	return new ModelAndView("index.jsp");
    }
    /**
     * 장바구니 페이지로 연결
     */
    public ModelAndView cart(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	
		/*
		 * List<FurnitureDTO> list = furnitureService.selectFurnitureList();
		 * System.out.println(list); request.setAttribute("list", list);
		 */
    	return new ModelAndView("cart.jsp");
    }
    
}

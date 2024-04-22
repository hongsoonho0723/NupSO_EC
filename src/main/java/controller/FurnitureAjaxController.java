package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;

import dto.FurnitureDTO;
import dto.QnADTO;
import dto.ReviewDTO;
import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FurnitureService;
import service.FurnitureServiceImpl;
import service.QnAService;
import service.QnAServiceImpl;
import service.ReviewService;
import service.ReviewServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class FurnitureAjaxController implements RestController {

	FurnitureService furnitureService = new FurnitureServiceImpl();
	UserService userService = new UserServiceImpl();
	ReviewService reviewService = new ReviewServiceImpl();
	QnAService qnaService = new QnAServiceImpl();
	
	
	public List<FurnitureDTO> selectAll() throws SQLException, IOException {
		
		List<FurnitureDTO> furnitureList = furnitureService.selectAll();	
		return furnitureList;
		
	}
	
	//유저의 성별 검색
	public List<UsersDTO> selectGender() throws SQLException, IOException {
		List<UsersDTO> userGenderList = userService.selectGender();
		
		return userGenderList;
	}
	
	//유저의 나이대 검색
	public List<UsersDTO> selectAge() throws SQLException, IOException {
		List<UsersDTO> userAgeList = userService.selectAge();
		
		return userAgeList;
	}
	// 리뷰 많은순 검색
	public List<ReviewDTO> selectReviewCount()throws SQLException, IOException {
		List<ReviewDTO> ReviewCountList = reviewService.selectReviewCount();
		
		return ReviewCountList;
	}
	
	// 제품별 qna개수 검색
	public List<QnADTO> selectCount()throws SQLException, IOException {
		List<QnADTO> qnaCountList = qnaService.selectCount();
		return qnaCountList;
	}
	
	public void selectChartAll(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<FurnitureDTO> furnitureList = this.selectAll();
		List<UsersDTO> userGenderList = this.selectGender();
		List<UsersDTO> userAgeList = this.selectAge();
		List<ReviewDTO> reviewCountList = this.selectReviewCount();
		List<QnADTO> qnaCountList = this.selectCount();
		
		int maleCount = 0;
		int femaleCount = 0;
		for (UsersDTO user : userGenderList) {
			if(user.getGender().equals("M")) {
				maleCount++;
			}else {
				femaleCount++;
			}
		}
		int userCount = maleCount + femaleCount;
		
		map.put("furnitureList", furnitureList);
		map.put("maleCount", maleCount);
		map.put("femaleCount", femaleCount);
		map.put("userAgeList", userAgeList);
		map.put("reviewCountList", reviewCountList);
		map.put("userCount", userCount);
		map.put("qnaCountList", qnaCountList);
		
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		
	}
	
}

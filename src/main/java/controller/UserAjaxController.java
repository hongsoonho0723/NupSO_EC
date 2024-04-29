package controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

import dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserServiceImpl;

public class UserAjaxController implements RestController {

	UserService userService = new UserServiceImpl();
    
    
	/*
	 * 로그인
	 */

	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 두개의 전송되는 값을 받는다.
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		System.out.println("userId = " + userId);
		System.out.println("password = " + password);
		UsersDTO dbDTO = userService.login(new UsersDTO(userId, password));

		System.out.println("dbname=" + dbDTO.getName());
		System.out.println("dbDTO ==== " + dbDTO);
		// 로그인성공하면 세션에 정보를 저장 - ${loginUser} / ${loginName}
		HttpSession session = request.getSession();

		session.setAttribute("loginUser", dbDTO);

		session.setAttribute("userSeq", dbDTO.getUserSeq());
		session.setAttribute("userId", dbDTO.getUserId());
		

		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(dbDTO);
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}
	
	
	

	/**
	 * 아디중복체크
	 */

	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("idCheck controller");
		String userId = request.getParameter("userId");

		boolean result = userService.idCheck(userId);
		System.out.println("result = " + result);
		// false 사용가능 //true 중복
		PrintWriter out = response.getWriter();
		out.print(result);

	}

	/**
	 * 등록하기
	 */
	public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 입력된 출생년월일 (YYYYMMDD 형식)
		String birthDateStr = request.getParameter("jumin1");

		// 입력된 출생년월일을 파싱하여 LocalDate 객체로 변환
		LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.BASIC_ISO_DATE);

		// 현재 날짜
		LocalDate currentDate = LocalDate.now();

		// 나이 계산
		Period period = Period.between(birthDate, currentDate);
		int age = period.getYears();

		// 성별 계산
		String gender = request.getParameter("jumin2");

		if (gender.equals("1") || gender.equals("3")) {
			gender = "M";

		} else
			gender = "F";

		UsersDTO usersDTO = new UsersDTO(request.getParameter("userId"), request.getParameter("password1"),
				request.getParameter("name"), request.getParameter("addr"), age, gender, request.getParameter("phone"));

		int result = userService.insert(usersDTO);

		Gson gson = new Gson();
		String jsonArr = gson.toJson(result);
		PrintWriter out = response.getWriter();
		out.print(jsonArr);

	}
	
	//유저 seq로 유저 정보 조회
	public void selectUserBySeq(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int userSeq = (int) session.getAttribute("userSeq");
		UsersDTO usersDTO = userService.findUserBySeq(userSeq);
		System.out.println("UserAjaxController.selectUserBySeq");
		System.out.println("userSeq = " + userSeq);
		System.out.println("usersDTO = " + usersDTO);
		Gson gson = new Gson();
		String jsonArr = gson.toJson(usersDTO);
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}
	
	//유저 seq로 유저 정보 업데이트
	public void updateUserBySeq(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        HttpSession session = request.getSession();
        int userSeq = (int) session.getAttribute("userSeq");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String addr = request.getParameter("addr");
        
        UsersDTO usersDTO = new UsersDTO(userSeq, name, password, addr, age, phone);
        
        System.out.println("UserAjaxController.updateUserBySeq 실행. 업데이트할 정보 " + usersDTO);
        
        String result = userService.updateUserBySeq(usersDTO);
        
        PrintWriter out = response.getWriter();
        out.print(result);
        
	}
}

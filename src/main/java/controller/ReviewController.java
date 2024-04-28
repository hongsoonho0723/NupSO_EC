package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.FurnitureDTO;
import dto.ReviewDTO;
import dto.UsersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.FurnitureService;
import service.FurnitureServiceImpl;
import service.ReviewService;
import service.ReviewServiceImpl;

public class ReviewController implements Controller {
	ReviewService service = new ReviewServiceImpl();
	FurnitureService furnitureService = new FurnitureServiceImpl();
	
	
	
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	List<ReviewDTO> list = service.selectAll(); 	
    	request.setAttribute("list", list);
		return new ModelAndView("admin/adminReview.jsp");
    }
    
    public ModelAndView selectAllByUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	HttpSession session = request.getSession();
    	UsersDTO user = (UsersDTO)session.getAttribute("loginUser");
    	int userSeq = user.getUserSeq();
    	List<ReviewDTO> list = service.selectAllByUser(userSeq);
    	
    	request.setAttribute("list", list);
		return new ModelAndView("myPageReview.jsp");
    }
    
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    	int reviewSeq = Integer.parseInt(request.getParameter("reviewSeq"));
    	String reqUrl = request.getParameter("mypage");
    	
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html;charset=utf-8");
    	
    	service.delete(reviewSeq);
    	
    	request.setAttribute("message", "삭제에 성공했습니다.");
    	
    	if(reqUrl.equals("mypage")) {
    		return this.selectAllByUser(request, response);
    	}else {
        	List<ReviewDTO> list = service.selectAll(); 	
        	request.setAttribute("list", list);
    		return new ModelAndView("admin/adminReview.jsp");
    	}
    }
    
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
    	HttpSession session = request.getSession();
    	UsersDTO user = (UsersDTO)session.getAttribute("loginUser");
    	int furnitureSeq = Integer.parseInt(request.getParameter("furnitureSeq"));
    	String review = request.getParameter("review");
    	int score = Integer.parseInt(request.getParameter("score"));
    	String imgType[] = {".jpg",".png",".svg"};
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html;charset=utf-8");
    	String imgName = null;
    	String Type = null;
    	boolean state = false;
    	
    	if(containsProfanity(review)) { // list의 욕설이 있을 경우
    		out.println("<script>");
	        out.println("alert('리뷰에 욕설이 포함되어 있습니다. 다시 작성해주세요.')");
	        out.println("history.back();");
	        out.println("</script>");
    	    return null; // 욕설이 포함된 리뷰는 거부하고 메서드 종료
    	}
    	
    	OrderController con = new OrderController();
    	ModelAndView mv = con.selectOrderAll(request, response);
    	
    	Part part = request.getPart("img");
    	if(part!=null) {
			imgName = this.getFilename(part);
			
			String saveDir = request.getServletContext().getRealPath("/reviewImg");
			
			if (imgName!=null && !imgName.equals("")) {
				for(int i=0; i<imgType.length ; i++) {
					if(imgName.endsWith(imgType[i])) {
						Type = imgType[i];
						state = true;
						part.write( saveDir + "/"+ imgName);//리뷰이미지폴더에 사진 저장
					}
				}
	        }
		}
    	
    	if(!state) {
    		out.println("<script>");
    		out.println("alert('사진 형식을 다시 확인해주세요(.jpg .png .svg)')");
    		out.println("history.back();");
    		out.println("</script>");
    	}else {
    		
    		int userSeq = user.getUserSeq();
    		service.insert(furnitureSeq,userSeq,review,score,imgName,Type);
    		
    		request.setAttribute("message", "등록에 성공했습니다.");
    		
        	return mv;
    	}
		return null;
    	
    }
    
    /**
	 * 전송된 파일정보에서 파일이름만 추출해 내는 과정 
	 * */
	private String getFilename(Part part) {
        String headerContent = part.getHeader("content-disposition");
        
        //contentDisp의 결과 form-data; name="fileName"; filename="추가한 파일 이름"
        System.out.println(headerContent);
        
        String[] split = headerContent.split(";");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            if (temp.trim().startsWith("filename")) {
            	System.out.println("temp = " + temp);
            	System.out.println("temp.indexOf(=) = " + temp.indexOf("=") );
            	
                return temp.substring( temp.indexOf("=") + 2 ,  temp.length() - 1);
            }
        }
        return null;
    }
	
	
	// 욕설 필터링 메서드
	public boolean containsProfanity(String review) {
	    String[] profanities = {"ㅅㅂ", "씨발", "씨바","ㅆㅂ"}; // 욕설 단어 리스트

	    for (String profanity : profanities) {
	        Pattern pattern = Pattern.compile("\\b" + profanity + "\\b", Pattern.CASE_INSENSITIVE); // 대소문자 구분x 설정
	        Matcher matcher = pattern.matcher(review);
	        if (matcher.find()) {
	            return true;
	        }
	    }
	    return false;
	}
    
}

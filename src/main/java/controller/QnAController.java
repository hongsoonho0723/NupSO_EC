package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dto.FurnitureDTO;
import dto.QnADTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FurnitureService;
import service.FurnitureServiceImpl;
import service.QnAService;
import service.QnAServiceImpl;

public class QnAController implements Controller {
	QnAService service = new QnAServiceImpl();
	FurnitureService furnitureService = new FurnitureServiceImpl();
	

	public QnAController() {}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;

	}
	
	public ModelAndView selectAll (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<QnADTO> list = service.selectAll();
		request.setAttribute("list", list);
		return new ModelAndView("admin/adminQnA.jsp");
	}
	
	public ModelAndView  update (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int qnaSeq = Integer.parseInt(request.getParameter("questionSeq"));
		String answer = request.getParameter("answer");
		String state = request.getParameter("state");

		
		QnADTO qna = service.select(qnaSeq);
		
		qna.setAnswer(answer);
		qna.setState(state);
		service.update(qna);
		
		List<QnADTO> list = service.selectAll();
		request.setAttribute("list", list);
		
		return new ModelAndView("admin/adminQnA.jsp");
	}
	
	public ModelAndView delete (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int qnaSeq = Integer.parseInt(request.getParameter("questionSeq"));
		
		service.delete(qnaSeq);
		
		List<QnADTO> list = service.selectAll();
		request.setAttribute("list", list);
		
		return new ModelAndView("admin/adminQnA.jsp"); 
	}
	
	public ModelAndView  insert (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int furnitureSeq = Integer.parseInt(request.getParameter("furnitureSeq"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String question = request.getParameter("question");
		FurnitureDTO furniture = furnitureService.selectFurnitureByFurnitureSeq(furnitureSeq);
		
		System.out.println("furnitureSeq "+ furnitureSeq);
		System.out.println("name "+ name);
		System.out.println("password "+ password);
		System.out.println("question "+ question);
		
		service.insert(furnitureSeq, question, name, password);
		
		FurnitureController furnitureCon = new FurnitureController();
		ModelAndView modelAndView = furnitureCon.furnitureInfo(request, response, furniture.getFurnitureName());
		
		return modelAndView;
	}

}

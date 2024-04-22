package controller;

import java.sql.SQLException;
import java.util.List;

import dto.QnADTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.QnAService;
import service.QnAServiceImpl;

public class QnAController implements Controller {
	QnAService service = new QnAServiceImpl();
	

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

}

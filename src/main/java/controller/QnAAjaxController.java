package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.QnAService;
import service.QnAServiceImpl;

public class QnAAjaxController implements RestController {
	QnAService qnaService = new QnAServiceImpl();
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int qnaSeq = Integer.parseInt(request.getParameter("qnaSeq"));
		String password = request.getParameter("password");
		
		qnaService.delete(qnaSeq);
		PrintWriter out = response.getWriter();
		out.print("");
		
	}
	
	
}

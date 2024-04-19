package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import dto.QnADTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.QnAService;
import service.QnAServiceImpl;

public class QnAController implements RestController {
	QnAService service = new QnAServiceImpl();
	
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("QnA Controller selectAll");
		
		List<QnADTO> list = service.selectAll();
		
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		out.print(gson.toJson(list));
		
	}
}

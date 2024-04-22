package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dto.OrderDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderService;
import service.OrderServiceImpl;

public class OrderAjaxController implements RestController {
	OrderService orderService = new OrderServiceImpl();
	
	public void selectChartAll(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {

	}
	
}

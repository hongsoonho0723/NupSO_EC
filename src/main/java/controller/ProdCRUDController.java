package controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dto.FurnitureDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProdCRUDService;
import service.ProdCRUDServiceImpl;

public class ProdCRUDController implements Controller{
	ProdCRUDService service = new ProdCRUDServiceImpl();
	
	public ProdCRUDController() {}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		return null;
	}
	
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	    String furnitureNumber = request.getParameter("furnitureNumber");
	    String furnitureName = request.getParameter("furnitureName");
	    String furnitureDescription = request.getParameter("furnitureDescription");
	    String furnitureImgSrc = request.getParameter("furnitureImgSrc");
	    int price = Integer.parseInt(request.getParameter("price"));
	    int stock = Integer.parseInt(request.getParameter("stock"));
	    String category = request.getParameter("category");
	    String texture = request.getParameter("texture");
	    
	

	    // 새로운 FurnitureDTO 객체 생성
	    FurnitureDTO newFurniture = new FurnitureDTO(furnitureNumber, furnitureName, furnitureDescription, price, stock, category, texture, furnitureImgSrc);
	    System.out.println(newFurniture);
	    // 서비스를 통해 상품 추가
	    service.create(newFurniture);

	    // 추가된 상품을 포함하여 모든 상품 리스트를 다시 불러옴
	    List<FurnitureDTO> list = service.selectAll();
	    request.setAttribute("list", list);

	    return new ModelAndView("admin/adminCRUD.jsp");
	}
	
	public ModelAndView selectAll (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// System.out.println("controller 오니?");
		List<FurnitureDTO> list = service.selectAll();
		/*
		 * for (FurnitureDTO furnitureDTO : list) { System.out.println(furnitureDTO); }
		 */
		request.setAttribute("list", list);
		return new ModelAndView("admin/adminCRUD.jsp");
	}
	
	public ModelAndView delete (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int furnitureSeq = Integer.parseInt(request.getParameter("furnitureSeq"));
		
		service.delete(furnitureSeq);
		
		List<FurnitureDTO> list = service.selectAll();
		request.setAttribute("list", list);
		
		return new ModelAndView("admin/adminCRUD.jsp");
	}
	
	public ModelAndView update (HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int furnitureSeq = Integer.parseInt(request.getParameter("furnitureSeq"));
		String furnitureNumber = request.getParameter("furnitureNumber");
		String furnitureName = request.getParameter("furnitureName");
		String furnitureDescription = request.getParameter("furnitureDescription");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String category = request.getParameter("category");
		int flag = Integer.parseInt(request.getParameter("flag"));
		String furnitureImgSrc = request.getParameter("furnitureImgSrc");
		
		
		List<FurnitureDTO> list = service.selectAll();
		for (FurnitureDTO furniture : list) {
			if(furniture.getFurnitureSeq() == furnitureSeq) {
				furniture.setFurnitureNumber(furnitureNumber);
				furniture.setFurnitureName(furnitureName);
				furniture.setFurnitureDescription(furnitureDescription);
				furniture.setPrice(price);
				furniture.setStock(stock);
				furniture.setCategory(category);
				furniture.setFlag(flag);
				furniture.setFurnitureImgSrc(furnitureImgSrc);
			}
		}
		
		request.setAttribute("list", list);
		
		System.out.println(list);
		
		return new ModelAndView("admin/adminCRUD.jsp");
	}
}

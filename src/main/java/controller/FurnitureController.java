package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FurnitureController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public FurnitureController() throws IOException {}

    /*
    상품 상세 조회 페이지
     */
    public ModelAndView furnitureInfo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("FurnitureController productInfo");
        return null;
    }
}

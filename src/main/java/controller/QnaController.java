package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.QnaService;
import service.QnaServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.sql.SQLException;

public class QnaController implements Controller {
    QnaService qnaService = new QnaServiceImpl();
    UserService userService = new UserServiceImpl();

    public QnaController() {

    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
        try{
            qnaService.insertQues(Integer.parseInt(request.getParameter("furnitureSeq")),request.getParameter("question"),
                    0,request.getParameter("name"),request.getParameter("password"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("");
    }

}

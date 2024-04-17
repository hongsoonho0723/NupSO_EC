package service;

import dao.QnaDAO;
import dao.QnaDAOImpl;

import java.sql.SQLException;

public class QnaServiceImpl implements QnaService {
    private QnaDAO qnaDAO = new QnaDAOImpl();

    @Override
    public void insertQues(int furnitureSeq, String question, int state, String name, String password) throws SQLException {
        int result = qnaDAO.insertQues(furnitureSeq, question, state, name, password);
        if (result == 0) throw new SQLException("문의 등록을 실패했습니다.");
    }

    @Override
    public void deleteQna(int qnaSeq) throws SQLException {
        int result = qnaDAO.deleteQues(qnaSeq);
        if (result == 0) throw new SQLException("문의 삭제에 실패했습니다.");
    }
}

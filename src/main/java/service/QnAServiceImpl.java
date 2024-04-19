package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.QnADAO;
import dao.QnADAOImpl;
import dto.QnADTO;

public class QnAServiceImpl implements QnAService {
    private QnADAO qnaDAO = new QnADAOImpl();

    @Override
    public void insert(int furnitureSeq, String question, int state, String name, String password) throws SQLException {
        int result = qnaDAO.insert(furnitureSeq, question, state, name, password);
        if (result == 0) throw new SQLException("문의 등록을 실패했습니다.");
    }

    @Override
    public void delete(int qnaSeq) throws SQLException {
        int result = qnaDAO.delete(qnaSeq);
        if (result == 0) throw new SQLException("문의 삭제에 실패했습니다.");
    }

	@Override
	public List<QnADTO> selectAll() throws SQLException {
		List<QnADTO> list = qnaDAO.selectAll();
		return list;
	}
    
    
    
}

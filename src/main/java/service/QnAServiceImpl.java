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
    public void insert(int furnitureSeq, String question, String name, String password) throws SQLException {
    	System.out.println("furnitureSeq "+ furnitureSeq);
		System.out.println("name "+ name);
		System.out.println("password "+ password);
		System.out.println("question "+ question);
    	int result = qnaDAO.insert(furnitureSeq, question, name, password);
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
    
	@Override
	public int update(QnADTO qna) throws SQLException {
		int result = qnaDAO.update(qna);
		if(result == 0 ) throw new SQLException("문의 수정에 실패했습니다.");
		
		return result;
	}

	@Override
	public QnADTO select(int qnaSeq) throws SQLException {
		QnADTO qna = qnaDAO.select(qnaSeq);
		if(qna==null) throw new SQLException("문의 찾는데 실패했습니다.");
		
		return qna;
	}

	@Override
	public List<QnADTO> selectCount() throws SQLException {
		List<QnADTO> list = qnaDAO.selectCount();
		return list;
	}

	@Override
	public List<QnADTO> selectAll(int furnitureSeq) throws SQLException {
		List<QnADTO> list = qnaDAO.selectAll(furnitureSeq);
		return list;
	}
    
	
	
    
}

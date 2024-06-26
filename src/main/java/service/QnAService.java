package service;

import java.sql.SQLException;
import java.util.List;

import dto.QnADTO;

public interface QnAService {
    void insert(int furnitureSeq, String question,String name, String password) throws SQLException;

    void delete(int qnaSeq) throws SQLException;
    
    List<QnADTO> selectAll() throws SQLException;
    
    int update(QnADTO qna) throws SQLException;
    
    QnADTO select(int qnaSeq) throws SQLException;

	List<QnADTO> selectCount()throws SQLException;

	List<QnADTO> selectAll(int furnitureSeq) throws SQLException;

}

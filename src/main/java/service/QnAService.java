package service;

import java.sql.SQLException;
import java.util.List;

import dto.QnADTO;

public interface QnAService {
    void insert(int furnitureSeq, String question,int state,String name, String password) throws SQLException;

    void delete(int qnaSeq) throws SQLException;
    
    List<QnADTO> selectAll() throws SQLException;
}

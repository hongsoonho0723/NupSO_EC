package service;

import java.sql.SQLException;

public interface QnaService {
    void insertQues(int furnitureSeq, String question,int state,String name, String password) throws SQLException;

    void deleteQna(int qnaSeq) throws SQLException;
}

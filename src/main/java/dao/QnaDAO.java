package dao;

import java.sql.SQLException;

public interface QnaDAO {
    /*
    문의 등록
     */
    int insertQues(int furnitureSeq, String question,int state,String name, String password) throws SQLException;

    /*
    문의 삭제
     */
    int deleteQues(int qnaSeq) throws SQLException;
}

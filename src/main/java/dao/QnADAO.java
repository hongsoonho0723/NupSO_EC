package dao;

import dto.QnADTO;

import java.sql.SQLException;
import java.util.List;

public interface QnADAO {
    /*
    문의 등록
     */
    int insertQues(int furnitureSeq, String question,int state,String name, String password) throws SQLException;

    /*
    문의 삭제
     */
    int deleteQues(int qnaSeq) throws SQLException;

    /*
    문의 번호로 조회
     */
    String getPwd(int qnaSeq) throws SQLException;
    
   // List<QnADTO>
}

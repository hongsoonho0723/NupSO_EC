package dao;

import dto.QnADTO;

import java.sql.SQLException;
import java.util.List;

public interface QnADAO {
    /*
    문의 등록
     */
    int insert(int furnitureSeq, String question,String name, String password) throws SQLException;

    /*
    문의 삭제
     */
    int delete(int qnaSeq) throws SQLException;

    /*
    문의 번호로 조회
     */
    String getPwd(int qnaSeq) throws SQLException;
    

    List<QnADTO> selectAll() throws SQLException;
    
    int update(QnADTO qna) throws SQLException;

    QnADTO select(int qnaSeq) throws SQLException;

	List<QnADTO> selectCount() throws SQLException;

	List<QnADTO> selectAll(int furnitureSeq) throws SQLException;


}

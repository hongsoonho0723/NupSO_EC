package dao;

import java.sql.SQLException;

public interface UserDAO {
    /*
    사용자 고유번호로 사용자 이름 찾기
     */
    String findUserNameBySeq(int userSeq) throws SQLException;

    /*
    사용자 아이디로 사용자 고유번호 찾기
     */
    int findUserSeqById(String userId) throws SQLException;
}

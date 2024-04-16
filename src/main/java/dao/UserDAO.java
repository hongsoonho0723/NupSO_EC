package dao;

import java.sql.SQLException;

public interface UserDAO {
    /*
    사용자 고유번호로 사용자 이름 찾기
     */
    String findUserNameBySeq(int userSeq) throws SQLException;
}

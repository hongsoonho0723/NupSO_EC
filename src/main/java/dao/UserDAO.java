package dao;

import java.sql.SQLException;
import java.util.List;

import dto.UsersDTO;

public interface UserDAO {
    /*
    사용자 고유번호로 사용자 이름 찾기
     */
    String findUserNameBySeq(int userSeq) throws SQLException;

    /*
    사용자 아이디로 사용자 고유번호 찾기
     */
    int findUserSeqById(String userId) throws SQLException;

	List<UsersDTO> selectGender() throws SQLException;

	List<UsersDTO> selectAge() throws SQLException;
}

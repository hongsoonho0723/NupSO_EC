package service;

import java.sql.SQLException;
import java.util.List;

import dto.UsersDTO;

public interface UserService {
    String findUserNameBySeq(int userSeq) throws SQLException;

    int findUserSeqById(String userId) throws SQLException;

	List<UsersDTO> selectGender() throws SQLException;

	List<UsersDTO> selectAge() throws SQLException;
}

package service;

import java.sql.SQLException;
import java.util.List;

import dto.UsersDTO;

import dto.UsersDTO;
import exception.AuthenticationException;

public interface UserService {
    String findUserNameBySeq(int userSeq) throws SQLException;

    int findUserSeqById(String userId) throws SQLException;

    UsersDTO findUserById(String userId) throws SQLException;
    
    UsersDTO login(UsersDTO usersDTO) throws SQLException;

    boolean idCheck(String userIds) throws SQLException;
    
    
    int insert(UsersDTO usersDTO) throws SQLException;

	List<UsersDTO> selectGender() throws SQLException;

	List<UsersDTO> selectAge() throws SQLException;

}

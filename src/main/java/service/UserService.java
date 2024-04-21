package service;

import java.sql.SQLException;

import dto.UsersDTO;
import exception.AuthenticationException;

public interface UserService {
    String findUserNameBySeq(int userSeq) throws SQLException;

    int findUserSeqById(String userId) throws SQLException;
    
    UsersDTO login(UsersDTO usersDTO) throws SQLException;

    boolean idCheck(String userIds) throws SQLException;
    
    boolean passwordCheck(String password) throws SQLException;
    
    int insert(UsersDTO usersDTO) throws SQLException;

}

package service;

import java.sql.SQLException;

import dto.UsersDTO;

public interface UserService {
    String findUserNameBySeq(int userSeq) throws SQLException;

    int findUserSeqById(String userId) throws SQLException;
    
    UsersDTO login(UsersDTO usersDTO) throws SQLException;

    
    
    
}

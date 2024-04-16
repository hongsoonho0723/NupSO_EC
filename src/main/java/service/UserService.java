package service;

import java.sql.SQLException;

public interface UserService {
    String findUserNameBySeq(int userSeq) throws SQLException;
}

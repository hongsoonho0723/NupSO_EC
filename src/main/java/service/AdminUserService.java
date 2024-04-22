package service;

import java.sql.SQLException;
import java.util.List;
import dto.UsersDTO;

public interface AdminUserService {
    List<UsersDTO> selectAllUser(int furnitureSeq) throws SQLException;

    int findUserSeq(int reviewSeq) throws SQLException;
    
    List<UsersDTO> selectAll() throws SQLException;

	int delete(int reviewSeq) throws SQLException;

	List<UsersDTO> selectReviewCount() throws SQLException;

}

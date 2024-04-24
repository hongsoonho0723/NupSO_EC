package service;

import java.sql.SQLException;
import java.util.List;

import dao.AdminUserDAO;
import dao.AdminUserDAOImpl;
import dto.UsersDTO;

public class AdminUserServiceImpl implements AdminUserService {
	
	private AdminUserDAO adminUserDAO = new AdminUserDAOImpl();
	
	@Override
	public List<UsersDTO> selectUser() throws SQLException {
		List<UsersDTO> list = adminUserDAO.selectUser();
		return list;
	}

	@Override
	public List<UsersDTO> findUserSeqByState(String userState) throws SQLException {
		List<UsersDTO> list = adminUserDAO.findUserSeqByState(userState);
		return list;
	}

	@Override
	public int delete(int userSeq) throws SQLException {
		int result = adminUserDAO.delete(userSeq);
		if (result == 0) throw new SQLException("회원정보 삭제 실패하였습니다.");
		return result;
		
		
	}

}

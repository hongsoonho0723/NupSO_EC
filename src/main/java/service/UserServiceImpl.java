package service;

import java.sql.SQLException;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.UsersDTO;
import exception.AuthenticationException;
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public String findUserNameBySeq(int userSeq) throws SQLException {
        String name = userDAO.findUserNameBySeq(userSeq);
        if (name == null) throw new SQLException("해당 리뷰를 작성한 회원의 이름을 찾지 못했습니다.");
        return name;
    }

    @Override
    public int findUserSeqById(String userId) throws SQLException {
        int userSeq = userDAO.findUserSeqById(userId);
        if (userSeq == 0) throw new SQLException("사용자를 찾을 수 없습니다.");
        return userSeq;
    }

	@Override
	public UsersDTO login(UsersDTO usersDTO) throws SQLException {
	
		UsersDTO dbDTO = userDAO.login(usersDTO);
	
		/*
		 * if(dbDTO == null) { throw new AuthenticationException("정보를 다시 확인해주세요."); }
		 */
		return dbDTO;
	}

	@Override
	public boolean idCheck(String userId) throws SQLException {

		boolean result = userDAO.idCheck(userId);
		
		
		return result;
	}

	@Override
	public int insert(UsersDTO usersDTO) throws SQLException {

		
		int result = userDAO.insert(usersDTO);
		
		return result;
	}

	@Override
	public boolean passwordCheck(String password) throws SQLException {

		boolean result = userDAO.passwordCheck(password);
		
		return result;
	}
	
	
	
	
	
	
	
}

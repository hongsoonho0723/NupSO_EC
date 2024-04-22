package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.UsersDTO;

import java.sql.SQLException;
import java.util.List;

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
	public List<UsersDTO> selectGender() throws SQLException {
		List<UsersDTO> list = userDAO.selectGender();
		return list;
	}

	@Override
	public List<UsersDTO> selectAge() throws SQLException {
		List<UsersDTO> list = userDAO.selectAge();
		return list;
	}
    
	
    
}

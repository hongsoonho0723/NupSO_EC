package service;

import dao.UserDAO;
import dao.UserDAOImpl;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public String findUserNameBySeq(int userSeq) throws SQLException {
        String name = userDAO.findUserNameBySeq(userSeq);
        if (name == null) throw new SQLException("해당 리뷰를 작성한 회원의 이름을 찾지 못했습니다.");
        return name;
    }
}

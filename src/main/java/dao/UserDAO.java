package dao;

import java.sql.SQLException;
import java.util.List;

import dto.UsersDTO;

import dto.UsersDTO;

public interface UserDAO {
    /*
    사용자 고유번호로 사용자 이름 찾기
     */
    String findUserNameBySeq(int userSeq) throws SQLException;

    /*
    사용자 아이디로 사용자 고유번호 찾기
     */
    int findUserSeqById(String userId) throws SQLException;
    /*
     아이디 비번으로 로그인
     */
    UsersDTO login(UsersDTO usersDTO) throws SQLException;
    
    /*
     회원가입 아이디 중복체크 
     */
    
    boolean idCheck(String userId) throws SQLException;
    
   
    /*
     회원등록
      */
    int insert (UsersDTO usersDTO) throws SQLException;
    
	List<UsersDTO> selectGender() throws SQLException;

	List<UsersDTO> selectAge() throws SQLException;

	UsersDTO findUserById(String userId) throws SQLException;

}

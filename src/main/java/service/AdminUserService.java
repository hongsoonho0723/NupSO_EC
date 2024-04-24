package service;

import java.sql.SQLException;

import java.util.List;
import dto.UsersDTO;

public interface AdminUserService {
	/*
    사용자 전체 조회
     */
    List<UsersDTO> selectUser() throws SQLException;

    /*
    UserState로 사용자 고유번호 찾기
     */
    List<UsersDTO> findUserSeqByState(String userState) throws SQLException;
    
    /*
    사용자 고유번호로 사용자 삭제
     */
    int delete(int userSeq) throws SQLException;

}

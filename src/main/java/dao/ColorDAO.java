package dao;

import java.sql.SQLException;
import java.util.List;

import dto.ColorDTO;

public interface ColorDAO {
	/*존재하는 모든 컬러 객체를 불러오기*/
	public List<ColorDTO> selectAllColor() throws SQLException;

}

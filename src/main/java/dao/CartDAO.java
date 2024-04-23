package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sound.midi.Sequence;

import dto.CartDTO;

public interface CartDAO {

	List<CartDTO> selectAll() throws SQLException;
	
}

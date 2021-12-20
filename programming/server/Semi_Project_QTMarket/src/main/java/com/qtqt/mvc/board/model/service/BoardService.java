package com.qtqt.mvc.board.model.service;

import java.sql.Connection;

import com.qtqt.mvc.board.model.dao.BoardDao;
import static com.qtqt.mvc.common.jdbc.JDBCTemplate.*;

public class BoardService {
	
	private BoardDao dao = new BoardDao();

	public int getBoardCount() {
		int count = 0; 
		
		Connection connection = getConnection();
		
		count = dao.getBoardCount(connection);
		
		close(connection);
		
		return count;
	}

}
package com.qtqt.mvc.member.model.service;

import static com.qtqt.mvc.common.jdbc.JDBCTemplate.close;
import static com.qtqt.mvc.common.jdbc.JDBCTemplate.commit;
import static com.qtqt.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.qtqt.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.qtqt.mvc.member.model.dao.MemberDao;
import com.qtqt.mvc.member.model.vo.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();

	public Member login(String id, String password) {
		Connection connection = getConnection();
		
		Member member = dao.findMemberById(connection, id);

		close(connection);
		
		if (member != null && member.getPassword().equals(password))
			return member;
		else {
			return null;
		}
	}

	public int save(Member member) {
		int result = 0;
		Connection connection = getConnection();
		
		result = dao.insertMember(connection, member);
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);	
		}
				
		close(connection);
		
		return result;
	}
	
	public boolean isDuplicateID(String id) {

		return this.findMemberById(id) != null;
	}

	public Member findMemberById(String id) {
		Connection connection = getConnection();
		Member member = dao.findMemberById(connection, id);

		close(connection);

		return member;
	}

}

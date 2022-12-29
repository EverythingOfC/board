package org.comstudy.saram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.comstudy.saram.dbcp.JdbcUtil;

public class MemberDAO {

	private static MemberDAO memberDAO = new MemberDAO();
	final String login = "select * from member where m_id = ? and m_pw = ?";	// 로그인
	final String signUp = "insert into member values(?,?,0,?)";	// 회원가입
	final String update = "update member set m_pw = ?, m_name=? where m_id = ?";
	final String delete = "delete from member where m_id = ? ";
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;

	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return memberDAO;
	}
	
	public MemberDTO memberLogin(MemberDTO dto) {
			
		MemberDTO member = new MemberDTO();
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(login);
			pstmt.setString(1, dto.getM_id());
			pstmt.setString(2, dto.getM_pw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setM_id(rs.getString("m_id"));
				member.setM_pw(rs.getString("m_pw"));
				member.setReadCount(rs.getInt("readcount"));
				member.setM_name(rs.getString("m_name"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return member;
	}
	
	public void insert(MemberDTO dto) {
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(login);
			pstmt.setString(1, dto.getM_id());
			pstmt.setString(2, dto.getM_pw());
			pstmt.setString(3, dto.getM_name());
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
	
public void update(MemberDTO dto) {
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(login);
			pstmt.setString(1, dto.getM_pw());
			pstmt.setString(2, dto.getM_name());
			pstmt.setString(3, dto.getM_id());
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
public void delete(MemberDTO dto) {
	
	try {
		conn = JdbcUtil.getConnection();
		pstmt = conn.prepareStatement(login);
		pstmt.setString(1, dto.getM_id());
		
		int cnt = pstmt.executeUpdate();
		if(cnt > 0) {
			conn.commit();
		}else {
			conn.rollback();
		}
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		JdbcUtil.close(conn);
		JdbcUtil.close(pstmt);
	}
}
	
}

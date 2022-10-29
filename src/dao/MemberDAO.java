package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constant.Role;
import vo.MemberVO;

public class MemberDAO {
	
	private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbId = "cafe";
	private String dbPw = "1234";
	
	// member 추가
	public void add(MemberVO vo) {
		String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getRole().toString());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// id로 id만 조회
	public MemberVO getIdById(String id) {
		String sql = "SELECT id FROM member WHERE id = ?";
		
		MemberVO member = new MemberVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	// id, pw로 member 조회
	public MemberVO getMemberByIdPw(MemberVO vo) {
		String sql = "SELECT * FROM member WHERE id = ? and pw = ?";
		
		MemberVO member = new MemberVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setTel(rs.getString("tel"));
				if(rs.getString("rol").equals(Role.STAFF.name())) {
					member.setRole(Role.STAFF);
				} else {
					member.setRole(Role.CLIENT);
				}
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
}

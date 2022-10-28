package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;

public class MemberDAO {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";	
	
	public MemberVO getMemberId(String memberId) {
		String sql = "SELECT id FROM member WHERE id = ?";
		
		MemberVO vo = new MemberVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
			} else {
				vo.setId("null");
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	public void add(MemberVO member) {
		String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getRole().toString());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

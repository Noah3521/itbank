package member;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DAO;

public class MemberDAO extends DAO{
	
	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static DAO getInstance() {
		return instance;
	}
	
	public String getTest() {
		String banner = null;
		String sql = "select banner from v$version";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				banner = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return banner;
	}
	
	public MemberDTO mapping(ResultSet rs) throws SQLException {
		MemberDTO dto = new MemberDTO();
		dto.setUserid(rs.getString("userid"));
		dto.setUserpw(rs.getString("userpw"));
		dto.setUsername(rs.getString("username"));
		dto.setEmail(rs.getString("email"));
		dto.setBirth(rs.getDate("birth"));
		return dto;
	}
	
	public MemberDTO login(MemberDTO user) {
		MemberDTO login = null;
		String sql = "select * from member where userid=? and userpw=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUserpw());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				login = mapping(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return login;
	}
}

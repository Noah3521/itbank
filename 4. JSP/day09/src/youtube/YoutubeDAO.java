package youtube;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class YoutubeDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/* 싱글톤 */
	private DataSource ds;
	private Context init;
	private static YoutubeDAO instance;
	
	public static YoutubeDAO getInstance() {
		if(instance == null) {
			instance = new YoutubeDAO();
		}
		return instance;
	}
	
	/* 생성자 */
	private YoutubeDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println("datasource 불러오기 실패 : " + e);
		}
	}
	

	
	public String test() {
		String sql = "select banner from v$version";
		String ver = "실패";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareCall(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ver = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e) {}
		}
		
		return ver;
	}
	
	/* 전체목록 */
	public ArrayList<YoutubeDTO> selectList() {
		ArrayList<YoutubeDTO> list = new ArrayList<>();
		String sql = "select * from youtube order by idx";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareCall(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				YoutubeDTO dto = new YoutubeDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setChannel(rs.getString("channel"));
				dto.setViewCount(rs.getInt("viewCount"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setMovieTag(rs.getString("movieTag"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e) {}
		}
		
		return list;
	}
}

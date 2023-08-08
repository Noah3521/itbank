package ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MelonDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<MelonDTO> list = new ArrayList<>();
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	
	public MelonDAO() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MelonDTO> selectList() {
		String sql = "select * from melon order by ranking";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MelonDTO dto = new MelonDTO();
				dto.setRanking(rs.getInt("ranking"));
				dto.setTitle(rs.getString("title"));
				dto.setArtist(rs.getString("artist"));
				dto.setAlbum(rs.getString("album"));
				dto.setLikeCount(rs.getInt("likeCount"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {}
		}
		return list;
	}
}

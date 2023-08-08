package ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class movieDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;	// stmt의 상속
	private ResultSet rs;
	private ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";

	public movieDAO() {
		try {
			Class.forName(driverClassName);
			
			
		} catch (Exception e) {
			System.out.println("클래스를 불러오지 못했습니다 : " + e);
		}
	}
	

	public ArrayList<MovieDTO>selectList() {
		
		String sql = "select * from movie order by movie_rank";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto.setMovie_rank(rs.getInt("movie_rank"));
				dto.setTitle(rs.getString("title"));
				dto.setOpenningDate(rs.getString("openningDate"));
				dto.setReserveRate(rs.getDouble("reserveRate"));
				dto.setReserveCount(rs.getInt("reserveCount"));
				dto.setWatchCount(rs.getInt("watchCount"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) { }
		}
		return list;
	}
	
	
	
}

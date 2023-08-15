package day09_student;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StudentDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	private static StudentDAO instance;
	
	private StudentDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println("데이터소스 못불러옴 : " + e);
		}
	}
	
	private void close() {
		try {
			if (rs != null) 	rs.close();
			if (pstmt != null) 	pstmt.close();
			if (conn != null) 	conn.close();
		} catch (Exception e) {}
	}
	
	public static StudentDAO getInstance() {
		if(instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	public StudentDTO mapping(ResultSet rs) throws SQLException {
		StudentDTO dto = new StudentDTO();
		dto.setName(rs.getString("name"));
		dto.setKor(rs.getInt("kor"));
		dto.setEng(rs.getInt("eng"));
		dto.setMath(rs.getInt("math"));
		dto.setTotal(rs.getInt("total"));
		dto.setAvg(rs.getDouble("avg"));
		return dto;
	}

	public ArrayList<StudentDTO> selectList() {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		String sql = "select student.*,kor + eng + math as total,trunc((kor + eng + math) / 3, 1) as avg from student";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO dto = mapping(rs);
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int insert(StudentDTO dto) {
		int row = 0;
		String sql = "insert into student values (?, ?, ?, ?)";
		System.out.println("이름 : " + dto.getName());
		System.out.println("국어 : " + dto.getKor());
		System.out.println("영어 : " + dto.getEng());
		System.out.println("수학 : " + dto.getMath());
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMath());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			close();
		}
		return row;
	}
	
	public StudentDTO selectOne(String name) {
		StudentDTO dto = null;
		String sql = "select student.*,kor + eng + math as total,trunc((kor + eng + math) / 3, 1) as avg from student where name=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = mapping(rs);
			}
			
		} catch (Exception e) {
		} finally {
			close();
		}
		
		return dto;
	}
	
	public int delete(String name) {
		int row = 0;
		String sql = "delete from student where name=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
		} finally {
			close();
		}
		
		return row;
	}
	
	public int update(StudentDTO dto) {
		int row = 0;
		String sql = "update student SET kor=?,eng=?,math=? where name=?";
		System.out.println("이름 : " + dto.getName());
		System.out.println("국어 : " + dto.getKor());
		System.out.println("영어 : " + dto.getEng());
		System.out.println("수학 : " + dto.getMath());
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMath());
			pstmt.setString(4, dto.getName());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			close();
		}
		System.out.println("row : " + row);
		return row;
	}
	
}

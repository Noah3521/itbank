package board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DAO;

public class BoardDAO extends DAO {
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDTO mapping(ResultSet rs) throws SQLException {
		BoardDTO dto = new BoardDTO();
		dto.setIdx(rs.getInt("idx"));
		dto.setTitle(rs.getString("title"));
		dto.setWriter(rs.getString("writer"));
		dto.setContent(rs.getString("content"));
		dto.setWdate(rs.getDate("wdate"));
		dto.setUploadFile(rs.getString("uploadFile"));
		return dto;
	}
	
	public List<BoardDTO> selectList() {
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board2 order by idx desc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return list;
	}
	
	public List<BoardDTO> selectQueryList(String query) {
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board2 where instr(title, ?) > 0";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return list;
	}
	
	public BoardDTO selectOne(int idx) {
		BoardDTO dto = null;
		String sql = "select * from board2 where idx=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = mapping(rs);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return dto;
	}
	
	public int insert(BoardDTO dto) {
		String sql = "insert into board2 (title, writer, content, uploadFile) values(?, ?, ?, ?)";
		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getUploadFile());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return row;
	}
	
	public int getMaxIdx() {
		String sql = "select max(idx) from board2";
		int maxIdx = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				maxIdx = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return maxIdx;
	}
	
	public int update(BoardDTO dto) {
		String sql;
		if (dto.getUploadFile()!=null) {
			sql = "update board2 set title=?, content=?, uploadFile=? where idx=?";
		} else {
			sql = "update board2 set title=?, content=? where idx=?";
		}
		int row = 0;
		int count = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++count, dto.getTitle());
			pstmt.setString(++count, dto.getContent());
			if(dto.getUploadFile()!=null) {
				pstmt.setString(++count, dto.getUploadFile());
			}
			pstmt.setInt(++count, dto.getIdx());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return row;
	}
	
	public int delete(int idx) {
		String sql = "delete board2 where idx=?";
		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return row;
	}
	
	
	
} 

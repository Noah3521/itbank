package com.itbank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbank.model.MusicDTO;

public class MusicDAO extends DAO {
	
	private static MusicDAO instance = new MusicDAO();
	
	public static MusicDAO getInstance() {
		return instance;
	}

	private MusicDTO mapping(ResultSet rs) throws SQLException {
		MusicDTO dto = new MusicDTO();
		dto.setId(rs.getInt("id"));
		dto.setArtist_id(rs.getInt("artist_id"));
		dto.setAlbum_id(rs.getInt("album_id"));
		dto.setName(rs.getString("name"));
		dto.setGenre(rs.getString("genre"));
		dto.setPlaytime(rs.getInt("playtime"));
		dto.setLyrics(rs.getString("lyrics"));
		dto.setPlayCount(rs.getInt("playCount"));
		return dto;
	}
	
	public List<MusicDTO> selectList() {
		String sql = "select * from music";
		List<MusicDTO> list = new ArrayList<MusicDTO>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int insert(MusicDTO dto) {
		String sql = "insert into music(artist_id, album_id, name, genre, playtime, lyrics) values(?,?,?,?,?,?)";
		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getArtist_id());
			pstmt.setInt(2, dto.getAlbum_id());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGenre());
			pstmt.setInt(5, dto.getPlaytime());
			pstmt.setString(6, dto.getLyrics());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public List<MusicDTO> selectList(int album_id) {
		String sql = "select * from music where album_id=? order by id";
		List<MusicDTO> list = new ArrayList<MusicDTO>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, album_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	private int updatePlayCount(int id) {
		int row = 0;
		String sql = "update music set playCount=playCount+1 where id=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public MusicDTO selectOne(int id) {
		
		int row = updatePlayCount(id);
		System.out.println("\n\t" + row + "행의 조회수가 증가되었습니다\n");
		
		String sql = "select * from music where id=?";
		MusicDTO dto = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = mapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public int delete(int id) {
		String sql = "delete music where id=?";
		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int getMaxId() {
		String sql = "select max(id) from music";
		int idx = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				idx = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return idx;
	}

	public int update(MusicDTO dto) {
		String sql = "update music set name=?, genre=?, playtime=?, lyrics=? where id=?";
		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getGenre());
			pstmt.setInt(3, dto.getPlaytime());
			pstmt.setString(4, dto.getLyrics());
			pstmt.setInt(5, dto.getId());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	
}

package com.itbank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbank.model.AlbumDTO;

public class AlbumDAO extends DAO {
	private static AlbumDAO instance = new AlbumDAO();
	public static AlbumDAO getInstance() {
		return instance;
	}
	
	private AlbumDTO mapping(ResultSet rs) throws SQLException {
		AlbumDTO dto = new AlbumDTO();
		dto.setId(rs.getInt("id"));
		dto.setArtist_id(rs.getInt("artist_id"));
		dto.setName(rs.getString("name"));
		dto.setType(rs.getString("type"));
		dto.setRdate(rs.getDate("rdate"));
		dto.setPlaytime(rs.getInt("playtime"));
		dto.setCoverimg(rs.getString("coverimg"));
		return dto;
	}
	
	public List<AlbumDTO> selectList() {
		List<AlbumDTO> list = new ArrayList<>();
		String sql = "select * from album order by name";
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
	
	public List<AlbumDTO> selectList(int artistId) {
		List<AlbumDTO> list = new ArrayList<>();
		String sql = "select * from album where artist_id=? order by name";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, artistId);
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

	public int insert(AlbumDTO dto) {
		int row = 0;
		String sql = "insert into album (artist_id, name, type, rdate, playtime, coverimg) values(?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getArtist_id());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getType());
			pstmt.setDate(4, dto.getRdate());
			pstmt.setInt(5, dto.getPlaytime());
			pstmt.setString(6, dto.getCoverimg());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public AlbumDTO selectOne(int id) {
		String sql = "select * from album where id=?";
		AlbumDTO dto = new AlbumDTO();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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

	public int delete(int id) {
		String sql = "delete album where id=?";
		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;	
	}

	public int update(AlbumDTO dto) {
		boolean flag = dto.getCoverimg()!=null;
		String sql;
		if(flag) {			
			sql = "update album set artist_id=?, name=?, type=?, rdate=?, playtime=?, coverimg=? where id=?";
		} else {
			sql = "update album set artist_id=?, name=?, type=?, rdate=?, playtime=? where id=?";			
		}
		int row = 0;
		int cnt = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++cnt, dto.getArtist_id());
			pstmt.setString(++cnt, dto.getName());
			pstmt.setString(++cnt, dto.getType());
			pstmt.setDate(++cnt, dto.getRdate());
			pstmt.setInt(++cnt, dto.getPlaytime());
			if(flag) {				
				pstmt.setString(++cnt, dto.getCoverimg());
			}
			pstmt.setInt(++cnt, dto.getId());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;	
	}

	public int getMaxId() {
		String sql = "select max(id) from album";

		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;	
	}


}

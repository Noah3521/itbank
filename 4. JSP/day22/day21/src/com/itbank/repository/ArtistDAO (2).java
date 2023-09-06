package com.itbank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbank.model.ArtistDTO;

public class ArtistDAO extends DAO {

	private static ArtistDAO instance = new ArtistDAO();
	
	public static ArtistDAO getInstance() {
		return instance;
	}
	
	private ArtistDTO mapping(ResultSet rs) throws SQLException {
		ArtistDTO dto = new ArtistDTO();
		dto.setId(rs.getInt("id"));
		dto.setName(rs.getString("name"));
		dto.setCompany(rs.getString("company"));
		dto.setCountry(rs.getString("country"));
		dto.setMember(rs.getString("member"));
		dto.setDebut(rs.getDate("debut"));
		dto.setType(rs.getString("type"));
		dto.setProfileimg(rs.getString("profileimg"));
		return dto;
	}
	
	public List<ArtistDTO> selectList() {
		String sql = "select * from artist order by name";
		List<ArtistDTO> list = new ArrayList<ArtistDTO>();	
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

	public int insert(ArtistDTO dto) {
		String sql = "insert into artist (name, company, country, member, debut, type, profileimg) values(?, ?, ?, ? , ? , ? , ?)";
		int row = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getCountry());
			pstmt.setString(4, dto.getMember());
			pstmt.setDate(5, dto.getDebut());
			pstmt.setString(6, dto.getType());
			pstmt.setString(7, dto.getProfileimg());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int getMaxId() {
		String sql = "select max(id) from artist";
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

	public ArtistDTO selectOne(int id) {
		String sql = "select * from artist where id=?";
		ArtistDTO dto = new ArtistDTO();
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
		String sql = "delete artist where id=?";
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

	public int update(ArtistDTO dto) {
		String sql;
		boolean flag = dto.getProfileimg() != null;
		if(flag) {			
			sql = "update artist set name=?, company=?, country=?, member=?, debut=?, type=?, profileimg=? where id=?";
		} else {
			sql = "update artist set name=?, company=?, country=?, member=?, debut=?, type=? where id=?";
		}
		int row = 0;
		int cnt = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, dto.getName());
			pstmt.setString(++cnt, dto.getCompany());
			pstmt.setString(++cnt, dto.getCountry());
			pstmt.setString(++cnt, dto.getMember());
			pstmt.setDate(++cnt, dto.getDebut());
			pstmt.setString(++cnt, dto.getType());
			if(flag) {				
				pstmt.setString(++cnt, dto.getProfileimg());
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


}

package com.kim.project.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kim.project.common.dto.SkillDto;

import util.DBManager;

public class SkillDao {
	private static SkillDao instance = null;
	
	private SkillDao() {
	}
	
	public static SkillDao getInstance()
	{
		if(instance == null)
			instance = new SkillDao();
		
		return instance;
	}
	 
	public List<SkillDto> selectAllSkills()
	{
		String sql = "select * from skill order by skill_name asc";
		List<SkillDto> skillList = new ArrayList<SkillDto>();
		SkillDto sDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				sDto = new SkillDto();
				sDto.setSkill_id(rs.getString("skill_id"));
				sDto.setSkill_name(rs.getString("skill_name"));
				
				skillList.add(sDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return skillList;
	}
	
	

}

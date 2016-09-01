package com.kim.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kim.project.dto.CorpProjectDto;

import util.DBManager;

public class ProjectDao {
	private static ProjectDao instance = null;
	
	private ProjectDao() {
	}
	
	public static ProjectDao getInstance()
	{
		if(instance == null)
			instance=new ProjectDao();
		return instance;
	}
	public boolean insertCorpProjectJoinEmps(String project_id,String[] empList,String[] emp_Roles)
	{
		boolean result=false;
		String sql = "INSERT INTO CORP_PROJECT_JOIN_EMPS VALUES(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i=0 ; i<empList.length;i++){
				pstmt.setString(1, project_id);
				pstmt.setString(2, empList[i]);
				pstmt.setString(3, emp_Roles[i]);
				pstmt.executeUpdate();
			}
			result=true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
			
		return result;
	}
	public boolean insertCorpProjectSkills(String project_id,String[] skills)
	{
		boolean result=false;
		String sql = "INSERT INTO CORP_PROJECT_SKILL VALUES(?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(String skill_id : skills){
				pstmt.setString(1, project_id);
				pstmt.setString(2, skill_id);
				pstmt.executeUpdate();
			}
			result=true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
			
		return result;
	}
	public String getNextCorpProjectId()
	{
		String sql = "select corp_project_SEQ from dual";
		String project_id=null;;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			project_id=rs.getString(1);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		
		return project_id;
	}
	public boolean insertCorpProject(CorpProjectDto cpDto){
		String sql ="insert into corp_project values(?,?,?,?,?,?,?,?)";
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cpDto.getProject_id());
			pstmt.setString(2, cpDto.getProject_name());
			pstmt.setString(3, cpDto.getCorp_name());
			pstmt.setString(4, cpDto.getStart_dt());
			pstmt.setString(5, cpDto.getEnd_dt());
			pstmt.setString(6, cpDto.getProject_content());
			pstmt.setString(7, cpDto.getCorp_own());
			pstmt.setString(8, cpDto.getRemarks());
			if(pstmt.executeUpdate()==1)
				result=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	

}

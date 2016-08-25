package com.kim.project.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kim.project.common.dto.EmployeeSimpleDto;

import util.DBManager;

public class SiteManagerDao {
	
	private static SiteManagerDao instance = null;
	
	private SiteManagerDao() {
	}
	
	public static SiteManagerDao getInstance()
	{
		if(instance==null)
			instance = new SiteManagerDao();
		
		return instance;
	}
	
	public EmployeeSimpleDto isManager(String emp_id)
	{
		String sql ="select emp_name "
				+ "from employee "
				+ "where emp_id=?";

		String manager_sql ="select M.emp_id "
				+ "from employee E, site_manager M"
				+ "where M.emp_id=?";
		
		EmployeeSimpleDto eDto=new EmployeeSimpleDto();
		boolean isManager=false;
		Connection conn =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return eDto;
	}
	

}

package com.kim.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kim.common.dto.SkillDto;
import com.kim.employee.dao.EmployeeDao;
import com.kim.employee.dto.EmployeeDto;
import com.kim.project.dto.CorpProjectDto;
import com.kim.project.dto.EmpRoleDto;

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
	
	
	public List<CorpProjectDto> selectAllCorpPorject(int curPage, int recordPerPage){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PROJECT_ID, project_name, CORP_NAME, START_DT, END_DT,CORP_OWN ,join_num ");
		sql.append("FROM (SELECT ROWNUM Ro, project_id,project_name, corp_name, start_dt, end_dt ,CORP_OWN ,join_num ");
		sql.append("FROM (SELECT  project_id,project_name, corp_name, start_dt, end_dt,CORP_OWN ,(SELECT COUNT(*) FROM CORP_PROJECT_JOIN_EMPS WHERE project_id = cp.PROJECT_ID) join_num FROM CORP_PROJECT cp ORDER BY cp.START_DT DESC )cp)");
		sql.append("WHERE Ro BETWEEN ? AND ?");
			
		List<CorpProjectDto> projectList =null;
		CorpProjectDto cpDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(curPage<1)
			curPage=1;
		
		int start =((curPage-1)*recordPerPage)+1;
		int end = start+recordPerPage -1;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			projectList=new ArrayList<CorpProjectDto>();
			int seq=start;
			while(rs.next()){
				cpDto=new CorpProjectDto();
				cpDto.setProject_seq(seq);
				cpDto.setProject_id(rs.getString("PROJECT_ID"));
				cpDto.setProject_name(rs.getString("PROJECT_NAME"));
				cpDto.setCorp_name(rs.getString("CORP_NAME"));
				cpDto.setStart_dt(rs.getString("START_DT").substring(0, 10));
				cpDto.setEnd_dt(rs.getString("END_DT").substring(0, 10));
				cpDto.setJoin_num(rs.getString("join_num"));
				cpDto.setCorp_own(rs.getString("CORP_OWN"));
				projectList.add(cpDto);
				seq++;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return projectList;
	}
	
	public List<CorpProjectDto> selectAllEmpPorject(int curPage, int recordPerPage){
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT PROJECT_ID, project_name, CORP_NAME, START_DT, END_DT,CORP_OWN,role ");
		sql.append("FROM (SELECT ROWNUM Ro, project_id,project_name, corp_name, start_dt, end_dt ,CORP_OWN ,role ");
		sql.append("FROM (SELECT  project_id,project_name, corp_name, start_dt, end_dt,CORP_OWN,role  FROM emp_PROJECT cp ORDER BY cp.START_DT DESC )cp) ");
		sql.append("WHERE Ro BETWEEN ? AND ? ");
			
		
		
			
		List<CorpProjectDto> projectList =null;
		CorpProjectDto cpDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(curPage<1)
			curPage=1;
		
		int start =((curPage-1)*recordPerPage)+1;
		int end = start+recordPerPage -1;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			projectList=new ArrayList<CorpProjectDto>();
			int seq=start;
			while(rs.next()){
				cpDto=new CorpProjectDto();
				cpDto.setProject_seq(seq);
				cpDto.setProject_id(rs.getString("PROJECT_ID"));
				cpDto.setProject_name(rs.getString("PROJECT_NAME"));
				cpDto.setCorp_name(rs.getString("CORP_NAME"));
				if(rs.getString("START_DT")!=null)
					cpDto.setStart_dt(rs.getString("START_DT").substring(0, 10));
				if(rs.getString("END_DT")!=null)
					cpDto.setEnd_dt(rs.getString("END_DT").substring(0, 10));
				cpDto.setCorp_own(rs.getString("CORP_OWN"));
				projectList.add(cpDto);
				seq++;
			}
		}
		//PROJECT_ID, project_name, CORP_NAME, START_DT, END_DT,CORP_OWN,role
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return projectList;
	}
	
	
	
	
	public int getEmpProjectTotal(){
		String sql = "select count(*) from emp_project";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				total=rs.getInt(1);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return total;
	}
	public int getCorpProjectTotal(){
		String sql = "select count(*) from corp_project";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				total=rs.getInt(1);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return total;
	}
	
	
	public CorpProjectDto selectCorpPorjectById(String project_id){
		CorpProjectDto cpDto = null;
		String sql = "select * from corp_project where project_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				cpDto=new CorpProjectDto();
				cpDto.setProject_id(rs.getString("PROJECT_ID"));
				cpDto.setProject_name(rs.getString("PROJECT_NAME"));
				cpDto.setCorp_name(rs.getString("CORP_NAME"));
				cpDto.setStart_dt(rs.getString("START_DT").substring(0, 10));
				cpDto.setEnd_dt(rs.getString("END_DT").substring(0, 10));
				cpDto.setProject_content(rs.getString("PROJECT_CONTENT"));
				cpDto.setCorp_own(rs.getString("CORP_OWN"));
				cpDto.setRemarks(rs.getString("REMARKS"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cpDto;
	}
	
/*	public CorpProjectDto selectEmpPorjectById(String project_id){
		CorpProjectDto cpDto = null;
		String sql = "select * from emp_project where project_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project_id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				cpDto=new CorpProjectDto();
				cpDto.setProject_id(rs.getString("PROJECT_ID"));
				cpDto.setProject_name(rs.getString("PROJECT_NAME"));
				cpDto.setCorp_name(rs.getString("CORP_NAME"));
				cpDto.setStart_dt(rs.getString("START_DT"));
				cpDto.setEnd_dt(rs.getString("END_DT"));
				cpDto.setProject_content(rs.getString("PROJECT_CONTENT"));
				cpDto.setCorp_own(rs.getString("CORP_OWN"));
				cpDto.setRole(rs.getString("ROLE"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cpDto;
	}*/
	
	
	
	public List<SkillDto> selectCorpPorjectSkillsById(String project_id){
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT s.SKILL_ID, s.SKILL_NAME, NVL2(ps.skill_id, 'y', 'n') isChecked ");
		sql.append("FROM SKILL s left outer JOIN (SELECT * FROM CORP_PROJECT_SKILL WHERE PROJECT_ID =?) ps ");
		sql.append("ON s.SKILL_ID = ps.SKILL_ID ");
		
		List<SkillDto> skillList = null;
		SkillDto sDto = null;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, project_id);
			rs=pstmt.executeQuery();
			skillList=new ArrayList<SkillDto>();
			while(rs.next())
			{
				sDto=new SkillDto();
				sDto.setSkill_id(rs.getString("skill_id"));
				sDto.setSkill_name(rs.getString("skill_name"));
				sDto.setIsChecked(rs.getString("isChecked"));
				skillList.add(sDto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return skillList;
	}
	
	public List<EmployeeDto> selectCorpPorjectJoinEmpById(String project_id){
		String sql="SELECT cpje.emp_id,er.role_id,er.role_name FROM CORP_PROJECT_JOIN_EMPS cpje, EMP_ROLE er WHERE project_id=? AND cpje.ROLE_ID=er.ROLE_ID";
		EmployeeDto eDto = null;
		EmpRoleDto erDto=null;
		List<EmployeeDto> empList = null;
		ArrayList<EmpRoleDto> joinEmp = null;
		EmployeeDao eDao = EmployeeDao.getInstance();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, project_id);
			rs=pstmt.executeQuery();
			empList=new ArrayList<EmployeeDto>();
			joinEmp = new ArrayList<EmpRoleDto>();
			while(rs.next()){
				erDto=new EmpRoleDto();
				erDto.setEmp_id(rs.getString("emp_id"));
				erDto.setRole_id(rs.getString("role_id"));
				erDto.setRole_name(rs.getString("role_name"));
				joinEmp.add(erDto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		if(joinEmp!=null)
			for(int i=0; i <joinEmp.size();i++){
				eDto = eDao.selectEmpById(joinEmp.get(i).getEmp_id());
				eDto.setEmp_seq(i+1);
				eDto.setRole_name(joinEmp.get(i).getRole_name());
				eDto.setRole_id(joinEmp.get(i).getRole_id());	
				empList.add(eDto);
			}
		return empList;
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
	
	
	public String getNextEmpProjectId(){
		String sql = "select emp_project_SEQ from dual";
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
	

	public boolean insertEmpProject(String emp_id, CorpProjectDto cpDto){
		String sql ="insert into emp_project values(?,?,?,?,?,?,?,?,?)";
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		/*
EMP_ID
PROJECT_ID
PROJECT_NAME
CORP_NAME
PROJECT_CONTENT
ROLE
START_DT
END_DT
CORP_OWN*/
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			pstmt.setString(2, cpDto.getProject_id());
			pstmt.setString(3, cpDto.getProject_name());
			pstmt.setString(4, cpDto.getCorp_name());
			pstmt.setString(5, cpDto.getProject_content());
			pstmt.setString(6, cpDto.getRole());
			pstmt.setString(7, cpDto.getStart_dt());
			pstmt.setString(8, cpDto.getEnd_dt());
			pstmt.setString(9, cpDto.getCorp_own());
			if(pstmt.executeUpdate()==1)
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
/*	public CorpProjectDto selectCorpPorjectById(String project_id)
	{
		CorpProjectDto cpDto = null;
		String sql = "select * from corp_project where project_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project_id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				rs.getString("");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cpDto;
	}*/
}

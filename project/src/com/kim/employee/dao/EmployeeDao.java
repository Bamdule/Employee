package com.kim.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kim.employee.dto.DepartmentDto;
import com.kim.employee.dto.EmployeeDto;
import com.kim.employee.dto.RankDto;
import com.kim.project.common.dto.EmployeeSimpleDto;

import util.DBManager;
import util.StringUtil;

public class EmployeeDao {

	private static EmployeeDao instance = null;

	private EmployeeDao() {
	}

	public static EmployeeDao getInstance() {
		if (instance == null)
			instance = new EmployeeDao();
		return instance;
	}
	
	
	public List<EmployeeDto> selectAllEmployee(int curPage,int pagePerRecord)
	{
		List<EmployeeDto> empList=new ArrayList<EmployeeDto>();
		
		if(curPage<1)
			curPage=1;
		
		int start =((curPage-1)*pagePerRecord)+1;
		int end = start+pagePerRecord -1;
		
		String sql = "SELECT E.emp_id, E.emp_name, E.enter_dt ,d.dept_name ,r.rank_name "
				   + "FROM ( SELECT ROWNUM Ro, E.*  "
				   +          "FROM ( SELECT emp_id ,emp_name, enter_dt ,dept_id ,rank_id  "
				   +                   "FROM employee ORDER BY enter_dt DESC) E) E,department d ,rank r "
				   + "WHERE Ro BETWEEN ? AND ? "
				   +                    "AND E.dept_id = d.dept_id "
				   +                    "AND E.rank_id = r.rank_id";
	
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeeDto dto = null;
		try {
			
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs=pstmt.executeQuery();
			
			int seq=start;
			while(rs.next()){
				dto=new EmployeeDto();
				dto.setEmp_seq(seq);
				dto.setEmp_id(rs.getString("emp_id"));
				dto.setEmp_name(rs.getString("emp_name"));
				dto.setDept_name(rs.getString("dept_name"));
				dto.setRank_name(rs.getString("rank_name"));
				dto.setEnter_dt(rs.getString("enter_dt").substring(0, 10));
				
				
				empList.add(dto);
				seq++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return empList;
	}
	public int getEmpCount()
	{
		int num=0;
		String sql="select count(*) from employee";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			conn = DBManager.getConnection();			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				num=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		
		return num;
	}

	public EmployeeDto selectEmpById(String emp_id)
	{
		String sql = "SELECT D.DEPT_NAME, R.RANK_NAME, E.* FROM EMPLOYEE E ,RANK R ,DEPARTMENT D WHERE E.emp_id = ? AND E.dept_id = D.DEPT_ID AND E.RANK_ID = R.RANK_ID ";
		EmployeeDto dto =null;
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto=new EmployeeDto();

				dto.setEmp_id(emp_id);
				dto.setEmp_name(rs.getString("emp_name"));
				dto.setEmp_pwd(rs.getString("emp_pwd"));
				dto.setEmp_imgpath(rs.getString("emp_imgpath"));
				dto.setEmp_imgpathorn(rs.getString("emp_imgpathorn"));
				dto.setRes_num(rs.getString("res_num"));
				dto.setEmp_phone(rs.getString("emp_phone"));
				dto.setEmp_email(rs.getString("emp_email"));
				String email[] = StringUtil.halfString(rs.getString("emp_email"), "@");
				
				dto.setFront_email(email[0]);
				dto.setBack_email(email[1]);
				
				dto.setZipcode(rs.getString("zipcode"));
				dto.setEmp_addr(rs.getString("emp_addr"));
				dto.setEmp_detailaddr(rs.getString("emp_detailaddr"));
				dto.setEmp_sal(rs.getInt("emp_sal"));
				dto.setEnter_dt(rs.getString("enter_dt"));
				dto.setDept_id(rs.getString("dept_id"));
				dto.setRank_id(rs.getString("rank_id"));	
				dto.setDept_name(rs.getString("dept_name"));
				dto.setRank_name(rs.getString("rank_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		
		return dto;
	}
	public boolean insertEmployeeInfo(EmployeeDto dto) {
		boolean result=false;
		String sql = "insert into employee "
				+ "("
				+ "emp_id,"
				+ "emp_pwd,"
				+ "dept_id,"
				+ "rank_id,"
				+ "emp_name,"
				+ "res_num,"
				+ "emp_phone,"
				+ "emp_addr,"
				+ "emp_detailaddr,"
				+ "emp_email,"
				+ "zipcode,"
				+ "enter_dt,"
				+ "retire_dt,"
				+ "emp_sal,"
				+ "emp_imgpath,"
				+ "emp_imgpathorn)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_id());
			pstmt.setString(2, dto.getEmp_pwd());
			pstmt.setString(3, dto.getDept_id());
			pstmt.setString(4, dto.getRank_id());
			pstmt.setString(5, dto.getEmp_name());
			pstmt.setString(6, dto.getRes_num());
			pstmt.setString(7, dto.getEmp_phone());
			pstmt.setString(8, dto.getEmp_addr());
			pstmt.setString(9, dto.getEmp_detailaddr());
			pstmt.setString(10, dto.getEmp_email());
			pstmt.setString(11, dto.getZipcode());
			pstmt.setString(12, dto.getEnter_dt());
			pstmt.setString(13, dto.getRetire_dt());
			pstmt.setInt(14, dto.getEmp_sal());
			pstmt.setString(15, dto.getEmp_imgpath());
			pstmt.setString(16, dto.getEmp_imgpathorn());
			pstmt.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		finally{
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	public List<DepartmentDto> selectAllDept()
	{
		String sql = "select * from department";
		List<DepartmentDto> deptList = new ArrayList<DepartmentDto>();
		DepartmentDto dDto = null;
		PreparedStatement pstmt = null;
		Connection conn =null;
		ResultSet rs = null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				dDto = new DepartmentDto();
				dDto.setDept_id(rs.getString("dept_id"));
				dDto.setDept_name(rs.getString("dept_name"));
				deptList.add(dDto);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		return deptList;
	}
	
	public List<RankDto> selectAllRank()
	{
		String sql = "select * from rank";
		List<RankDto> rankList = new ArrayList<RankDto>();
		RankDto rDto = null;
		PreparedStatement pstmt = null;
		Connection conn =null;
		ResultSet rs = null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				rDto = new RankDto();
				rDto.setRank_id(rs.getString("rank_id"));
				rDto.setRank_name(rs.getString("rank_name"));
				rankList.add(rDto);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		return rankList;
	}
	
	public boolean employeeUpdate(EmployeeDto dto) {
		boolean result=false;
		String sql= "update employee "
				 + "set emp_pwd=?"
				 	  + ",dept_id=?"
				 	  + ",rank_id=?"
				 	  + ",emp_name=?"
				 	  + ",emp_phone=?"
				 	  + ",emp_addr=?"
				 	  + ",emp_detailaddr=?"
				 	  + ",emp_email=?"
				 	  + ",zipcode=?"
				 	  + ",emp_sal=?"
				 	  + ",emp_imgpath=?"
				 	  + ",emp_imgpathorn=?"
				 	  + "where emp_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmp_pwd());
			pstmt.setString(2, dto.getDept_id());
			pstmt.setString(3, dto.getRank_id());
			pstmt.setString(4, dto.getEmp_name());
			pstmt.setString(5, dto.getEmp_phone());
			pstmt.setString(6, dto.getEmp_addr());
			pstmt.setString(7, dto.getEmp_detailaddr());
			pstmt.setString(8, dto.getEmp_email());
			pstmt.setString(9, dto.getZipcode());
			pstmt.setInt(10, dto.getEmp_sal());
			pstmt.setString(11, dto.getEmp_imgpath());
			pstmt.setString(12, dto.getEmp_imgpathorn());
			pstmt.setString(13, dto.getEmp_id());
			pstmt.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		finally{
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	/*
	 * result : 
	 * 1 : success
	 * 2 : id check failed
	 * 3 : pass check faild
	 */
	public EmployeeSimpleDto loginCheck(String emp_id, String emp_pwd)
	{
		String sql ="select emp_pwd,emp_name from employee where emp_id=?";
		String check_pwd=null;
		int result = 3;
		EmployeeSimpleDto eSimpleDto = new EmployeeSimpleDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				check_pwd=rs.getString("emp_pwd");
				if(check_pwd.equals(emp_pwd)){//1 : success
					eSimpleDto.setResult(1);	
					eSimpleDto.setEmp_name(rs.getString("emp_name"));
					eSimpleDto.setEmp_id(emp_id);
					
					String manager_sql ="select emp_id "
							+ "from site_manager "
							+ "where emp_id=?";
					
					pstmt.close();
					rs.close();
					
					pstmt=conn.prepareStatement(manager_sql);
					pstmt.setString(1, emp_id);
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						if(rs.getString("emp_id").equals(emp_id))
						{
							eSimpleDto.setManager(true);						
							eSimpleDto.setEmp_name(eSimpleDto.getEmp_name()+" 관리자");
						}
					}
					else
						eSimpleDto.setManager(false);

				}
				
				else//3 : pass check faild
					eSimpleDto.setResult(3);
			}
			else//2 : id check failed
				result=2;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return eSimpleDto;
	}

}

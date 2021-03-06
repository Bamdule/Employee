package com.kim.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kim.common.dto.EmployeeSimpleDto;
import com.kim.common.dto.SkillDto;
import com.kim.employee.dto.AcademicLevelDto;
import com.kim.employee.dto.AcademicStatusDto;
import com.kim.employee.dto.DepartmentDto;
import com.kim.employee.dto.EmpAcademicDto;
import com.kim.employee.dto.EmpCareerDto;
import com.kim.employee.dto.EmpLicenceDto;
import com.kim.employee.dto.Emp_Role;
import com.kim.employee.dto.EmployeeDto;
import com.kim.employee.dto.RankDto;

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
				   			+ "FROM ( SELECT emp_id ,emp_name, enter_dt ,dept_id ,rank_id  "
				   					  + "FROM employee ORDER BY enter_dt DESC) E) "
					   + "E left outer join department d "
					   + "on E.dept_id = d.dept_id "
					   + "left outer join rank r "
					   + "on E.rank_id = r.rank_id "
				   + "WHERE Ro BETWEEN ? AND ? ";
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
		StringBuilder sql = new StringBuilder(); 
		        sql.append("SELECT D.DEPT_NAME, R.RANK_NAME, E.* "); 
				sql.append("FROM EMPLOYEE E left outer JOIN RANK R ");
				sql.append("ON E.RANK_ID = R.RANK_ID ");
				sql.append("left outer JOIN DEPARTMENT D ");
				sql.append("ON E.dept_id = D.DEPT_ID ");
				sql.append("WHERE E.emp_id = ? ");
		EmployeeDto dto =null;
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
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
		
		dto.setSkillList(selectEmpSkillsById(dto.getEmp_id()));
		return dto;
	}
	public List<SkillDto> selectEmpSkillsById(String emp_id)
	{
		List<SkillDto> skillDto =new ArrayList<SkillDto>();
		SkillDto sDto = null;
		String sql="SELECT s.SKILL_ID,s.SKILL_NAME FROM EMP_HAS_SKILL ehs, SKILL s WHERE ehs.emp_id = ? AND ehs.SKILL_ID = s.SKILL_ID";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				sDto = new SkillDto();
				sDto.setSkill_id(rs.getString(1));
				sDto.setSkill_name(rs.getString(2));
				
				skillDto.add(sDto);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return skillDto;
	}
	public void insertEmployeeSkills(String emp_id,List<SkillDto> skillList)
	{
			String sql="insert into emp_has_skill values(?,?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt= conn.prepareStatement(sql);{
				if(skillList!=null&&skillList.size()!=0)
					for(int index=0; index<skillList.size();index++){
						pstmt.setString(1, emp_id);
						pstmt.setString(2, skillList.get(index).getSkill_id());
						pstmt.executeUpdate();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt);
			}
	}
	public String createEmpId()
	{
		String sql="select emp_seq from dual";
		String emp_id=null;
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			rs.next();
			emp_id=rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return emp_id;
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
		
		if(dto.getSkillList()!=null&&dto.getSkillList().size()!=0)
			insertEmployeeSkills(dto.getEmp_id(),dto.getSkillList());
		
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
				 + 	  "set emp_pwd=?"
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
		insertEmployeeSkills(dto.getEmp_id(),dto.getSkillList());
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
	
	public List<AcademicLevelDto> selectAllAcademicLevel(){
		String sql = "select * from academic_level";
		List<AcademicLevelDto> academicLevelList = new ArrayList<AcademicLevelDto>();
		AcademicLevelDto alDto = null;
		PreparedStatement pstmt = null;
		Connection conn =null;
		ResultSet rs = null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				alDto = new AcademicLevelDto();
				alDto.setAcademic_lev_id(rs.getString("academic_lev_id"));
				alDto.setAcademic_lev_name(rs.getString("academic_lev_name"));
				academicLevelList.add(alDto);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		return academicLevelList;
	}
	
	public List<AcademicStatusDto> selectAllAcademicStatus(){
		String sql = "select * from academic_status";
		List<AcademicStatusDto> academicStatusList = new ArrayList<AcademicStatusDto>();
		AcademicStatusDto asDto = null;
		PreparedStatement pstmt = null;
		Connection conn =null;
		ResultSet rs = null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				asDto = new AcademicStatusDto();
				asDto.setAcademic_status_id(rs.getString("academic_status_id"));
				asDto.setAcademic_status_name(rs.getString("academic_status_name"));
				academicStatusList.add(asDto);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		return academicStatusList;
	}

	public boolean insertEmpAcademic(String emp_id,List<EmpAcademicDto> academicList )
	{

		String sql="INSERT INTO EMP_ACADEMIC VALUES(emp_academic_seq.nextval,?,?,?,?,?,?,?)";
		boolean result = true;
		PreparedStatement pstmt = null;
		Connection conn =null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);	
			for(int i=0;i<academicList.size();i++){
				pstmt.setString(1, emp_id);
				pstmt.setString(2, academicList.get(i).getAcademic_lev_id());
				pstmt.setString(3, academicList.get(i).getAcademic_status_id());
				pstmt.setString(4, academicList.get(i).getAcademic_name());
				pstmt.setString(5, academicList.get(i).getMajor_name());
				pstmt.setString(6, academicList.get(i).getEnter_dt());
				pstmt.setString(7, academicList.get(i).getGraduation_dt());
			
				if(pstmt.executeUpdate()!=1)
					result=false;
				}		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public boolean insertEmpCareer(String emp_id,List<EmpCareerDto> careerList )
	{

		String sql="INSERT INTO EMP_CAREER VALUES(emp_career_seq.nextval,?,?,?,?,?,?)";
		boolean result = true;
		PreparedStatement pstmt = null;
		Connection conn =null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);	
			for(int i=0;i<careerList.size();i++){
				pstmt.setString(1, emp_id);
				pstmt.setString(2, careerList.get(i).getCorp_name());
				pstmt.setString(3, careerList.get(i).getRank_name());
				pstmt.setString(4, careerList.get(i).getEmp_role());
				pstmt.setString(5, careerList.get(i).getCareer_enter_dt().substring(0, 10));
				pstmt.setString(6, careerList.get(i).getCareer_retire_dt().substring(0, 10));
			
				if(pstmt.executeUpdate()!=1)
					result=false;
				}		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public boolean insertEmpLicence(String emp_id,List<EmpLicenceDto> licenceList ){
		String sql="INSERT INTO EMP_LICENCE VALUES(emp_licence_seq.nextval,?,?,?,?,?,?)";
		boolean result = true;
		PreparedStatement pstmt = null;
		Connection conn =null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);	
			for(int i=0;i<licenceList.size();i++){
				pstmt.setString(1, emp_id);
				pstmt.setString(2, licenceList.get(i).getInstitution());
				pstmt.setString(3, licenceList.get(i).getLicence_name());
				pstmt.setString(4, licenceList.get(i).getLicence_number());
				pstmt.setString(5, licenceList.get(i).getGet_dt().substring(0, 10));
				pstmt.setString(6, licenceList.get(i).getIns_type());
			
				if(pstmt.executeUpdate()!=1)
					result=false;
				}		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public List<EmpAcademicDto> selectAllEmpAcademicById(String emp_id)
	{
		StringBuilder sql =new StringBuilder();
		sql.append("SELECT al.ACADEMIC_LEV_NAME,s.ACADEMIC_STATUS_NAME,a.* ");
		sql.append("FROM emp_academic a, academic_level al, academic_status s ");
		sql.append("WHERE a.ACADEMIC_LEV_ID=al.ACADEMIC_LEV_ID ");
		sql.append("AND a.ACADEMIC_STATUS_ID= s.ACADEMIC_STATUS_ID ");
		sql.append("AND a.EMP_ID=? ");
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<EmpAcademicDto> academicList=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_id);
			rs=pstmt.executeQuery();
			academicList=new ArrayList<EmpAcademicDto>();
			EmpAcademicDto eaDto=null;
			
			while(rs.next())
			{
				eaDto =new EmpAcademicDto();
				eaDto.setAcademic_lev_name(rs.getString(1));
				eaDto.setAcademic_status_name(rs.getString(2));
				eaDto.setAcademic_seq(rs.getString("academic_seq"));
				eaDto.setAcademic_name(rs.getString("academic_name"));
				eaDto.setMajor_name(rs.getString("major_name"));
				eaDto.setEnter_dt(rs.getString("enter_dt").substring(0, 10));
				eaDto.setGraduation_dt(rs.getString("graduation_dt").substring(0, 10));
				academicList.add(eaDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return academicList;
	}


	public List<EmpCareerDto> selectAllEmpCareerById(String emp_id)
	{
		String sql = "SELECT * FROM emp_career WHERE EMP_ID=?";
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<EmpCareerDto> careerList=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs=pstmt.executeQuery();
			careerList=new ArrayList<EmpCareerDto>();
			EmpCareerDto ecDto=null;
			
			while(rs.next())
			{
				ecDto =new EmpCareerDto();
				ecDto.setCareer_seq(rs.getString("career_seq"));
				ecDto.setCorp_name(rs.getString("corp_name"));
				ecDto.setRank_name(rs.getString("RANK_NAME"));
				ecDto.setEmp_role(rs.getString("emp_role"));
				ecDto.setCareer_enter_dt(rs.getString("enter_dt"));
				ecDto.setCareer_retire_dt(rs.getString("retire_dt"));
				careerList.add(ecDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return careerList;
	}
	
	public List<EmpLicenceDto> selectAllEmpLicenceById(String emp_id){
		String sql ="SELECT * FROM emp_licence WHERE EMP_ID=?";
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<EmpLicenceDto> licenceList=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs=pstmt.executeQuery();
			licenceList=new ArrayList<EmpLicenceDto>();
			EmpLicenceDto elDto=null;

			while(rs.next())
			{
				elDto =new EmpLicenceDto();
				elDto.setLicence_seq(rs.getString("licence_seq"));
				elDto.setInstitution(rs.getString("institution"));
				elDto.setLicence_name(rs.getString("licence_name"));
				elDto.setLicence_number(rs.getString("licence_number"));
				elDto.setGet_dt(rs.getString("get_dt"));
				elDto.setIns_type(rs.getString("ins_type"));
				licenceList.add(elDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close(conn, pstmt, rs);
		}
		return licenceList;
	}
	public List<EmployeeDto> searchEmployee(int curPage,int pagePerRecord,String searchField,String keyword){
		List<EmployeeDto> empList=null;
		StringBuilder sql = new StringBuilder();
		if(curPage<1)
			curPage=1;
		int start =((curPage-1)*pagePerRecord)+1;
		int end = start+pagePerRecord -1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeeDto dto = null;
		
		try {
			conn=DBManager.getConnection();
			if(keyword == null || "".equals(keyword.trim())){
				sql.append("SELECT E.emp_id, E.emp_name, E.enter_dt ,E.dept_name ,E.rank_name ");
				sql.append("FROM ( SELECT ROWNUM Ro, E.* ");  
					   sql.append("FROM ( SELECT E.emp_id ,E.emp_name, E.enter_dt ,E.dept_id ,E.rank_id,d.DEPT_NAME,r.RANK_NAME "); 
				              sql.append("FROM EMPLOYEE E left outer join department d ");
								sql.append("on E.dept_id = d.dept_id ");
								sql.append("left outer join rank r "); 
								sql.append("on E.rank_id = r.rank_id ");
						 		sql.append("ORDER BY enter_dt DESC) E) E "); 
				sql.append("WHERE Ro BETWEEN ? AND ? ");	
				pstmt=conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			else{
				sql.append("SELECT E.emp_id, E.emp_name, E.enter_dt ,E.dept_name ,E.rank_name ");
				sql.append("FROM ( SELECT ROWNUM Ro, E.* ");  
				sql.append("FROM ( SELECT E.emp_id ,E.emp_name, E.enter_dt ,E.dept_id ,E.rank_id,d.DEPT_NAME,r.RANK_NAME "); 
				sql.append("FROM EMPLOYEE E left outer join department d ");
				sql.append("on E.dept_id = d.dept_id ");
				sql.append("left outer join rank r "); 
				sql.append("on E.rank_id = r.rank_id ");                                         
				sql.append("WHERE "+searchField+" LIKE ? ");
				sql.append("ORDER BY enter_dt DESC) E) E "); 
				sql.append("WHERE Ro BETWEEN ? AND ? ");	
				pstmt=conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}

			rs=pstmt.executeQuery();
			empList=new ArrayList<EmployeeDto>();
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
	public int getSearchEmployeeCount(String searchField,String keyword){
		Connection conn= null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		int count = 0;
		StringBuilder sql =new StringBuilder();

		try{
			conn=DBManager.getConnection();
			if(keyword == null || "".equals(keyword.trim())){
				sql.append("select count(*) from employee");
			pstmt =conn.prepareStatement(sql.toString());
			}else{
				sql.append("select count(*) "); 
				sql.append("from employee  E left outer join department d ");
				sql.append("on E.dept_id = d.dept_id "); 
				sql.append("left outer join rank r "); 
				sql.append("on E.rank_id = r.rank_id  WHERE "+searchField+" LIKE ?");
	
				pstmt =conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+keyword+"%");
			}
			rs =pstmt.executeQuery();
			if (rs.next()){
				count =rs.getInt(1);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}           
		return count;
	}
	
	public boolean deleteEmployeeAcademic(String academic_seq){
		System.out.println("deleteEmployeeAcademic");
		boolean result=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from emp_academic where academic_seq = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, academic_seq);
			if(pstmt.executeUpdate()==1)
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public boolean deleteEmployeeCareer(String career_seq){
		boolean result=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from emp_career where career_seq = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, career_seq);
			if(pstmt.executeUpdate()==1)
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public boolean deleteEmployeeLicence(String licence_seq){
		boolean result=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from emp_licence where licence_seq = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, licence_seq);
			if(pstmt.executeUpdate()==1)
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public List<Emp_Role> selectAllEmpRole(){
		String sql ="select * from emp_role";
		List<Emp_Role> roleList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp_Role empRole=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			roleList=new ArrayList<Emp_Role>();
			while(rs.next()){
				empRole=new Emp_Role();
				empRole.setRole_id(rs.getString("role_id"));
				empRole.setRole_name(rs.getString("role_name"));
				roleList.add(empRole);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return roleList;
	}
}

package com.kim.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kim.notice.dto.NoticeDto;

import util.DBManager;

public class NoticeDao {
	private static NoticeDao instance = null;
	
	private NoticeDao() {
	}
	
	public static NoticeDao getInstance()
	{
		if(instance==null)
			instance = new NoticeDao();
		
		return instance;
	}
	
	public int getTotalNotice()
	{
		String sql="select count(*) from notice";
		int totalNotice=0;
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			rs.next();
			totalNotice=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return totalNotice;
	}
	public List<NoticeDto> selectAllNotice(int curPage, int pagePerRecord)
	{
		List<NoticeDto> noticeList = new ArrayList<NoticeDto>();
		
		if(curPage<1)
			curPage=1;
		
		int start =((curPage-1)*pagePerRecord)+1;
		int end = start+pagePerRecord -1;
		
		String sql = "SELECT E.emp_name,N.emp_id, N.notice_id, N.notice_title, N.register_dt, N.readcount "
				   + " FROM ( SELECT ROWNUM Ro, N.* "
				   +          " FROM ( SELECT emp_id, notice_id, notice_title, register_dt, readcount "
				   +                   " FROM notice ORDER BY register_dt DESC) N) N, employee E "
				   + " WHERE Ro BETWEEN ? AND ? "
				   +                    "AND N.emp_id = E.emp_id ";
		
		
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			NoticeDto nDto = null;
			try {
			
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				
				rs=pstmt.executeQuery();
				
				int seq=start;
				while(rs.next()){
					nDto=new NoticeDto();
					nDto.setSeq(seq);
					nDto.setEmp_name(rs.getString("emp_name"));
					nDto.setEmp_id(rs.getString("emp_id"));
					nDto.setNotice_id(rs.getString("notice_id"));
					nDto.setNotice_title(rs.getString("notice_title"));
					nDto.setRegister_dt(rs.getString("register_dt").substring(0, 10));
					nDto.setReadcount(rs.getInt("readcount"));
						
					noticeList.add(nDto);
					seq++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return noticeList;
	}
	

}

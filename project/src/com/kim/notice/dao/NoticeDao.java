package com.kim.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kim.notice.dto.NoticeDto;
import com.kim.notice.dto.ReplyDto;

import util.DBManager;

public class NoticeDao {

	/*
	 * EMP_ID NOT NULL VARCHAR2(15) 
	 * NOTICE_ID NOT NULL VARCHAR2(10) 
	 * NOTICE_TITLE VARCHAR2(30)
	 * NOTICE_CONTENT VARCHAR2(4000) 
	 * REGISTER_DT DATE 
	 * UPDATE_DT DATE 
	 * READCOUNT NUMBER
	 */
	private static NoticeDao instance = null;

	private NoticeDao() {
	}

	public static NoticeDao getInstance() {
		if (instance == null)
			instance = new NoticeDao();

		return instance;
	}

	public int getTotalNotice() {
		String sql = "select count(*) from notice";
		int totalNotice = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			rs.next();
			totalNotice = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return totalNotice;
	}

	public List<NoticeDto> selectAllNotice(int curPage, int pagePerRecord) {
		List<NoticeDto> noticeList = new ArrayList<NoticeDto>();

		if (curPage < 1)
			curPage = 1;

		int start = ((curPage - 1) * pagePerRecord) + 1;
		int end = start + pagePerRecord - 1;

		String sql = "SELECT E.emp_name,N.emp_id, N.notice_id, N.notice_title, N.register_dt, N.readcount "
				+ " FROM ( SELECT ROWNUM Ro, N.* "
				+ " FROM ( SELECT emp_id, notice_id, notice_title, register_dt, readcount "
				+ " FROM notice ORDER BY register_dt DESC) N) N, employee E " 
				+ " WHERE Ro BETWEEN ? AND ? "
				+ " AND N.emp_id = E.emp_id ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDto nDto = null;
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			int seq = start;
			while (rs.next()) {
				nDto = new NoticeDto();
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
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return noticeList;
	}

	public NoticeDto selectNoticeById(String notice_id)
	{
		String sql ="SELECT N.*,E.emp_name FROM NOTICE N, EMPLOYEE E WHERE N.notice_id = ? AND E.emp_id = N.EMP_ID";
		NoticeDto nDto = new NoticeDto();
		Connection conn = null;;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice_id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				nDto.setEmp_id(rs.getString("emp_id"));
				nDto.setEmp_name(rs.getString("emp_name"));
				nDto.setNotice_id(rs.getString("notice_id"));
				nDto.setNotice_title(rs.getString("notice_title"));
				nDto.setNotice_content(rs.getString("notice_content"));
				nDto.setReadcount(rs.getInt("readcount"));
				nDto.setRegister_dt(rs.getString("register_dt").substring(0,16));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}

		return nDto;
	}
	public void updateReadCount(String notice_id) {
		String sql = "update notice set readcount=readcount+1 where notice_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public boolean insertNotice(
			NoticeDto nDto) {
		String sql = "insert into notice values(?,NOTICE_SEQ.NEXTVAL,?,?,sysdate,sysdate,0)";
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nDto.getEmp_id());
			pstmt.setString(2, nDto.getNotice_title());
			pstmt.setString(3, nDto.getNotice_content());

			if (pstmt.executeUpdate() == 1)
				result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}
	public boolean updateNotice(NoticeDto nDto)
	{
		System.out.println("updateNotice :"+nDto);
		String sql ="update notice set notice_title=?, notice_content=?, update_dt=sysdate where notice_id = ?";
		boolean result =false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nDto.getNotice_title());
			pstmt.setString(2, nDto.getNotice_content());
			pstmt.setString(3, nDto.getNotice_id());
			if(pstmt.executeUpdate()==1)
				result=true;
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}

		return result;
	}
	public boolean insertReplyToNotice(ReplyDto rDto)
	{
		//noit_id,emp_id,rep_id,rep_cont,regdt
		String sql ="insert into reply values(?,?,REPLY_SEQ.NEXTVAL,?,sysdate)";
		boolean result = false;
		Connection conn = null;;
		PreparedStatement pstmt = null;;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rDto.getNotice_id());
			pstmt.setString(2, rDto.getEmp_id());
			pstmt.setString(3, rDto.getReply_content());
			
			if(pstmt.executeUpdate()==1)
				result=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}

		return result;
	}
	
	
/*		public NoticeDto selectNoticeById(String notice_id)
	{
		String sql ="select * from notice where notice_id=?";
		NoticeDto nDto = new NoticeDto();
		Connection conn = null;;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice_id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				nDto.setEmp_id(rs.getString("emp_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}

		return nDto;
	}*/
}

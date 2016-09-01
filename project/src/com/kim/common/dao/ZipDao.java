package com.kim.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kim.common.dto.ZipDto;

import util.DBManager;

public class ZipDao {
	private static ZipDao instance=null;
	private ZipDao() {
	}
	
	public static ZipDao getInstance()
	{
		if(instance==null)
			instance=new ZipDao();
		
		return instance;
	}
	
	
    // 시도데이터=============================================
    public ArrayList<ZipDto> searchSido() {
             ArrayList<ZipDto> sidoList = new ArrayList<ZipDto>();
             Connection conn = null;
             PreparedStatement pstmt = null;
             ResultSet rs = null;
             try {
            	 	  conn=DBManager.getConnection();
                      String query = "select distinct(sido) from zipcode order by sido";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      while(rs.next()){
                              ZipDto zipcode = new ZipDto();
                              zipcode.setSido(rs.getString("SIDO"));
                              sidoList.add(zipcode);
                      }
             } catch (SQLException e) {
            	 e.printStackTrace();
             }finally{
            	 DBManager.close(conn, pstmt, rs);
            	 
             }

             return sidoList;
    }
   
    // 구군데이터=============================================
    public ArrayList<ZipDto> searchGugun(String sido) {
             ArrayList<ZipDto> gugunList = new ArrayList<>();
             Connection conn = null;
             PreparedStatement pstmt = null;
             ResultSet rs = null;
             try {
            	 	  conn=DBManager.getConnection();
                      String query = "select distinct(gugun) from zipcode where sido = \'" + sido + "\' order by gugun";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      while(rs.next()){
                              ZipDto zipcode = new ZipDto();
                              zipcode.setGugun(rs.getString("GUGUN"));
                              gugunList.add(zipcode);
                      }
             } catch (SQLException e) {
            	 e.printStackTrace();
             }finally{
            	 DBManager.close(conn, pstmt, rs);
            	 
             }              
             return gugunList;         
    }

    // 동데이터=============================================
    public ArrayList<ZipDto> searchDong(String sido, String gugun) {
             ArrayList<ZipDto> dongList = new ArrayList<>();
             Connection conn = null;
             PreparedStatement pstmt = null;
             ResultSet rs = null;
             try {
            	 	  conn=DBManager.getConnection();
                      String query = "select distinct(dong) from zipcode where sido = \'" + sido + "\'  and gugun = \'" + gugun + "\' order by dong";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      while(rs.next()){
                              ZipDto zipcode = new ZipDto();
                              zipcode.setDong(rs.getString("DONG"));
                              dongList.add(zipcode);
                      }
             } catch (SQLException e) {
            	 e.printStackTrace();
             }finally{
            	 DBManager.close(conn, pstmt, rs);
            	 
             }
             return dongList;          
    }

    // 전부주소 데이터 =============================================
    public ArrayList<ZipDto> searchAddress(String sido, String gugun, String dong) {

    	ArrayList<ZipDto> addressList = new ArrayList<>();
    	 Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
        	 	  conn=DBManager.getConnection();
    		String query = "select * from zipcode where sido = \'" + sido + "\'  and gugun = \'" + gugun + "\' and dong = \'" + dong +"\'";

    		pstmt = conn.prepareStatement(query);

    		rs = pstmt.executeQuery();

    		while(rs.next()){

    			ZipDto zipcode = new ZipDto();
    			
    			zipcode.setSeq(rs.getString("seq"));
                zipcode.setZipcode(rs.getString("zipcode"));
                zipcode.setSido(rs.getString("sido"));
	            zipcode.setGugun(rs.getString("gugun"));
	            zipcode.setDong(rs.getString("dong"));
	            zipcode.setRi(rs.getString("ri"));
	            zipcode.setBldg(rs.getString("bldg"));
	            zipcode.setBunji(rs.getString("bungi"));
	            
	            addressList.add(zipcode);
    		}
    	} catch (SQLException e) {
       	 e.printStackTrace();
        }finally{
       	 DBManager.close(conn, pstmt, rs);
       	 
        }
    	return addressList;               
    }

	public ArrayList<ZipDto> searchKeyDong(String dongName) {
		
		ArrayList<ZipDto> addressList = new ArrayList<>();
		 Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
        	conn=DBManager.getConnection();
    		String query = "select ZIPCODE,sido,gugun,dong,NVL(ri,' ')AS ri,NVL(bldg,' ')AS bldg,NVL(bungi,' ')AS bungi,seq "
               + "  from zipcode"
               + " where dong like "
               + " '%'||?||'%' ";
    		
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, dongName);
    		rs = pstmt.executeQuery();

    		while(rs.next()){

    			ZipDto zipcode = new ZipDto();
    			
    			zipcode.setSeq(rs.getString("seq"));
                zipcode.setZipcode(rs.getString("zipcode"));
                zipcode.setSido(rs.getString("sido"));
	            zipcode.setGugun(rs.getString("gugun"));
	            zipcode.setDong(rs.getString("dong"));
	            zipcode.setRi(rs.getString("ri"));
	            zipcode.setBldg(rs.getString("bldg"));
	            zipcode.setBunji(rs.getString("bungi"));
	            
	            addressList.add(zipcode);
    		}
    	} catch (SQLException e) {
       	 e.printStackTrace();
        }finally{
       	 DBManager.close(conn, pstmt, rs);
       	 
        }
             
    	return addressList;  
	}
}

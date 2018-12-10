package com.pg.dbinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataInfo {

	public DataInfo() {
		//jdbc1단계 : 드라이버로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 성공");		
		} catch (ClassNotFoundException e) {
			System.out.println("1단계 실패");
			e.printStackTrace();
		}
	}
	//jdbc 2단계
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "hkboard2";
		String password = "hkboard";
		conn = DriverManager.getConnection(url, user, password);
		
		// throws SQLException -> 예외를 호출하는곳에 보낸다.
		return conn;
	}
	
	//jdbc6단계
	public void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		try {
			if(rs != null) {rs.close();} 
			if(psmt != null) {psmt.close();}
			if(conn != null) {conn.close();}
			System.out.println("6단계:DB받기 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("6단계:DB받기 실패");
			e.printStackTrace();
			
		}
	}
	
	
	
}

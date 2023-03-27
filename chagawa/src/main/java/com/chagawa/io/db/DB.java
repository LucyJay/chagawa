package com.chagawa.io.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	
	// 접속 정보
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.0.17:1521:xe";
	private static final String ID = "chagawa";
	private static final String PW = "chagawa";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static final String ID = "java";
//	private static final String PW = "java";
	
	private static boolean isCheckDriver;
	
	static {
		try {
			Class.forName(DRIVER);
			isCheckDriver = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of static
	
	// DB.getConnection()
	public static Connection getConnection() throws Exception {
		if(!isCheckDriver) throw new Exception("오라클 드라이버가 존재하지 않습니다.");
		return DriverManager.getConnection(URL, ID, PW);
	}
	
	// 닫기
	public static void close(Connection con, PreparedStatement pstmt) throws SQLException {
		if(con != null) con.close();
		if(pstmt != null) pstmt.close();
	}
	
	// 닫기
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		close(con, pstmt);
		if(rs != null) rs.close();
	}
	
}

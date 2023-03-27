package com.chagawa.io.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.0.17:1521:xe";
	private static final String ID = "chagawa";
	private static final String PW = "chagawa";

	protected Connection con = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(URL, ID, PW);
	}

	public void close() throws SQLException {
		if (con != null)
			con.close();
		if (pstmt != null)
			pstmt.close();
		if (rs != null)
			rs.close();
	}
}

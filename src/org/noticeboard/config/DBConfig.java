package org.noticeboard.config;
import java.sql.*;
public class DBConfig {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	protected CallableStatement cstmt;

	public DBConfig() 
	{
		//		System.out.println("in dbconfig");
		try 
		{			
			Class.forName(PathHelper.p.getProperty("db.driverClass"));

			conn=DriverManager.getConnection(PathHelper.p.getProperty("db.url"),PathHelper.p.getProperty("db.username"),PathHelper.p.getProperty("db.password"));
			System.out.println("Database is connectd");
		}
		catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
	}
}

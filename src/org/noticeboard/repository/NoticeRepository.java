package org.noticeboard.repository;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;

import org.noticeboard.config.DBConfig;
import org.noticeboard.model.CategoryModel;
import org.noticeboard.model.NoticeBoardModel;
import org.noticeboard.model.RegisterModel;
import org.sqlqueries.SQLQueries;


public class NoticeRepository extends DBConfig {

	public boolean AddCategory(CategoryModel cmodel) 
	{
		try(PreparedStatement statement =conn.prepareStatement(SQLQueries.ADD_CATEGORY))
		{
			statement.setInt(1, cmodel.getCid());
			statement.setString(2, cmodel.getCaname());			
			int ret=statement.executeUpdate();
		return ret>0?true:false;

		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean AddNotice(NoticeBoardModel nmodel) {


		try (PreparedStatement statement = conn.prepareStatement(SQLQueries.ADD_NOTICE)) {

//			statement.setInt(1, nmodel.getNoticeId());
//			statement.setInt(2, nmodel.getCategoryId());
			statement.setString(1, nmodel.getTitle());
			statement.setString(2,nmodel.getDescription());
			statement.setString(3, nmodel.getPublishDate());
			statement.setString(4, nmodel.getDisableDate());
			statement.setInt(5,nmodel.getCatId() );
			statement.setInt(6, nmodel.getDesignationId());
			int ret = statement.executeUpdate();
			System.out.println("Notice added successfully."+ret);
			//            if()
				//            {
				//            	return true;
				//            }else {
			//            	return false;
			//            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean RegisterStudent(RegisterModel reg) 
	{
		//		String query = ";

		try(PreparedStatement statement=conn.prepareStatement(SQLQueries.REGISTER_STUDENT))  {


			statement.setString(1, reg.getUsername());
			statement.setString(2, reg.getPassword());
			statement.setString(3, reg.getEmail());
			statement.setString(4, reg.getCnum());
			statement.setDate(5,Date.valueOf(LocalDate.now()));

			int value= statement.executeUpdate();
			return value>0?true:false; 

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean studentpresent(String uname,String pass)
	{
		try(PreparedStatement statement=conn.prepareStatement(org.sqlqueries.SQLQueries.STUDENT_LOGIN)) {

			statement.setString(1,uname);
			statement.setString(2,pass);

			ResultSet resultset=statement.executeQuery();
			if(resultset.next())
			{
				return true;
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
			//			return false;
		}
		return false;
	}

	public boolean RegisterTeacher(RegisterModel reg) 
	{
		//		String query="INSERT INTO userregistration (UserName, Password,EmailId,ContactNumber,RegistrationDate) VALUES (?,?,?,?,?)";
		try (PreparedStatement statement=conn.prepareStatement(org.sqlqueries.SQLQueries.REGISTER_TEACHER))
		{
			//			stmt=conn.prepareStatement(query);
			statement.setString(1, reg.getUsername());
			statement.setString(2, reg.getPassword());
			statement.setString(3, reg.getEmail());
			statement.setString(4, reg.getCnum());
			statement.setDate(5,Date.valueOf(LocalDate.now()));
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean Teacherpresent(String uname,String pass) 
	{
		try(PreparedStatement statement=conn.prepareStatement(org.sqlqueries.SQLQueries.TEACHER_LOGIN))
		{
			//			stmt=conn.prepareStatement("select *from userregistration where username=? AND password=?");
			statement.setString(1, uname);
			statement.setString(2, pass);

			ResultSet resultset=stmt.executeQuery();
			if(resultset.next()) 
			{
				return true;
			}		
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}


	public boolean RegisterPrincipal(RegisterModel reg) 
	{
		//		String query="INSERT INTO userregistration (UserName, Password,EmailId,ContactNumber,RegistrationDate) VALUES (?,?,?,?,?)";
		try(PreparedStatement statement=conn.prepareStatement(org.sqlqueries.SQLQueries.REGISTER_PRINCIPAL))
		{
			//			stmt=conn.prepareStatement(query);
			statement.setString(1, reg.getUsername());
			statement.setString(2, reg.getPassword());
			statement.setString(3, reg.getEmail());
			statement.setString(4, reg.getCnum());
			statement.setDate(5,Date.valueOf(LocalDate.now()));

			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean Principalpresent(String uname,String pass) 
	{
		try(PreparedStatement statement=conn.prepareStatement(org.sqlqueries.SQLQueries.PRINCIPAL_LOGIN)) 
		{
			//			stmt=conn.prepareStatement("select *from userregistration where username=? AND password=?");
			statement.setString(1, uname);
			statement.setString(2, pass);

			ResultSet resultset=stmt.executeQuery();
			if(resultset.next()) 
			{
				return true;
			}		
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean Deletenotice(int nid) 
	{
		try(PreparedStatement statement=conn.prepareStatement(org.sqlqueries.SQLQueries.DELETE_NOTICE))
		{
			//			stmt=conn.prepareStatement("DELETE FROM notice where NId=?");
			statement.setInt(1, nid);
			statement.executeUpdate();


		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean UpdateNotice(NoticeBoardModel nmodel,int nid)
	{
		try
		{
			PreparedStatement statement=conn.prepareStatement(SQLQueries.UPDATE_NOTICE);
			statement.setInt(2, nid);
			statement.setString(1, nmodel.getupdateTitle());

			int ret = statement.executeUpdate();
			
			return ret>0?true:false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public int ischeckdata(String designation, String category) {
		
		try
		{
			
			PreparedStatement statement=conn.prepareStatement(SQLQueries.Check_Des);
			statement.setString(1, designation);
			ResultSet ret = statement.executeQuery();
			if(ret.next())
			{
				return ret.getInt(1);
			}
			else
			{
				return 0;
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public int ischeckdatacat(String designation, String category) {
		try
		{
	PreparedStatement statement1=conn.prepareStatement(SQLQueries.Check_Cat);
	statement1.setString(1, category);
	ResultSet rs = statement1.executeQuery();
	if(rs.next())
	{
		return rs.getInt(1);
	}
	else
	{
		return 0;
	}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return 0;
		}
	
	}
}




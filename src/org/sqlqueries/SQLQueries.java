package org.sqlqueries;

public class SQLQueries {
	public static final String ADD_CATEGORY="INSERT INTO category(CID,CategoryName)VALUES(?,?)";
	public static final String ADD_NOTICE="INSERT INTO notice (title,description,publish,disable,CID,did)VALUES(?,?, ?, ?,?,?)";
	public static final String REGISTER_STUDENT ="INSERT INTO user (uid, uname,email,contact,username,password,did) VALUES (?,?,?,?,?,?,?)";
	public static final String STUDENT_LOGIN="select *from user where username=? AND password=?";
	public static final String REGISTER_TEACHER="INSERT INTO user (uid, uname,email,contact,username,password,did) VALUES (?,?,?,?,?,?,?)";
	public static final String TEACHER_LOGIN="select *from user where username=? AND password=?";
	public static final String REGISTER_PRINCIPAL="INSERT INTO user (uid, uname,email,contact,username,password,did) VALUES (?,?,?,?,?,?,?)";
	public static final String PRINCIPAL_LOGIN="select *from user where username=? AND password=? ";
	public static final String DELETE_NOTICE="DELETE FROM notice where NId=? ";
	public static final String UPDATE_NOTICE="UPDATE notice SET title = ? WHERE nid = ?"; 
	public static final String Check_Des="select *from designation where dname=?";
	public static final String Check_Cat="select *from category where CategoryName=?";
}
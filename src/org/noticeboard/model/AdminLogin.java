package org.noticeboard.model;

import java.util.Scanner;
public class AdminLogin {

	private String AdminUsername ;
	private String Password;
	private String name;
	private String connum;
	private String Emaiid;

	public String getAdminUsername() {
		return AdminUsername;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public String getName() {
		return name;
	}

	public String getConnum() {
		return connum;
	}

	public String getEmaiid() {
		return Emaiid;
	}

	public static AdminLogin getObjAdmin() {
		return objAdmin;
	}
	
	private static AdminLogin objAdmin = null;
	private AdminLogin()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter The Admin Name:");
		name=sc.nextLine();
		
		System.out.println("Enter The Admin contact number");
		connum=sc.nextLine();
		
		System.out.println("Enter The Admin Email Id :");
		Emaiid=sc.nextLine();
		
		System.out.println("Enter The Admin username:");
		AdminUsername=sc.nextLine();
		
		System.out.println("Enter the Admin Password:");
		Password=sc.nextLine();
	}
	public static synchronized  AdminLogin getobjadminlogin()
	{
		if(objAdmin==null) {
			objAdmin = new AdminLogin();
		}
		return objAdmin;
	}
}

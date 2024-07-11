package org.noticeboard.data;

import java.util.Scanner;

import org.noticeboard.model.*;
import org.noticeboard.repository.NoticeRepository;

public class NoticeData {


	NoticeBoardModel noticedata = new NoticeBoardModel();

	NoticeRepository  noticeRepo = new NoticeRepository();   // instanse verbal  
	// int ino=10;
	Scanner sc = new Scanner(System.in);
	
	public boolean addCategory(CategoryModel cmodel) 
	{
		NoticeRepository  noticeRepo = new NoticeRepository();
		return noticeRepo.AddCategory(cmodel);
	}
		
	public boolean addNotice(NoticeBoardModel nmodel)
	{
		NoticeRepository  noticeRepo = new NoticeRepository();
		return noticeRepo.AddNotice(nmodel);
	}

	public boolean registerStudent(RegisterModel reg) 
	{
		NoticeRepository noticeRepo=new NoticeRepository();
		return noticeRepo.RegisterStudent(reg);
	}
	
	public boolean StudentLogin() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username:");
		String uname=sc.nextLine();


		System.out.println("Enter the password:");
		String pass=sc.nextLine();

		boolean b=noticeRepo.studentpresent(uname,pass);
		if(b) 
		{
			return b;
		}
		else 
		{
			return b;
		}
	}
	//This method is use for RegisterStaff
	public boolean registerTeacher(RegisterModel reg) 
	{
		NoticeRepository noticeRepo=new NoticeRepository();
		return noticeRepo.RegisterTeacher(reg);
	}

	// This Method is use for Staff Login

	public boolean TeacherLogin() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username:");
		String uname=sc.nextLine();

		System.out.println("Enter the passsword:");
		String pass=sc.nextLine();

		boolean b=noticeRepo.Teacherpresent(uname, pass);
		if(b) 
		{
			return b;
		}
		else 
		{
			return b;
		}
	}

	public boolean registerPrincipal(RegisterModel reg) 
	{
		NoticeRepository noticeRepo=new NoticeRepository();
		return noticeRepo.RegisterPrincipal(reg);
	}

	// This Method is use for Staff Login

	public boolean PrincipalLogin() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username:");
		String uname=sc.nextLine();

		System.out.println("Enter the passsword:");
		String pass=sc.nextLine();

		boolean b=noticeRepo.Principalpresent(uname, pass);
		if(b) 
		{
			return b;
		}
		else 
		{
			return b;
		}
	}
	public boolean DeleteNotice(int nid) 
	{
		NoticeRepository noticeRepo=new NoticeRepository();
		return noticeRepo.Deletenotice(nid);
	}
	public boolean Updatenotice(NoticeBoardModel nmodel,int nid)
	{
		NoticeRepository noticeRepo=new NoticeRepository();
		return noticeRepo.UpdateNotice(nmodel,nid);
		
	}

	public int ischeckdata(String designation, String category) {
		NoticeRepository noticeRepo=new NoticeRepository();	
		return noticeRepo.ischeckdata(designation,category);
	}

	public int ischeckdatacat(String designation, String category) {
		NoticeRepository noticeRepo=new NoticeRepository();	
		return noticeRepo.ischeckdatacat(designation,category);
	}

}



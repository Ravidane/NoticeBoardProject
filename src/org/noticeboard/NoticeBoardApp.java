package org.noticeboard;
import java.sql.Timestamp;
import java.util.*;

import org.noticeboard.data.NoticeData;
import org.noticeboard.model.AdminLogin;
import org.noticeboard.model.CategoryModel;
import org.noticeboard.model.NoticeBoardModel;
import org.noticeboard.model.RegisterModel;
import org.noticeboard.repository.NoticeRepository;


public class NoticeBoardApp{

	//	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		RegisterModel reg = new RegisterModel();
		CategoryModel cmodel=new CategoryModel();
		NoticeBoardModel nmodel=new NoticeBoardModel();
		// pojo ob data store
		NoticeData ndata  = new  NoticeData();      // to call register admin
		do 
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("\n------------------------******WELCOME TO THE NOTICE BOARD******-----------------------------");
			System.out.println("Enter 1:Admin Login");
			System.out.println("Enter 2:Register Student and if Already Register then Enter 3:Login");
			System.out.println("Enter 3:Login Student");
			System.out.println("Enter 4:Register Teacher and if Already Register then Enter 5: Login");
			System.out.println("Enter 5:Login Teacher");
			System.out.println("Enter 6:Register Principal and if Already Register then Enter 6: Login");
			System.out.println("Enter 7:Login Principal");
			System.out.println("Enter your choice "); 
			int choice=sc.nextInt();

			switch(choice) 
			{
			case 1:
			{
				System.out.println("----------------------Registration Admin-----------------------------");
				AdminLogin objAdmin = AdminLogin.getobjadminlogin();

				
				System.out.println("--------------------------Login Admin-------------------------------");
				sc.nextLine();
				System.out.println("Enter username:");
				String name=sc.next();
				System.out.println("Enter password:");
				String pass=sc.next();
				
				if(objAdmin.getPassword().equals(pass) && objAdmin.getAdminUsername().equals(name))
				{
					System.out.println("Admin Login successfully......");
					int choice1 = 0;
					do
					{
						System.out.println("\nEnter 1:Add category");
						System.out.println("Enter 2:Add Notice");
						System.out.println("Enter 3:delete Notice");
						System.out.println("Enter 4:Update Notice");
						System.out.println("Enter Your Choice");
						System.out.println("Enter 0:Come to Login Page");
						choice=sc.nextInt();
						if(choice1==0) 
						{
							System.out.println("You are Exit from Notice page");
						}
						switch(choice)
						{
						case 1:
						{
							sc.nextLine();
							System.out.println("Enter the category ID:");
							int caid=sc.nextInt();
							cmodel.setCid(caid);
							
							System.out.println("Enter the category Name:");
							String cname=sc.next();
							cmodel.setCaname(cname);
							
							boolean res=ndata.addCategory(cmodel);
							if(res) 
							{
								System.out.println("Category Adds Successfully");
							}
							else 
							{
								System.out.println("Not Added");
							}
							break;													
						}
						case 2:
						{
							sc.nextLine();
//							System.out.println("Enter the Notice Id:");
//							int nid=sc.nextInt();
//							nmodel.setNoticeId(nid);
//							sc.nextLine();
							
//							System.out.println("Enter the Category Id:");
//							int cid=sc.nextInt();
//							nmodel.setCategoryId(cid);
							
							System.out.println("Enter your Desigantion:");
							String designation=sc.nextLine();
							
							System.out.println("Enter your Category:");
							String category=sc.nextLine();
							
							int  b=(int) ndata.ischeckdata(designation,category);
							int c=ndata.ischeckdatacat(designation ,category);
							if((b >0) &&(c>0))
							{
							sc.nextLine();
							System.out.println("Enter the Title:");
							String title=sc.nextLine();
							nmodel.setTitle(title);
							
							sc.nextLine();
							System.out.println("Enter the Description: ");
							String des=sc.nextLine();
							nmodel.setDescription(des);
														
							sc.nextLine();				
							System.out.println("Enter the publish date:");
							String publishDatestr=sc.nextLine();
							nmodel.setPublishDate(publishDatestr);;
							
							sc.nextLine();
							System.out.println("Enter the disable date:");
							String disableDatestr=sc.nextLine();
							nmodel.setDisableDate(disableDatestr);
							nmodel.setCatId(c);
							nmodel.setDesignationId(b);
							boolean ret = ndata.addNotice(nmodel);
							if(!ret) 
							{
								System.out.println("New notice  Added successfully");
							}			    	 
							else 
							{
								System.out.println("dosent add");
							}
							}
							else
							{
								System.out.println("Please add Category...");
							}
							break;

						}
						case 3:
						{
							System.out.println("Enter the notice ID:");
							
							int nid=sc.nextInt();
							boolean ret=ndata.DeleteNotice(nid);
							if(!ret) 
							{
								System.out.println("Notice delete successfully................");
							}
							else 
							{
								System.out.println("Notice Id missing");
	
							}
						
							break;
						}
						case 4:
						{
							sc.nextLine();
							System.out.println("Enter the notice Id:");
							int nid=sc.nextInt();
							
							System.out.println("Enter the Title:");
							String ti=sc.next();
							nmodel.setupdateTitle(ti);
//							System.out.println(nmodel.getTitle());
//							sc.nextLine();
							
							boolean ret=ndata.Updatenotice(nmodel,nid);
							if(ret)
							{
								System.out.println("Notice Updated SucessFully.............");
							}
							else
							{
								System.out.println("notice not updated some problem are there");
							}
							
							break;
						}
						default:
						{
							System.out.println("Invalid choice");
						}
						}
					}while(choice!=0);
				}
				else
				{
					System.out.println("Please Cheack username and password...");
				}
			}
			break;	

			case 2:
			{
				sc.nextLine();
				System.out.println("\n---------------------Student Registration--------------------");
				

				System.out.println("Enter the username:");
				String username=sc.nextLine();
				reg.setUsername(username);

				System.out.println("Enter the password:");
				String password=sc.nextLine();
				reg.setPassword(password);

				System.out.println("Enter the User Email ID:");
				String email=sc.nextLine();
				reg.setEmail(email);

				System.out.println("Enter the contact number");
				String cnum=sc.nextLine();
				reg.setCnum(cnum);

				boolean res=ndata.registerStudent(reg);
				if(res) 
				{
					System.out.println("Student Register successfully..............");
				}
				else 
				{
					System.out.println("Failed to Register");
				}
				break;
			}
			case 3:
			{
				sc.nextLine();
				System.out.println("\n----------------------Login Student--------------------------");
				boolean b= ndata.StudentLogin();
				int choice2;

				if(b) 
				{
					System.out.println("\nStudent Login Successfully...........");
					int choice3=0;
					do 
					{
						System.out.println("Enter :1 for view notice");
						System.out.println("Enter :0 for come to Login Page");
						System.out.println("Enter your choice:");
						choice2=sc.nextInt();
						if(choice3==0) 
						{
							System.out.println("you are Exit from notice view page");
						}
						switch(choice2) 
						{
						case 1:
						{
							
						}
						}
					}
					while(choice2!=0);
				}
				else 
				{
					System.out.println("Failed to login");
				}
				break;			
			}
			case 4:
			{
				sc.nextLine();
				System.out.println("\n-------------------------Teacher Registration-------------------------");

				System.out.println("Enter the username:");
				String username=sc.nextLine();
				reg.setUsername(username);

				System.out.println("Enter the password:");
				String password=sc.nextLine();
				reg.setPassword(password);

				System.out.println("Enter the User Email ID:");
				String email=sc.nextLine();
				reg.setEmail(email);

				System.out.println("Enter the contact number");
				String cnum=sc.nextLine();
				reg.setCnum(cnum);

				boolean res=ndata.registerTeacher(reg);
				if(res) 
				{
					System.out.println("Teacher Register Successfully..............");
				}
				else 
				{
					System.out.println("Failed to Register");
				}	
				break;
			}
			case 5:
			{
				sc.nextLine();
				System.out.println("-----------------------Teacher Login------------------------");
				boolean b=ndata.TeacherLogin();
				if(b) 
				{
					System.out.println("Teacher Login successfully");
				}
				else 
				{
					System.out.println("Failed to Login");
				}
				break;
			}
			case 6:
			{
				sc.nextLine();
				System.out.println("\n-------------------------Principal Registration-------------------------");
//				System.out.println("Enter the userId:");
				

				System.out.println("Enter the username:");
				String username=sc.nextLine();
				reg.setUsername(username);

				System.out.println("Enter the password:");
				String password=sc.nextLine();
				reg.setPassword(password);

				System.out.println("Enter the User Email ID:");
				String email=sc.nextLine();
				reg.setEmail(email);

				System.out.println("Enter the contact number");
				String cnum=sc.nextLine();
				reg.setCnum(cnum);

				boolean res=ndata.registerPrincipal(reg);
				if(res) 
				{
					System.out.println("Principal Register Successfully..............");
				}
				else 
				{
					System.out.println("Failed to Register");
				}	
				break;
			}
			case 7:
			{
				sc.nextLine();
				System.out.println("-----------------------Principal Login------------------------");
				boolean b=ndata.PrincipalLogin();
				if(b) 
				{
					System.out.println("Principal Login successfully");
				}
				else 
				{
					System.out.println("Failed to Login");
				}
				break;
			}

			default:
			{
				System.out.println("Wrong choice");
			}

			}
		} // dowhile
		while(true);
	}
}



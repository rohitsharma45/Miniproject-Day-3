package com.cg.miniproject.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;



import com.cg.miniproject.bean.MacBean;
import com.cg.miniproject.bean.MiniprojectBean;
import com.cg.miniproject.service.IMiniprojectService;
import com.cg.miniproject.service.MiniprojectServiceImpl;

public class Controller {

	static Scanner sc=new Scanner(System.in);
	static MiniprojectBean bean=null;
	static MacBean mac=null;
	
	
	
	public static void main(String[] args) {
		Controller  c=new Controller();
		bean=new MiniprojectBean();
		mac=new MacBean();
		ArrayList<MacBean> list=new ArrayList<MacBean>();
		ArrayList<String> list1=new ArrayList<String>();
		int res=0;
		IMiniprojectService service=new MiniprojectServiceImpl();
		
		
	
		System.out.println("Enter your role");
		System.out.println("\n 1.Applicant"
						  +"\n 2.MAC"
						  +"\n 3.Admin"
						  +"\n 4.Exit");
		int role=sc.nextInt();
		switch(role){
		
		case 1:
			System.out.println("\n 1.Mumbai"
						  	  +"\n 2.Pune"
						  	  +"\n 3.Delhi"
						  	  +"\n 4.Hyderabad"
						  	  +"\n 5.Exit");
			System.out.println("Enter your desired university:");
			int university=sc.nextInt();
			
			
			switch(university){
			
			
			
			case 1:
				list1=service.retrieveDetails();
				System.out.println("Program Courses available are: "+"\n");
				for(String l:list1){
					System.out.println(l+"\t");
				}
				
				System.out.println("Enter your desired program course");
				System.out.println("\n 1.EXTC(E100)"
						+ "\n 2.IT(I100)"
						+ "\n 3.Exit");
				
				int course=sc.nextInt();
				
				switch(course){
				
				case 1:
					String programId=null;
					System.out.println("Application form for EXTC course");
					bean=c.fillForm();
					programId=service.getId("E100");
					bean.setProgramId(programId);
					bean.setStatus("Applied");
					bean.setInterviewDate(null);
					res=service.insertData(bean);
					System.out.println("Your application id is:"+res);
					break;
					
				case 2:
					System.out.println("Application form for IT course");
					bean=c.fillForm();
					programId=service.getId("I100");
					bean.setProgramId(programId);
					bean.setStatus("Applied");
					bean.setInterviewDate(null);
					res=service.insertData(bean);
					System.out.println("Your application id is:"+res);
					break;
					
				case 3:
					System.exit(0);
					break;
				}
				
				
			}
		break;
		case 2:
			boolean b=true;
			System.out.println("Enter the login id");
			String id=sc.next();
			mac.setLoginId(id);
			
			System.out.println("Enter the password");
			mac.setPassword(sc.next());
			
			b=service.checkLogin(mac);
			System.out.println(b);
			
			if(b==true)
				System.out.println("Authenticated");
			else
				System.out.println("Wrong credentials");
			break;
			
		case 3:
			boolean d=true;
			System.out.println("Enter the login id");
			String login=sc.next();
			mac.setLoginId(login);
			System.out.println("Enter the password");
			mac.setPassword(sc.next());
			d=service.checkAdminLogin(mac);
			System.out.println(d);
			
			if(d==true)
				System.out.println("Authenticated");
			else
				System.out.println("Wrong credentials");
			break;
			
		case 4:
			System.exit(0);
			break;
		}
		
			
	}
	
	public MiniprojectBean fillForm()
	{	
		bean=new MiniprojectBean();
		System.out.println("Enter your full name");
		String fullName=sc.next()+" ";
		bean.setFullName(fullName);
		sc.nextLine();
		System.out.println("Enter your date of birth in this dd-mm-yyyy format");
		String dob=sc.nextLine();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		try {
			LocalDate date=LocalDate.parse(dob,df);
			Date d=Date.valueOf(date);
			
			
			bean.setDateOfBirth(d);
		} catch (DateTimeParseException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Enter the highest qualification");
		String qualification=sc.next();
		bean.setQualification(qualification);
		System.out.println("Enter the marks obtained");
		int marksObt=sc.nextInt();
		bean.setMarks(marksObt);
		sc.nextLine();
		System.out.println("Enter the goals");
		String goals=sc.nextLine();
		bean.setGoals(goals);
		System.out.println("Enter your emailid");
		String emailId=sc.next();
		bean.setEmail(emailId);
		return bean;
	}
}

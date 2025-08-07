package careplus.zsgs.target.receptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import careplus.zsgs.dto.Receptioinist;
import careplus.zsgs.target.home.HomeView;
import careplus.zsgs.target.home.HomeView;
public class ReceptionistView {
	
private ReceptionistModel model;
private Scanner scanner= new Scanner(System.in);

	public ReceptionistView()
	{
		model=new ReceptionistModel(this);
	}
	
	public void init() {
		receptionistReg();	
	}


	 void receptionistReg() {
		System.out.println("=== Add Receptionist list===");
		Receptioinist receptioinist = new Receptioinist();
		//receptioinist.setId(getId());
		receptioinist.setName(getName());
		receptioinist.setPassword(getPassword());
		model.receptioinistInfo(receptioinist);
		
	}
	
//	 private int getId()
//	 {
//		 int id=0;
//		 System.out.println("Enter the Receptioinist Id");
//		 do
//		 {
//			id=scanner.nextInt();
//			scanner.nextLine();
//			if(id<1 || id>=10)
//			{
//				System.out.println("Receptionist id Between 1 to 10");
//			}
//			else break;	
//		 }while(true);
//		 return id;
//	 }
//	 
	
	private String getName()
	{
		String name="";
		do 
		{	System.out.println("Enter your Name");
			name=scanner.nextLine();
			if(name.length()<3|| name.length()>=20)
				System.out.println("Name must be between min 3 and max 20");
			else break;
		}while(true);
		return name;
	}
	
	private String getPassword()
	{
		String password="";
		do {
			System.out.println("Entre password");
			password=scanner.nextLine();
			if(password.length()<5|| password.length()>=20)
				System.out.println("Password must me bewtten min 5 and max 8");
			else break;
			
		}while(true);
		
		
		String confrimpassword="";
		do
		{	System.out.println("Entre confrim password");
			confrimpassword=scanner.nextLine();
			if(!password.matches(confrimpassword))
				System.out.println("Confrim password not match\nEntre confrim password");
			else break;
		}while(true);
		return password;
	}

	public void showMessage(String string) {
		System.out.println(string);
		HomeView homeView = new HomeView();
		homeView.init();
		
		
		
	}
	
	public void prosessLogin()
	 {
		 System.out.println("===Reception Login===");
		String userName=getUserName();
		String password=getPaasword();
		model.validReceptionLogin(userName,password);
		 
		
	 }

	private String getPaasword() {
		System.out.println("Entre user password");
		String name=scanner.next();
		return name;
	}

	private String getUserName() {
		System.out.println("Entre Username");
		String password=scanner.next();
		return password;
	}

	public void loginSuccessFull(String string) {
		System.out.println(string);
		new careplus.zsgs.careplusSetupForReceptionist.CarePlusSetUpView().init();
		
	}

	

	public void respLoginSucessFull(String string) {
		
		System.out.println(string);
		HomeView homeView = new HomeView();
		homeView.init();
	}

	

}

package careplus.zsgs.target.admin;
import java.util.Scanner;

import careplus.zsgs.careplusSetupForAdmin.CarePlusSetUpView;
import careplus.zsgs.dto.AdminUser;
public class AdminView {
	
	private AdminModel model;
	private Scanner scanner=new Scanner(System.in);
	 public AdminView()
	{
		model=new AdminModel(this);
	}
	
	
	public void init()
	{
		model.init();
	}
	 void processAdminInfo() {
		 System.out.println("===Admin Menu===");
		String userName=getUserName();
		String password=getPassword();
		model.adminInfo(userName,password);
		
	}
	

	private String getPassword() {
		System.out.println("Enter Admin Password");
		String userName="";
		userName=scanner.nextLine();
		return userName;
	}


	private String getUserName() {
		System.out.println("Enter Admin Name");
		String password="";
		password=scanner.nextLine();
		return password;
	}


	public void loginSucessful(String string) {
		
		System.out.println("Welcome to CarePlus: "+string);
		CarePlusSetUpView carePlusSetUpView = new CarePlusSetUpView();
		carePlusSetUpView.init();
	}


	public void showMessage(String string) {
		System.out.println(string);
		
	}

	

}

package careplus.zsgs.core.admin;
import java.util.Scanner;
import careplus.zsgs.careplusSetup.CarePlusSetUpView;
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
		 AdminUser admin = new AdminUser();
		 admin.setName(getName());
		 admin.setPassword(getPassword());	 
		 model.adminInfo(admin);
		
	}
	private String getName()
	{
		String name="";
		System.out.println("Entre your Name");
		do {
			name=scanner.nextLine();
			 if(name.length()<3|| name.length()>=50)
			
				System.out.println("Entre your name between min 3 to max 50\nEntre valid your name");
			else break;
		}    
		while(true);
		return name;
	}
	
	private String getPassword()
	{
		String password="";
		System.out.println("Enter password");

		do {
			password=scanner.nextLine();		
			if(password.length()<8||password.length()>=20)
				System.out.println("Entre between min 8 and max 20 \nEnter valid password");
			else break;
		}while(true);
		
		String confrimPassword="";
	
		do {
			System.out.println("Entre confrim password");
			confrimPassword=scanner.nextLine();
			if(!password.equals(confrimPassword))
				System.out.println("Confrim password is not match \nEntre valid password");
				else break;
		}while(true);
		return password;
				
	}

	public void loginSucessful(String string) {
		
		System.out.println(string);
		CarePlusSetUpView carePlusSetUpView = new CarePlusSetUpView();
		carePlusSetUpView.init();
	}

	



}

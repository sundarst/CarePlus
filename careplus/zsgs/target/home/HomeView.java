package careplus.zsgs.target.home;

import java.util.Scanner;
import careplus.zsgs.target.admin.AdminView;
public class HomeView {
	
	private HomeModel model;
	private final Scanner scanner= new Scanner(System.in);
	
	public HomeView()
	{
		model=new HomeModel(this);
	}
	
	
	public void init()
	{
		homeMenu();
	}
	public void homeMenu()
	{
		try
		{
		while(true)
		{
			System.out.println("1.Admin");
			System.out.println("2.Receptionist");
			
			int choic=0;
			choic = Integer.parseInt(scanner.nextLine());
			
			switch(choic)
			{
			case 1:
				
		     	new careplus.zsgs.target.admin.AdminView().init();
				break;
			case 2:
					new careplus.zsgs.target.receptions.ReceptionistView().prosessLogin();
				break;
			default :
				System.out.println("Number not Found Enter Number 1 or 2 only");
			
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("Number not found Error: "+e);
		}
	}

}

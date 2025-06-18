package careplus.zsgs.baseClass;

public class BaseClassView {
	
	public static  void exit()
	{
		System.exit(0);
		System.out.println("Thank you for visiting Care Plus");
	}
	public static  void logout()
	{
		new  careplus.zsgs.core.admin.AdminView().init();
		System.out.println("Logout sucessfully");
	}

}

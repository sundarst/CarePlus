package careplus.zsgs.target.admin;
import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.AdminUser;
 class AdminModel {
	 
	private AdminView view;
	AdminModel(AdminView view) {
		this.view=view;
	}
	
	public void init() {
		
			view.processAdminInfo();
		
		
	}
	
public void adminInfo(String userName, String password) {
	if(CarePlusDb.getInstance().getUserName().equals(userName)&&CarePlusDb.getInstance().getPassword().equals(password))
	{
		view.loginSucessful(userName);
	}
	else
	{
		view.showMessage("Admin name does not match");
	}
	
}

 }
	
	
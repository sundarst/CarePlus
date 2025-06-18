package careplus.zsgs.core.admin;
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
	
public void adminInfo(AdminUser admin) {
		
			CarePlusDb.getInstance().setAdminUser(admin);
			view.loginSucessful("Login successful");
	}

 }
	
	
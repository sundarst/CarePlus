package careplus.zsgs.target.receptions;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Receptioinist;
public class ReceptionistModel {
	
	private ReceptionistView view;
	ReceptionistModel(ReceptionistView view)
	{
		this.view=view;
	}
	
	
	
	public void receptioinistInfo(Receptioinist receptioinist) 
	{
	
		if(userName(receptioinist.getName()))
		{
			view.showMessage("UserName Already Exit");
		}
		else
		{
		try {
					
			//receptioinist.setUserId(generatedId());
			careplus.zsgs.db.CarePlusDb.getInstance().setReceptioinist(receptioinist);
			 view.respLoginSucessFull("Receptionist Add sucessfully");

		
           	}
		catch(Exception e)
        {
	       view.showMessage("Error handling exception"+e.getMessage());
     	}
	    }
	}
	
	private boolean userName(String name)
	{	
		return false;
		
	}



	public void validReceptionLogin(String userName, String password) {
		
		List<Receptioinist> receptioinist = CarePlusDb.getInstance().getReceptioinist();
		
		if(receptioinist==null || receptioinist.isEmpty())
		{
			view.showMessage("No receptionist available");
			
		}
		
		for(Receptioinist r:receptioinist)
		{
			if(r.getName().equalsIgnoreCase(userName)&& r.getPassword().equals(password))
			{
				view.loginSuccessFull("Login successful");
				return;
			}
		}
		
		view.showMessage("UserName or password does not match");
	}

	
//	private String generatedId()
//	{
//		return "RES"+ UUID.randomUUID().toString().substring(0,8).toUpperCase();
//	}
}

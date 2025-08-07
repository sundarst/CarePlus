package careplus.zsgs.target.admin;

import java.util.Scanner;
import careplus.zsgs.target.home.HomeView;
import careplus.zsgs.careplusSetupForAdmin.CarePlusSetUpView;
public class DeleteReceptionsView {
	
	private DeleteReceptionsModel model;
	private Scanner scanner=new Scanner(System.in);
	public DeleteReceptionsView()
	    {
		   model=new DeleteReceptionsModel(this);
	    }

	public void init() {
		DeleteRescptionst();
		
	}

	private void DeleteRescptionst() {
		System.out.println("Enter the Receptionist Id");
		int number=getNumber();
		
		model.deleteReceptionist(number);
	}

	private int getNumber() {
		
		 int id=0;
		 System.out.println("Enter the Receptioinist Id");
		 do
		 {
			id=scanner.nextInt();
			if(id>=1 || id<=10)
			{
				break;
			}
			else
			{
				System.out.println("Receptionist id to delete\nEnter valid Receptionist id");
			}
		 }while(true);
		 return id;
	 }

	public void deleteReception(boolean found) {
		if(found)
		{
			System.out.println("User id is delete sucessfully");
		}
		else
		{
			System.out.println("User Id not found");
		}
		
		 CarePlusSetUpView carePlusSetUpView = new CarePlusSetUpView();
		 carePlusSetUpView.init();
		
	}
	

}

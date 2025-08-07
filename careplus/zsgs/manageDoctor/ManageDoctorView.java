package careplus.zsgs.manageDoctor;

import java.util.List;
import java.util.Scanner;

import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Doctors;

public class ManageDoctorView {
	
private ManageDoctorModel model;
private Scanner scanner=new Scanner(System.in);
     public	ManageDoctorView()
    	{
    	 model=new ManageDoctorModel(this);
    			 
	    }
     
     public void init()
     {
    	 manageDoctor();
     }

	private void manageDoctor() {
		int choic=0;
		do
		{
			System.out.println("1.View Doctors availablity");
			System.out.println("2.Mange Doctors appointment scheduling");
			System.out.println("3.Back to Main menu");
			choic=0;
			choic=Integer.parseInt(scanner.nextLine());
			
			switch(choic)
			{
			case 1:
				 displayDoctor();
					break;
			case 2:
					new careplus.zsgs.appointmentViewingManagement.AppointmentViewingManagementView().init();
					break;
			case 3:
					new careplus.zsgs.careplusSetupForAdmin.CarePlusSetUpView().init();
					break;
			}
			
		}while(choic!=3);
		
	}
	
	
	
	public void  displayDoctor() {
		
		List<Doctors> doctors=CarePlusDb.getInstance().getDoctors();
		if(doctors==null)
		{
			System.out.println("No doctors data found");
		}
		else
		{
			System.out.printf("%-25s %-25s %-25s %-25s %-25s%n","Id","Name","Mobile Number","Specialization","availableTimeSlots");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			for(Doctors d:doctors)
			{
				System.out.printf("%-25s %-25s %-25s %-25s %-25s%n",
						d.getId(),
						d.getName(),
						d.getMobileNumber(),
						d.getSpecialization(),
						d.getAvailableTimeSlots()
						);
			}
			System.out.println();
		}
		
		
	}
	
	

}

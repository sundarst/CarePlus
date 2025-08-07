package careplus.zsgs.careplusSetupForAdmin;
import java.util.Scanner;
import careplus.zsgs.baseClass.BaseClassView;
import careplus.zsgs.db.CarePlusDb;


public class CarePlusSetUpView extends BaseClassView  {
	private CarePlusSetUpModel model;
	private Scanner scanner= new Scanner(System.in);
	public CarePlusSetUpView()
	{
		model=new CarePlusSetUpModel(this);
	}
	
	public void init()
	{
		//CarePlusDb.getInstance().loadFromFile();
		showMenu();
	}
	public  void showMenu()
	{
		try
		{
		int choic=0;
		do
		{
			
			System.out.println("====Care Plus SetUp===");
			System.out.println("1.Add Doctors");
			System.out.println("2.Manage Doctor");
			System.out.println("3.Add Receptionist");
			System.out.println("4.Delete Receptionist");
			System.out.println("5.Back to main menu");
			System.out.println("6.Add Patient");
			System.out.println("7.Appointment Booking");
			System.out.println("8.Appointment View ManagementView");
			System.out.println("9.Logout");
			System.out.println("10.Exit");
			
			 choic=0;
			choic=Integer.parseInt(scanner.nextLine());
			switch(choic)
			{
			case 1:
				new careplus.zsgs.addDoctor.DoctorView().addDoctor();
				break;
			case 2:
				 new careplus.zsgs.manageDoctor.ManageDoctorView().init();
					break;
			case 3:
				new careplus.zsgs.target.receptions.ReceptionistView().init();
				break;
			case 4:
					new careplus.zsgs.target.admin.DeleteReceptionsView().init();
					break;
			case 5:
				showMenu(); 
				break;
			case 6:
				new careplus.zsgs.target.patientmanagement.PatientManagementView().init();
				break;
			case 7:
					new careplus.zsgs.appointmentBooking.AppointmentBookingView().init();
					break;
			case 8:
				// new  careplus.zsgs.appointmentBooking.AppointmentBookingView().showAllAppointment();
				 new  careplus.zsgs.appointmentViewingManagement.AppointmentViewingManagementView().init();
				 break;
			case 9:
					System.out.println("===Logout===");
					new careplus.zsgs.target.home.HomeView().init();
					break;
			case 10:
					System.out.println("Thank you for using Care Plus");
					System.exit(0);
					break;
			}
		}while(choic!=3);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Enter number not found");
		}
	
	}

}

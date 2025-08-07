package careplus.zsgs.careplusSetupForReceptionist;
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
		showMenu();
	}
	public  void showMenu()
	{
		int choic=0;
		do
		{
			
			System.out.println("====Care Plus SetUp===");
			System.out.println("1.Add Doctors");
			System.out.println("2.Back to main menu");
			System.out.println("3.Add Patient");
			System.out.println("4.Appointment Booking");
			System.out.println("5.Appointment View ManagementView");
			System.out.println("6.Logout");
			System.out.println("7.Exit");
			
			 choic=0;
			choic=Integer.parseInt(scanner.nextLine());
			switch(choic)
			{
			case 1:
				new careplus.zsgs.addDoctor.DoctorView().addDoctor();
				break;
			case 2:
				showMenu();
				break;
			case 3:
				new careplus.zsgs.target.patientmanagement.PatientManagementView().init();
				break;
			case 4:
					new careplus.zsgs.appointmentBooking.AppointmentBookingView().init();
					break;
			case 5:
				// new  careplus.zsgs.appointmentBooking.AppointmentBookingView().showAllAppointment();
				 new  careplus.zsgs.appointmentViewingManagement.AppointmentViewingManagementView().init();
				 break;
			case 6:
				System.out.println("===Logout===");
				new careplus.zsgs.target.home.HomeView().init();
				break;
			case 7:
					System.out.println("Thank you for using Care Plus");
					System.exit(0);
					break;
					
			}
		}while(choic!=3);
		
	}

}

package careplus.zsgs;
import careplus.zsgs.target.home.HomeView;
import careplus.zsgs.appointmentBooking.AppointmentBookingView;
import careplus.zsgs.careplusSetupForAdmin.CarePlusSetUpView;
import careplus.zsgs.target.admin.AdminView;
import careplus.zsgs.careplusSetupForAdmin.CarePlusSetUpView;
import careplus.zsgs.CareDb;
import careplus.zsgs.appointmentViewingManagement.AppointmentViewingManagementView;
public class CarePlus {
public static void main(String[] args) 
{	
		System.out.println("Welcome to CarePlus");
//     	AdminView view = new AdminView ();
//		view.init();
//		
//		CarePlusSetUpView view = new CarePlusSetUpView ();
//		view.init();
//
//		CareDb Db=new CareDb();
//		Db.loadAppointments();
//		Db.loadDoctors();
//		Db.loadPatients();
//		Db.loadReceptionists();
		
		
	    //Db.store();
		
     
		HomeView view = new HomeView();
		view.init();
		

//		CarePlusSetUpView view	= new CarePlusSetUpView();
//		view.init();
		

		
	 	
}
}

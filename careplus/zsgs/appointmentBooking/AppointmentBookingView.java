package careplus.zsgs.appointmentBooking;

import java.util.List;
import java.util.Scanner;
import careplus.zsgs.careplusSetupForReceptionist.CarePlusSetUpView;
import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Appointment;
public class AppointmentBookingView {
	
	private AppointmentBookingModel model;
	private Scanner scanner= new Scanner(System.in);
public 	AppointmentBookingView()
	{
		model= new AppointmentBookingModel(this);
	}
	
	
	public void init()
	{
		booking();
	}


	private void booking() {
		System.out.println("===Appointment Booking===");
		System.out.println("Enter PatientId");
		int padientId= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Doctor Id");
		int doctorId=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Book slot eg:2025-06-21 12:00 PM");
		String dateTime=scanner.nextLine();
		
		model.bookAppointment(padientId,doctorId,dateTime);
		
	}


	public void bookedSuccessfuly() {
		
		CarePlusSetUpView view = new CarePlusSetUpView();
		view.init();
		
	}

 
	public void showAllAppointment() {
		
		List<Appointment> appointment = model.viewallAppointment();
		if(appointment.isEmpty())
		{
			System.out.println("No appointments scheduled");
		}
		else
		{
			System.out.println("==View All Appointments==");
			System.out.printf("%-25s %-25s %-25s%n","PatientId","DoctorId","Date and Time");
			System.out.println("---------------------------------------------------------------------------------------");
			
			for(Appointment a: appointment)
			{
				System.out.printf("%-25s %-25s %-25s%n",
						a.getPatientId(),
						a.getDoctorId(),
						a.getDateTime()
						);
			}
		}
		
	}


	public void showMessage(String string) {
		System.out.println(string);
		
	}
	

	
	
	

}

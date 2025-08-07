package careplus.zsgs.appointmentViewingManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Appointment;
import careplus.zsgs.dto.Doctors;
import careplus.zsgs.dto.PatientManagement;
import careplus.zsgs.CareDb;
import careplus.zsgs.careplusSetupForReceptionist.CarePlusSetUpView;
public class AppointmentViewingManagementView {

	private AppointmentViewingManagementModel model;
	private Scanner scanner=new Scanner(System.in);
	
	
public AppointmentViewingManagementView()
	{
		model=new AppointmentViewingManagementModel(this);
	}
 
	public void init()
	{
		managementMenu();
	}

	public void managementMenu()  
	{
		
		try {
		while(true)
		{
			System.out.println("============AppointmentViewingManagement===========");
			System.out.println("1.View all appointments for a specific patient");
			System.out.println("2.View all appointments scheduled for all doctors");
			System.out.println("3.View all appointments for a specific doctor");
			System.out.println("4.View all available (free) slots for a specific doctor based on their schedule.");
			System.out.println("5.Back to main Menu");
			
			int choic;
			choic=Integer.parseInt(scanner.nextLine());
			
			switch(choic)
			{
			case 1:
				specificPatient();
				break;
			case 2:
				viewAllDoctors();
				break;
			case 3:
				viewSpecificDoctor();
				break;
			case 4:
				avaliableFreeSlot();
				break;
			case 5:
				new careplus.zsgs.careplusSetupForReceptionist.CarePlusSetUpView().init();
				break;
			}
		}
		}catch(NumberFormatException e)
		{
			System.out.println("Enter valid number Between 1 to 5");
		}
	}
	
	
	//View all appointments for a specific patient, including date and time
	public void specificPatient()
	{
		System.out.println("Search Patient id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter date and time");
		String dateTime=scanner.nextLine();
		model.specificPatientAppointment(id,dateTime);
		
	}
	
	public void viewSpecificPatient(int patientId, String dateTime)
	{
		List<PatientManagement> patientManagement=CarePlusDb.getInstance().getPatientManagement();
		List<Appointment> appointment =CarePlusDb.getInstance().getAppointment();
		boolean patientFound=false;
		boolean appointmentFound=false;
		for(PatientManagement p:patientManagement)
		{ 
			if(patientId==p.getId()) {
				patientFound=true;
			for(Appointment a:appointment)
			{		
				System.out.println("Checking the appointment : "+a.getPatientId()+" - "+a.getDoctorId());
				if(a.getPatientId()==patientId && a.getDateTime().equalsIgnoreCase(dateTime)) {
					appointmentFound=true;
				System.out.println("Patient Name: "+p.getName()+
									"| Patient Age: "+p.getAge()+
									"| Patient Place: "+p.getPlace()+
									"| Patient Phone Number: "+p.getContactNumber()+
									"| Appointment Doctor Id: "+a.getDoctorId()+
									"| Appointment Slot: "+a.getDateTime());
				
			
				
				}
			}
			
			}
			
		}
		
		
		if(!patientFound)
		{
			System.out.println("No patient data found");
		}
		else if(!appointmentFound)
		{
			System.out.println("Patient found but Appointment not found");
		}
		
	}
	
	// View all appointments for a specific doctor, with date and time
	void viewSpecificDoctor()
	{
		System.out.println("===View specific Doctor===");
		System.out.println("Enter Doctor id to search");
		int  doctorId=scanner.nextInt();
		scanner.nextLine();
		//System.out.println(" Enter date and time to search");
		//String dateTime=scanner.nextLine();
		
//		System.out.println("Entre time to search");
//		String time=scanner.nextLine();
		
		model.viewSpecificDoctor(doctorId);
		
	}

//	public void viewAllAppointmentSpecificDoctor(int doctorId) {
//		
//		List<Doctors> doctors=CarePlusDb.getInstance().getDoctors();
//		List<Appointment> appointment=CarePlusDb.getInstance().getAppointment();
//		
//			boolean found=false;
//
//			System.out.printf("%-25s %-25s %-25s %n","Doctor Id","Doctor Name","Avaliable Slot");
//			System.out.println("--------------------------------------------------------------------------------------------");
//		for(Doctors d:doctors)
//		{
//			if(doctorId==d.getId())
//			{
//			for(Appointment a:appointment)
//			{
//				if(d.getId()==a.getDoctorId())
//				{	
//					found=true;
//				System.out.printf("%-25s %-25s %-25s %n",
//						d.getId(),
//						d.getName(),
//						a.getDateTime());	
//				}
//			
//			}
//			}
//		}
//			
//			
//		System.out.println();
//	}
//	
	
	//View all available (free) slots for a specific doctor based on their schedule
	void avaliableFreeSlot()
	{	
		try
		{
		System.out.println("==Search free slot to Booked==");
		System.out.println("Enter Doctor Id to search");
		int doctorId=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter date and time to search");
		String dateTime=scanner.nextLine();
		
		model.avaliableFreeSlot(doctorId,dateTime);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public void avaliableFreeSlot(String string) {
		System.out.println(string);
		
		CarePlusSetUpView view =  new CarePlusSetUpView();
		view.init();
		
	}
	
	

	public void avaliableSlotBook(String string) {
		System.out.println(string);
		managementMenu();
		
	}
	
	public void showMessage(String string) {
		System.out.println(string);
		
	}
	
	//View all appointments scheduled for all doctors, with corresponding dates and times
	
	
	void viewAllDoctors()
	{	
		System.out.println("===View All Doctors===");
		List<Doctors> doctors=CarePlusDb.getInstance().getDoctors();
		List<Appointment> appointment=CarePlusDb.getInstance().getAppointment();
		

		System.out.printf("%-25s %-25s %-25s %n","Doctor Id","Doctor Name","Avaliable Slot");
		
		for(Doctors d:doctors)
		{
			for(Appointment a:appointment)
			{
				if(d.getId()==a.getPatientId())// avoid 4*3
				{		
				System.out.printf("%-25s %-25s %-25s %n",
									d.getId(),
									d.getName(),
									a.getDateTime());
				}
			}
			
		}
	}

	public void showAppointment(List<Appointment> e) {
		
		new careplus.zsgs.target.patientmanagement.PatientManagementView().patientName();
		for(Appointment a : e) {
			System.out.println("Appoitment ID: "+a.getId()+" Patient Id: "+a.getPatientId()+" Date & Time: "+a.getDateTime()+"Patient Name: ");

		}
		
		
	}

	public void viewAllAppointmentSpecificDoctor(int doctorId) {
		// TODO Auto-generated method stub
		
	}

	

}

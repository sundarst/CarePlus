package careplus.zsgs.appointmentViewingManagement;
import java.util.ArrayList;
import java.util.List;

import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Appointment;
import careplus.zsgs.dto.Doctors;
import careplus.zsgs.dto.PatientManagement;
public class AppointmentViewingManagementModel {
	
	private AppointmentViewingManagementView view;
	AppointmentViewingManagementModel(AppointmentViewingManagementView view)
	{
		this.view=view;
	}
	
	
	void specificPatientAppointment(int id, String dateTime)
	{
		List<PatientManagement> patientManagement=CarePlusDb.getInstance().getPatientManagement();
		List<Appointment> appointment =CarePlusDb.getInstance().getAppointment();
		List<Appointment> appointmentsss =new ArrayList<>();
		 boolean appointmentFound =false;

			for(Appointment a:appointment)
			{
				System.out.println("Checking the appointment : "+a.getPatientId()+" - "+a.getDateTime());

				if(a.getPatientId()== id &&  dateTime.trim().equalsIgnoreCase(a.getDateTime().trim()))
				{
					
					appointmentFound=true;
					appointmentsss.add(a);
				}

			
		}
		if(appointmentsss.size()!=0)	view.showAppointment(appointmentsss);
		if(!appointmentFound)
		{
			view.showMessage("Appointment not found");
		}
		
	}


	public void viewSpecificDoctor(int doctorId) {
		List<Doctors> doctors=CarePlusDb.getInstance().getDoctors();
		List<Appointment> appointment=CarePlusDb.getInstance().getAppointment();
		boolean found=false;
		for(Doctors d:doctors)
		{
			if(doctorId==d.getId())
			{
			for(Appointment a:appointment)
			{
				if(doctorId==a.getDoctorId())
				{
					view.viewAllAppointmentSpecificDoctor(doctorId);
					found =true;
					break;
				}
			}
			}
		}
		 
		if(!found)
		{
			view.showMessage("Search data not found");
		}
		
	}


	public void avaliableFreeSlot(int doctorId, String dateTime) {
		
		List<Doctors> doctors=CarePlusDb.getInstance().getDoctors();
		List<Appointment> appointment=CarePlusDb.getInstance().getAppointment();
		boolean doctorfound=false;
		boolean slotBook=false;
		for(Doctors d:doctors)
		{
			if(doctorId==d.getId())
			{
				doctorfound=true;
			for(Appointment a:appointment)
			{	
				if(a.getDoctorId()==doctorId && dateTime.trim().equalsIgnoreCase(a.getDateTime().trim()))
				{
					slotBook=true;
					break;
				}
			
			}
			if(slotBook)
			{
				 view.avaliableSlotBook("Slot is Booked");
				
			}
			else
			{
				view.avaliableFreeSlot("Doctor Avaliable You can Book slot");
			}
			
			}
		
		}	
		if(!doctorfound)
		{
			System.out.println("Doctor Id not found");
		}
}
}

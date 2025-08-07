package careplus.zsgs.appointmentBooking;
import careplus.zsgs.db.CarePlusDb;
import java.util.List;

import careplus.zsgs.dto.Appointment;

public class AppointmentBookingModel {
	
	private AppointmentBookingView view;
	
	AppointmentBookingModel(AppointmentBookingView view)
	{
		this.view=view;
	}
	
	public void bookAppointment(int padientId, int doctorId, String dateTime) {
		List<Appointment> appointment=CarePlusDb.getInstance().getAppointment();
		if(!slotAvaliable(doctorId,dateTime))
		{
			System.out.println("Slot is Booked");
		}
		else
		{
			Appointment apm = new Appointment(padientId, doctorId, dateTime);
			CarePlusDb.getInstance().setAppointment(apm);
			view.bookedSuccessfuly();
		}
		
	}
	private boolean slotAvaliable(int doctorId, String dateTime) {
		 List<Appointment> appointment=CarePlusDb.getInstance().getAppointment();
		 
		 for(Appointment a: appointment)
		 {
			 if(a.getDoctorId()==doctorId&& a.getDateTime().equalsIgnoreCase(dateTime))
			 {
				 return false;
			 }
		 }
		 return true;
		 
	}
	
	
	
	
	public List<Appointment> viewallAppointment()
	{
		 List<Appointment> appointment=CarePlusDb.getInstance().getAppointment();
		 return appointment;
		
	}

}

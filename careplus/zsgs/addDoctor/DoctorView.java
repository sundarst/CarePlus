package careplus.zsgs.addDoctor;
import java.util.List;
import java.util.Scanner;
import careplus.zsgs.dto.Doctors;
public class DoctorView {

	private  DoctorModel model;
	private Scanner scanner =  new Scanner(System.in);
	public DoctorView()
	 {
		 model = new DoctorModel(this);
	 }
	 
	 public  void init()
	 {
		 model.init(); 
	 }

	public void addDoctor() {
		try
		{
		Doctors doctors = new Doctors();
		
		doctors.setName(getName());
		doctors.setMobileNumber(getMobileNumber());
		doctors.setAvailableTimeSlots(getAvailableTimeSlots() );
		doctors.setSpecialization(getSpecialization());
		model.doctorInfo(doctors);
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
	}
	


	private String getName()
	{
		String name="";
		System.out.println("Entre Doctor Name");
		do {
			name=scanner.nextLine();
			 if(name.length()<3|| name.length()>=50)
			
				System.out.println("Entre Doctor name between min 3 to max 50\nEntre valid your name");
			else break;
		}    
		while(true);
		return name;
	}
	private String getMobileNumber()
	{
		String number="";
		System.out.println("Entre your Number");
		do {
			number=scanner.nextLine();
			 if(number.matches("^\\d{10}$")) 
			 { 
				 break;
			 }
			else 
			{
				System.out.println("Mobile number must me 10 digits.");
			}
		}    
		while(true);
		return number;
	}
	private String getAvailableTimeSlots() 
	{
		String slot="";
		System.out.println("Entre Avaliable slot(Morning,Afternoon,Evening)");
		do {
			slot=scanner.nextLine().toLowerCase().trim();
			
			 if(slot.equalsIgnoreCase("morning")||slot.equalsIgnoreCase("afternoon")||slot.equalsIgnoreCase("evening"))
				 break;	
			else 
			{
				System.out.println("Enter correct slot\nEntre Avaliable slot(Morning,Afternoon,Evening)");
			}
		}    
		while(true);
		return slot;
	}
	
	private String getSpecialization()
	{
		String specialization ="";
		System.out.println("Entre your specialization");
		do {
			specialization=scanner.nextLine();
			 if(specialization.length()<3|| specialization.length()>=50)
			
				System.out.println("Entre the doctor specialization");
			else break;
		}    
		while(true);
		return specialization;
	}
	public void doctorAddSuccessFuly(String string) {
		
		System.out.println(string);
		
	}

	
	

}

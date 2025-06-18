package careplus.zsgs.addDoctor;
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
		Doctors doctors= new Doctors();
		doctors.setName(getName());
		doctors.setMobileNumber(getMobileNumber());
		doctors.setAvailableTimeSlots(getAvailableTimeSlots() );
		doctors.setSpecialization(getSpecialization());
		model.doctorInfo(doctors);
		
	}
	
	private String getName()
	{
		String name="";
		System.out.println("Entre your Name");
		do {
			name=scanner.nextLine();
			 if(name.length()<3|| name.length()>=50)
			
				System.out.println("Entre your name between min 3 to max 50\nEntre valid your name");
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
			 if(number.matches("/d{10}")) 
			
				System.out.println("Mobile number Must me 10");
			else break;
		}    
		while(true);
		return number;
	}
	private Long getAvailableTimeSlots() 
	{
		long slot=0;
		System.out.println("Entre your Time");
		do {
			slot=scanner.nextLong();
			 if(slot <=1|| slot>=12) 
			
				System.out.println("Enter the doctor avaliable time between 1 to 12");
			else break;
		}    
		while(true);
		return slot;
	}
	
	private String getSpecialization()
	{
		String specialization ="";
		//System.out.println("Entre your Name");
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

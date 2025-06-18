package careplus.zsgs.target.patientmanagement;
import java.util.Scanner;
import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.PatientManagement;
public class PatientManagementView {
	
	private PatientManagementModel model;
	private Scanner scanner= new Scanner(System.in);
	public PatientManagementView()
	{
		model= new PatientManagementModel(this);
	}
	
	
	public void init()
	{
		model.init();
	}


	 void addPatient() {
		
		PatientManagement patient= new PatientManagement();
		patient.setName(getName());
		patient.setAge(getAge());
		patient.setPlace(getPlace());
		patient.setContactNumber(getContactNumber());
		model.patientInfo();
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
	private String getPlace()
	{
		String place="";
		System.out.println("Entre your Place");
		do {
			place=scanner.nextLine();
			 if(place.length()<3|| place.length()>=50)
			
				System.out.println("Entre your place");
			else break;
		}    
		while(true);
		return place;
	}
	
	private String getAge()
	{
		String age="";
		System.out.println("Entre your Age");
		do {
			age=scanner.nextLine();
			 if(age.length()<=1|| age.length()>=100)
			
				System.out.println("Entre your name between min 1 to max 100\nEntre valid your name");
			else break;
		}    
		while(true);
		return age;
	}

	 
	
	private String getContactNumber()
	{
		String number="";
		System.out.println("Entre your Contact Number");
		do {
			number=scanner.nextLine();
			 if(number.length()<3|| number.length()>=50)
			
				System.out.println("Entre your name between min 3 to max 50\nEntre valid your name");
			else break;
		}    
		while(true);
		return number;
	}


	public void addPatientSucessfully(String string) {
		System.out.println(string);
		
	}

	
	
	

}

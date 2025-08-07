package careplus.zsgs.target.patientmanagement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import careplus.zsgs.careplusSetupForAdmin.CarePlusSetUpView;
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
		model.patientInfo(patient);
	}
	
	
	private String getName()
	{
		String name="";
		System.out.println("Entre Patient Name");
		do {
			name=scanner.nextLine();
			 if(name.length()<3|| name.length()>=50)
			
				System.out.println("Entre patient name between min 3 to max 50\nEntre valid your name");
			else break;
		}    
		while(true);
		return name;
	}
	private String getPlace() 
	{
		String place="";
		System.out.println("Entre patient Place");
		do {
			place=scanner.nextLine();
			 if(place.length()<3|| place.length()>=50)
			
				System.out.println("Entre patient place must be min 3 and max 50\nEntre patient Place");
			else break;
		}    
		while(true);
		return place;
	}
	
	private String getAge()
	{
		String age="";
		System.out.println("Entre patient Age");
		do {
			age=scanner.nextLine();
			
			try
			{
				int aValue= Integer.parseInt(age);
			
			 if(aValue >=1||aValue >=100)
				 break;
			else 
			{
				System.out.println("Enter age between min 1 to max 100\nEntre valid your age");
			}
		}catch(NumberFormatException e)
		{
			System.out.println("please entre numeric age");
		}
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
			 if(number.matches("^\\d{10}$"))
				break;
			else 
			{
				System.out.println("Entre contact number must me 10 digits");
			}
		}    
		while(true);
		return number;
	}


	public void addPatientSucessfully() {
		
		//CarePlusSetUpView carePlusSetUpView = new CarePlusSetUpView();
		searchMenu();
		
	}


	 void searchPatient() {
		System.out.println("===Search patient name===");
		System.out.println("Enter th patient name");
		String patientName="";
		patientName=scanner.nextLine();
		model.searchPatientName(patientName);
		
		
	}


	public void displayByName(List<PatientManagement> patient) {
		
		if(patient.isEmpty())
		{
			System.out.println("No data found!");
		}
		
		else
		{
		System.out.println("===Search By name==");
		System.out.printf("%-10s %-25s %-25s %-25s %-25s%n" ,"id","UserName","Age","Mobile Number","Place");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		for(PatientManagement p:patient)
		{
			System.out.printf("%-10s %-25s %-25s %-25s %-25s%n",
					p.getId()
					,p.getName()
					,p.getAge()
					,p.getContactNumber()
					,p.getPlace());

			
		}
		System.out.println();
		}
		
	}
	
	public void searchMenu()
	{
		int choic=0;
		do
		{
			System.out.println("1.search by name");
			System.out.println("2.Back to main menu");
			 choic=0;
			choic=Integer.parseInt(scanner.nextLine());
			
			switch(choic)
			{
			case 1:
				searchPatient();
				break;
			case 2:
				new careplus.zsgs.careplusSetupForAdmin.CarePlusSetUpView().init();
				break;
			}
		} while(choic!=3);
	}


	public void showMessage(String string) {
		System.out.println(string);
		
	}

	public void patientName()
	{
		List<PatientManagement> patientManagement=new ArrayList<>();
		for(PatientManagement p: patientManagement)
		{
			System.out.print(p.getName());
		}
	}
	
	
	

}

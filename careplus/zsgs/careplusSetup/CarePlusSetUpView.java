package careplus.zsgs.careplusSetup;
import java.util.Scanner;
import careplus.zsgs.addDoctor.DoctorView;
import careplus.zsgs.baseClass.BaseClassView;


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
			//System.out.println("2.Add Receptions");
			System.out.println("2.Back to main menu");
			System.out.println("3.Add Patient");
			System.out.println("4.Logout");
			System.out.println("5.Exit");
			
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
				BaseClassView.logout();
				 break;
			case 5:
					System.exit(0);
					break;
			}
		}while(choic!=3);
		
	}

}

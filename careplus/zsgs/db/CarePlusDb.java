package careplus.zsgs.db;
import java.util.List;

import careplus.zsgs.dto.AdminUser;
import careplus.zsgs.dto.Doctors;
import careplus.zsgs.dto.PatientManagement;
public class CarePlusDb {
	
	private static  CarePlusDb cCarePlusDb;
	
	private  CarePlusDb()
	{
		
	}
	
	public static CarePlusDb getInstance()
	{
		if(cCarePlusDb==null)
		{
			cCarePlusDb=new CarePlusDb();
		}
		return cCarePlusDb;
	}

	
	private AdminUser adminUser;
	private List<Doctors> doctors ;
	private List<PatientManagement> patientManagement;
	public AdminUser getAdminUser() {
		return adminUser;
	}

	public List<PatientManagement> getPatientManagement() {
		return patientManagement;
	}

	public void setPatientManagement(List<PatientManagement> patientManagement) {
		this.patientManagement = patientManagement;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	


	public List<Doctors> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctors> doctors) {
		this.doctors = doctors;
	}

	
	public boolean validInfo(String userName, String passwordForLogin) {
		
		return  getAdminUser().getName().equals(userName)&& getAdminUser().getPassword().equals(passwordForLogin);
	}

	
}

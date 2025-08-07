package careplus.zsgs.db;

import java.util.ArrayList;
import java.util.List;

import careplus.zsgs.CareDb;
//import careplus.zsgs.CareDb;
import careplus.zsgs.dto.AdminUser;
import careplus.zsgs.dto.Appointment;
import careplus.zsgs.dto.Doctors;
import careplus.zsgs.dto.PatientManagement;
import careplus.zsgs.dto.Receptioinist;

public class CarePlusDb {

	private static CarePlusDb cCarePlusDb;
	
	private String userName="Sundar";
	private String password="sundar@99";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}

	private CarePlusDb() {

		doctors = new ArrayList<>();
		receptioinist = new ArrayList<>();
		patientManagement = new ArrayList<>();
		appointment = new ArrayList<>();

	}

	public static CarePlusDb getInstance() {
		if (cCarePlusDb == null) {
			cCarePlusDb = new CarePlusDb();
		}
		return cCarePlusDb;
	}

	//private AdminUser adminUser;


	private List<Doctors> doctors;
	private List<Receptioinist> receptioinist;
	private List<PatientManagement> patientManagement;
	private List<Appointment> appointment;

 public List<PatientManagement> getPatientManagement() {
		return CareDb.loadPatient();
	}

	public void setPatientManagement(PatientManagement patient) {
		//patientManagement.add(patient);// need to remove this cause bug duplicate entry
		CareDb.storePatient(patient);
		
		
	}


	public List<Doctors> getDoctors() {
		return CareDb.loadDoctors();
		
	}

	public void setDoctors(Doctors doctor) {

		 CareDb.storeDoctors(doctor);
		
	}

	public List<Receptioinist> getReceptioinist() {
	return receptioinist;
		
	}

	public void setReceptioinist(Receptioinist receptioinist) {
		this.receptioinist.add(receptioinist);
		 CareDb.storeReceptionist();
	}

	

	public List<Appointment> getAppointment() {
		return CareDb.loadAppointment();
		
	}

	public  void setAppointment(Appointment appointment) {
		//this.appointment.add(appointment); will cause duplicate entry
		 CareDb.storeAppointment(appointment);
	}

}






//public AdminUser getAdminUser() {
//return adminUser;
//}

//public
//public void setAdminUser(AdminUser adminUser) {
//	this.adminUser = adminUser;
//}







/*
 * 
 * 
 * */




















//	private void writeDoctorsFile(String filename) {
//	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
//	        for (Doctors doctor : doctors) {
//	            bw.write(doctor.toFileString());
//	            bw.newLine();
//	        }
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	public void addDoctor(Doctors doctor) {
//	    if (doctor != null) {
//	        this.doctors.add(doctor);
//	        writeDoctorsFile("doctors.txt"); 
//	    }
//	}
//
//	public void loadFromFile() {
//		List<Doctors> doctorsList = new ArrayList<>();
//		try (BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))) {
//			String line;
//			while ((line = br.readLine()) != null) {
//				doctorsList.add(Doctors.fromFileString(line));
//			}
//			setDoctors(doctorsList);
//		} catch (IOException e) {
//			doctors = new ArrayList<>(); // if file not found, init empty list
//		}
//	}

package careplus.zsgs.target.patientmanagement;
import careplus.zsgs.db.CarePlusDb;
public class PatientManagementModel {
	
	private PatientManagementView view;
	PatientManagementModel(PatientManagementView view )
	{
		this.view=view;
	}
	
	public  void init()
	{
		view.addPatient();
	}
	public void patientInfo() {
		
		CarePlusDb.getInstance().getPatientManagement();
		view.addPatientSucessfully("Patient add sucessfully");
	}

}

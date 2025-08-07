package careplus.zsgs.target.patientmanagement;
import java.util.List;
import java.util.stream.Collectors;

import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.PatientManagement;
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
	public void patientInfo(PatientManagement patient) {
		
		CarePlusDb.getInstance().setPatientManagement(patient);
		view.addPatientSucessfully();
	}

	public void searchPatientName(String patientName) {
		
			if(patientName==null||(patientName.trim().isEmpty()))
              {
            	  System.out.println("Patient Name is empty");
            	  return;
              }
			else
			{	List<PatientManagement> match= CarePlusDb.getInstance().getPatientManagement();
					System.out.println("count: "+match.size());
				
				List<PatientManagement> patient =CarePlusDb.getInstance().getPatientManagement().stream()
						.filter(patientpatientName->patientpatientName.getName().toLowerCase().contains(patientName.toLowerCase()))
						.collect(Collectors.toList());	
						view.displayByName(patient);
			}	 	
						
	}
	
	
	

}

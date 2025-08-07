package careplus.zsgs.addDoctor;

import java.util.List;

import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Doctors;

class DoctorModel {

	private DoctorView view;

	DoctorModel(DoctorView view) {
		this.view = view;
	}

	public void init() {
		view.addDoctor();

	}

	public void doctorInfo(Doctors doctors) {
		 CarePlusDb.getInstance().setDoctors(doctors);
		

	}
	 
	

	

}

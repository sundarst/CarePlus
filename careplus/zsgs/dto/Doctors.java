package careplus.zsgs.dto;

public class Doctors {
	private int id;
	//private int doctorId;
	private String name;
	private String mobileNumber;
	private String specialization;
	private String availableTimeSlots;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}



	public String getAvailableTimeSlots() {
		return availableTimeSlots;
	}



	public void setAvailableTimeSlots(String availableTimeSlots) {
		this.availableTimeSlots = availableTimeSlots;
	}



//	public static Doctors fromFileString(String line)
//	{
//		String parts[]=line.split(",");
//		return new Doctors(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],parts[4]);
//	}
//
//
//
//
//	public String toFileString() {
//		return id + "," + name + "," + mobileNumber + "," + specialization + "," + availableTimeSlots;
//	}






	

}

package careplus.zsgs.dto;

public class PatientManagement {
	
	private int id;
	private String name;
	private String age;
	private String contactNumber;
	private String place;

	
	
	
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Appointment getAppointedDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

}

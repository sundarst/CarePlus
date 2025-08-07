package careplus.zsgs.dto;
public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private String dateTime;
    private String time;

    public Appointment(int patientId, int doctorId, String dateTime) {
      
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDateTime() {
        return dateTime;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id +
               " | Patient ID: " + patientId +
               " | Doctor ID: " + doctorId +
               " | Time: " + dateTime;
    }
}

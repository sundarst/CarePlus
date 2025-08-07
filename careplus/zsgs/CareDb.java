package careplus.zsgs;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import careplus.zsgs.db.CarePlusDb;
import careplus.zsgs.dto.Appointment;
import careplus.zsgs.dto.Doctors;
import careplus.zsgs.dto.PatientManagement;
import careplus.zsgs.dto.Receptioinist;

public class CareDb {
	
	private final static String URL="jdbc:mysql://localhost:3306/carePlus";
	private final static String USERNAME="root";
	private final static String  PASSWORD="1234";	
	
		public static Connection getConnection() throws SQLException
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} 
		 
		public static void storeDoctors(Doctors doctors)
		{
			String sql="INSERT INTO  doctors(name,mobile_number,specialization,available_time_slots)VALUES(?,?,?,?)";
			try(Connection con = getConnection();
					
				PreparedStatement stm=	con.prepareStatement(sql))
			{
				
					stm.setString(1,doctors.getName());
					stm.setString(2, doctors.getMobileNumber());
					stm.setString(3, doctors.getSpecialization());
					stm.setString(4, doctors.getAvailableTimeSlots());
					stm.executeUpdate();
					new careplus.zsgs.addDoctor.DoctorView().doctorAddSuccessFuly("Doctor Added successfully");
				
			}   
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		public static List<Doctors> loadDoctors()
		{	List<Doctors>doctorsList=new ArrayList<>();// Protects original list (read-only)
			//List<Doctors>doctorsList =CarePlusDb.getInstance().getDoctors(); // Safe, no DB load, fast, secure access
		  
			String sql="SELECT * FROM doctors";
			try(Connection con = getConnection();
				PreparedStatement stm=con.prepareStatement(sql);
					ResultSet rs=stm.executeQuery())
			{
				while(rs.next())
				{	 Doctors d=new Doctors();
					d.setId(rs.getInt("id"));
					d.setName(rs.getString("name"));
					d.setMobileNumber(rs.getString("mobile_number"));
					d.setSpecialization(rs.getString("specialization"));
					d.setAvailableTimeSlots(rs.getString("available_time_slots"));
					doctorsList.add(d);
					
					
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
			return doctorsList;
		}

		
		
		private  static void storeReceptionist( List<Receptioinist> receptioinist) 
		{
			String sql="INSERT INTO  receptionist(name,password)VALUES(?,?)";
			try(Connection con= getConnection();
			PreparedStatement stm =con.prepareStatement(sql))
			{
				for(Receptioinist r:receptioinist)
				{
					stm.setString(1,r.getName());
					stm.setString(2,r.getPassword());
					stm.executeUpdate();
				}
			}catch(SQLException e)
			{
				System.out.println("error"+e);
			}
		}

		
		
	
		public  static void storeReceptionist() // because i use thre exception storeReceptionist() this method
		{
			List<Receptioinist> receptioinist=CarePlusDb.getInstance().getReceptioinist();
			
			CareDb.storeReceptionist(receptioinist); 
			
		}
		
		public  static   List<Receptioinist> loadReceptionList()
		{
			
			List<Receptioinist> receptioinistList=CarePlusDb.getInstance().getReceptioinist();
			 receptioinistList.clear();
			 String sql="SELECT * FROM  receptionist";
			try(Connection con = getConnection();
					PreparedStatement stm= con.prepareStatement(sql);
					ResultSet set=stm.executeQuery())
			{ 
				while(set.next())
				{	Receptioinist r=new Receptioinist();
					r.setName(set.getString("name"));
					r.setPassword(set.getString("password"));
					receptioinistList.add(r);
				}
				
			}
			catch(SQLException e)
			{
				System.out.println("Error handling");
			}
		
			return receptioinistList;
		
		}
		
		public static void  storePatient(PatientManagement patientManagement)
		{	
			String sql="INSERT INTO patients(name,age,place,contact_number)VALUES(?,?,?,?)";
			try(Connection con =getConnection();
				PreparedStatement stm =con.prepareStatement(sql))
			{
				
					stm.setString(1,patientManagement.getName());
					stm.setString(2, patientManagement.getAge());
					stm.setString(3, patientManagement.getPlace());
					stm.setString(4, patientManagement.getContactNumber());
					stm.executeUpdate();
					
					new careplus.zsgs.target.patientmanagement.PatientManagementView().showMessage ("Patient added successfuly");
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		public static List<PatientManagement> loadPatient()
		{
			List<PatientManagement> patientManagement=new ArrayList<>();
			//List<PatientManagement> patientManagement=CarePlusDb.getInstance().getPatientManagement();
			String sql="SELECT * FROM  patients";
			
			try(Connection con = getConnection();
					PreparedStatement stm=con.prepareStatement(sql);
					ResultSet set= stm.executeQuery())
			{
				while(set.next())
				{
					
					PatientManagement p= new PatientManagement();
						p.setName(set.getString("name"));
						p.setAge(set.getString("age"));
						p.setPlace(set.getString("place"));
						p.setContactNumber(set.getString("contact_number"));
						patientManagement.add(p);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error"+e);
			}
				return patientManagement;
		}
		
		public static void storeAppointment(Appointment appointment)
		{
			//List<Appointment> a=CarePlusDb.getInstance().getAppointment();
			String sql="INSERT INTO appointments (patient_id,doctor_id,date_time) VALUES(?,?,?)";
			try(Connection con = getConnection();
					PreparedStatement stm= con.prepareStatement(sql))
			{

					stm.setInt(1, appointment.getPatientId());
					stm.setInt(2,appointment.getDoctorId());
					stm.setString(3, appointment.getDateTime());
					stm.executeUpdate();
					new careplus.zsgs.appointmentBooking.AppointmentBookingView().showMessage("Appointment Booked succesfully");
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
			
		}
		
		public static List<Appointment>  loadAppointment()
		{
			List<Appointment> appointmentList=new ArrayList<>();
		
			String sql="SELECT * FROM appointments";
			try(Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(sql);
				ResultSet set = stm.executeQuery())
			{
				while(set.next())
				{
					
					int patientId=set.getInt("patient_id");
					int doctorId=set.getInt("doctor_id");
					String dateTime=set.getString("date_time");
					Appointment a= new Appointment(patientId, doctorId, dateTime);
					a.setId(set.getInt("id"));
					 appointmentList.add(a);
					
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error:"+e);
			}
			
			return appointmentList;
		}
		
		
}



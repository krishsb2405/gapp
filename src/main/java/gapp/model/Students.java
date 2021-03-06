	package gapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="students")
public class Students{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="student_id")
	private int studentID;
	
	@Column(name="cin")
	private String CIN;
	
	private String phone;
	
	@DateTimeFormat(pattern="yyyy-dd-MM")
	private java.util.Date dob;
	private String citizenship;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	@OneToMany(cascade=CascadeType.MERGE)
	@JoinColumn(name="application_student_id")
	private List<Applications> applications;
	
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	@JoinColumn(name="education_student_id")
	private List<EducationalCollege> educationalCollege;
	
	public Students(){}
	public Students(int studentID, String CIN, String phone, Date dob, String citizenship, User user,
			List<Applications> applications, List<EducationalCollege> educationalCollege) {
		super();
		this.studentID = studentID;
		this.CIN = CIN;
		this.phone = phone;
		this.dob = dob;
		this.citizenship = citizenship;
		this.user = user;
		this.applications = applications;
		this.educationalCollege = educationalCollege;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public List<Applications> getApplications() {
		return applications;
	}
	public void setApplications(List<Applications> applications) {
		this.applications = applications;
	}
	public List<EducationalCollege> getEducationalCollege() {
		return educationalCollege;
	}
	public void setEducationalCollege(List<EducationalCollege> educationalCollege) {
		this.educationalCollege = educationalCollege;
	}
	
	
}

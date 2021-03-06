package gapp.model;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="applications")
public class Applications {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="application_id")
	private int applicationID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="application_student_id")
	Students student;
	
	@ManyToOne
	@JoinColumn(name="application_term_id")
	Terms term;
	
	@ManyToOne
	@JoinColumn(name="application_program_id")
	Programs program;
	
	@ManyToOne
	@JoinColumn(name="application_status_id")
	ApplicationStatus status;

	@OneToMany
	@JoinColumn(name="application_id")
	
	private List<ApplicationStatusHistory> applicatonStatusHistory;
	
	public Applications(){};
	public Applications(int applicationID, Students student, Terms term, Programs program, ApplicationStatus status,
			List<ApplicationStatusHistory> applicatonStatusHistory) {
		super();
		this.applicationID = applicationID;
		this.student = student;
		this.term = term;
		this.program = program;
		this.status = status;
		this.applicatonStatusHistory = applicatonStatusHistory;
	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Terms getTerm() {
		return term;
	}

	public void setTerm(Terms term) {
		this.term = term;
	}

	public Programs getProgram() {
		return program;
	}

	public void setProgram(Programs program) {
		this.program = program;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public List<ApplicationStatusHistory> getApplicatonStatusHistory() {
		return applicatonStatusHistory;
	}

	public void setApplicatonStatusHistory(List<ApplicationStatusHistory> applicatonStatusHistory) {
		this.applicatonStatusHistory = applicatonStatusHistory;
	}

	
	
}

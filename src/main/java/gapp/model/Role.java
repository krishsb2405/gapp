package gapp.model;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="user_role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleID;
	
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinColumn(name="role_id")
	private List<User> users;
	
	@Column(name="role_name")
	private String roleName;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}

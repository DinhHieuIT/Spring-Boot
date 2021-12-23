package dinhhieu.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="managements")
public class ManagementEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	
	//1 manager có thể có nhiều roles
	//mappedBy trỏ tới biến management nằm trong lớp Management_Role
	@OneToMany(mappedBy="managementEntity",fetch = FetchType.EAGER)
	private List<Management_Role> managementRoles;
	
	public ManagementEntity() {
		
	}

	public ManagementEntity(String name, String password, List<Management_Role> managementRoles) {
		super();
		this.name = name;
		this.password = password;
		this.managementRoles = managementRoles;
	}



	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Management_Role> getManagementRoles() {
		return managementRoles;
	}

	public void setManagementRoles(List<Management_Role> managementRoles) {
		this.managementRoles = managementRoles;
	}
}

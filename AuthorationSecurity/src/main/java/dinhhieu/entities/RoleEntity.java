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
@Table(name="roles")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="roleEntity",fetch = FetchType.EAGER)
	private List<Management_Role> managementRoles;
	
	public RoleEntity() {
		
	}

	public RoleEntity(String name, List<Management_Role> managementRoles) {
		super();
		this.name = name;
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

	public List<Management_Role> getManagementRoles() {
		return managementRoles;
	}

	public void setManagementRoles(List<Management_Role> managementRoles) {
		this.managementRoles = managementRoles;
	}


}

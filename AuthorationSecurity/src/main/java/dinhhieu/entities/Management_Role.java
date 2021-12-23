package dinhhieu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="management_role")
public class Management_Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long management_id;
	private Long role_id;
	
	@ManyToOne 
    @JoinColumn(name = "management_id",referencedColumnName="id", insertable=false, updatable=false) 
	private ManagementEntity managementEntity;
	
	@ManyToOne 
    @JoinColumn(name = "role_id",referencedColumnName="id", insertable=false, updatable=false) 
	private RoleEntity roleEntity;
	
	public Management_Role() {
		
	}

	public Management_Role(Long management_id, Long role_id, ManagementEntity managementEntity,
			RoleEntity roleEntity) {
		super();
		this.management_id = management_id;
		this.role_id = role_id;
		this.managementEntity = managementEntity;
		this.roleEntity = roleEntity;
	}

	public Long getId() {
		return id;
	}


	public Long getManagement_id() {
		return management_id;
	}

	public void setManagement_id(Long management_id) {
		this.management_id = management_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public ManagementEntity getManagementEntity() {
		return managementEntity;
	}

	public void setManagementEntity(ManagementEntity managementEntity) {
		this.managementEntity = managementEntity;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}
	
}

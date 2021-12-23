package dinhhieu.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dinhhieu.entities.*;

public class ManagementDetail implements UserDetails{
	
	private ManagementEntity management;
	
	public ManagementDetail(ManagementEntity material) {
		this.management = material;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Management_Role> managementRoles = management.getManagementRoles();
		int size = managementRoles.size();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(int i=0;i<size;i++) {
			authorities.add(new SimpleGrantedAuthority(managementRoles.get(i).getRoleEntity().getName()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return management.getPassword();
	}

	@Override
	public String getUsername() {
		
		return management.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}

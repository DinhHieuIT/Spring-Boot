package dinhhieu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dinhhieu.entities.ManagementEntity;
import dinhhieu.repository.ManagementRepository;

public class ManagementDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ManagementRepository materialRepo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		ManagementEntity material = materialRepo.getMaterialByName(name);
		if(material == null) {
			throw new UsernameNotFoundException("Cound not find material");
		}
		return new ManagementDetail(material);
	}

}

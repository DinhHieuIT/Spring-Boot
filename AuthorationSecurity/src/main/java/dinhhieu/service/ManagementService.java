package dinhhieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhhieu.repository.ManagementRepository;
import dinhhieu.*;
import dinhhieu.entities.ManagementEntity;

@Service
public class ManagementService {
	
	@Autowired
	ManagementRepository managementRepo;
	
	public List<ManagementEntity> getAll(){
		List<ManagementEntity> list = managementRepo.findAll();
		
		return managementRepo.findAll();
	}
	
	public void save(ManagementEntity management) {
		managementRepo.save(management);
	}
	
	public ManagementEntity get(Long id) {
		return managementRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		managementRepo.deleteById(id);;
	}

}

package dinhhieu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dinhhieu.repo.FoodRepository;
import dinhhieu.entity.*;

@Service
@Transactional
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepo;
	
	//List of food price
	public List<Food> listAll(){
		return foodRepo.findAll();
	}
	
	//Save food price into database
	public void save (Food food) {
		foodRepo.save(food);
	}
	
	//Get food price depend on id
	public Optional<Food> find(long id) {
		return foodRepo.findById(id);		
	}
	
	//Delete food price from database
	public void delete(long id) {
		foodRepo.deleteById(id);
	}

}

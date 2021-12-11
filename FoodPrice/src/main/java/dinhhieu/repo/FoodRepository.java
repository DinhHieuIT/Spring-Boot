package dinhhieu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dinhhieu.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	
	

}

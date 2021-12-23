package dinhhieu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dinhhieu.entities.ManagementEntity;

@Repository
public interface ManagementRepository extends JpaRepository<ManagementEntity, Long> {
	
	@Query("SELECT m FROM ManagementEntity m WHERE m.name =  :name")
	public ManagementEntity getMaterialByName(@Param("name") String name);

}

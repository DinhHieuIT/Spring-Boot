package dinhhieu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dinhhieu.entity.Lender_Borrower;

public interface LenderBorrowerRepo extends JpaRepository<Lender_Borrower, Integer> {
	
	@Query("SELECT e FROM Lender_Borrower e WHERE e.lender_id = ?1 AND e.borrower_id = ?2")
	 Lender_Borrower findLenderBorrowerByLenderBorrower(Integer lender_id,Integer borrower_id);

}

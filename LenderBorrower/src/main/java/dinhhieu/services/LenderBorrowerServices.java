package dinhhieu.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dinhhieu.entity.Borrower;
import dinhhieu.entity.Lender_Borrower;
import dinhhieu.repository.LenderBorrowerRepo;

@Service
@Transactional
public class LenderBorrowerServices {
	
	@Autowired
	private LenderBorrowerRepo lenderBorrowerRepo;
	
	public Lender_Borrower findByLenderBorower(Integer lender_id, Integer borrower_id){
		return lenderBorrowerRepo.findLenderBorrowerByLenderBorrower(lender_id, borrower_id);
	}
	

}

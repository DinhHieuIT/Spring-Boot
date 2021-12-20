package dinhhieu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="borrowers")
public class Borrower implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String identical;
	
	@OneToMany(mappedBy="borrower", cascade = CascadeType.ALL)
	private Set<Lender_Borrower> lenderborrowers = new HashSet<>();
	

	public Borrower() {
	
	}


	public Borrower(String name, String identical, Set<Lender_Borrower> lenderborrowers) {
		super();
		this.name = name;
		this.identical = identical;
		this.lenderborrowers = lenderborrowers;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIdentical() {
		return identical;
	}


	public void setIdentical(String identical) {
		this.identical = identical;
	}


	public Set<Lender_Borrower> getLenderborrowers() {
		return lenderborrowers;
	}


	public void setLenderborrowers(Set<Lender_Borrower> lenderborrowers) {
		this.lenderborrowers = lenderborrowers;
	}

}

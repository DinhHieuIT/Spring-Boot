package dinhhieu.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lenders")
public class Lender implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy="lender", cascade = CascadeType.ALL)
	private Set<Lender_Borrower> lenderborrowers = new HashSet<>();

	public Lender() {
		
	}
	
	public Lender(Integer id, String name, Set<Lender_Borrower> lenderborrowers) {
		super();
		this.id = id;
		this.name = name;
		this.lenderborrowers = lenderborrowers;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

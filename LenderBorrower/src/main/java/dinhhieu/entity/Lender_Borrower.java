package dinhhieu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lenders_borrowers")
public class Lender_Borrower implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="constract_no",unique=true)
	private Integer constractNo;
	@Column(name="create_at")
	private Date createAt;
	private String money;
	@Column(name="term_loan")
	private String termLoan;
	@Column(name="month_pay")
	private String monthPay;
	@Column(name="borrow_product")
	private String borrowProduct;
	private Integer lender_id;
	private Integer borrower_id;
	
	@ManyToOne
	@JoinColumn(name="lender_id",insertable=false ,updatable=false)
	private Lender lender;
	
	@ManyToOne
	@JoinColumn(name="borrower_id",insertable=false ,updatable=false)
	private Borrower borrower;

	public Lender_Borrower() {
		
	}

	public Lender_Borrower(Integer constractNo, Date createAt, String money, String termLoan, String monthPay,
			String borrowProduct, Integer lender_id, Integer borrower_id, Lender lender, Borrower borrower) {
		super();
		this.constractNo = constractNo;
		this.createAt = createAt;
		this.money = money;
		this.termLoan = termLoan;
		this.monthPay = monthPay;
		this.borrowProduct = borrowProduct;
		this.lender_id = lender_id;
		this.borrower_id = borrower_id;
		this.lender = lender;
		this.borrower = borrower;
	}

	public Integer getConstractNo() {
		return constractNo;
	}

	public void setConstractNo(Integer constractNo) {
		this.constractNo = constractNo;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getTermLoan() {
		return termLoan;
	}

	public void setTermLoan(String termLoan) {
		this.termLoan = termLoan;
	}

	public String getMonthPay() {
		return monthPay;
	}

	public void setMonthPay(String monthPay) {
		this.monthPay = monthPay;
	}

	public String getBorrowProduct() {
		return borrowProduct;
	}

	public void setBorrowProduct(String borrowProduct) {
		this.borrowProduct = borrowProduct;
	}

	public Integer getLender_id() {
		return lender_id;
	}

	public void setLender_id(Integer lender_id) {
		this.lender_id = lender_id;
	}

	public Integer getBorrower_id() {
		return borrower_id;
	}

	public void setBorrower_id(Integer borrower_id) {
		this.borrower_id = borrower_id;
	}

	public Lender getLender() {
		return lender;
	}

	public void setLender(Lender lender) {
		this.lender = lender;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	
	
	
}

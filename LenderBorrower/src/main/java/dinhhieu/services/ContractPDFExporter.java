package dinhhieu.services;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import dinhhieu.entity.Borrower;
import dinhhieu.entity.Lender_Borrower;

public class ContractPDFExporter {
	private Lender_Borrower lenderBorrower;
	public ContractPDFExporter(Lender_Borrower lenderBorrower) {
		this.lenderBorrower = lenderBorrower;
	}
	 public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("Chi tiet hop dong", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(p);
	        
	        Paragraph paragraph1 = new Paragraph("So hop dong " + lenderBorrower.getConstractNo());
	        Paragraph paragraph2 = new Paragraph("Nguoi vay " + lenderBorrower.getBorrower().getName());
	        Paragraph paragraph3 = new Paragraph("Ngay tao " + lenderBorrower.getCreateAt());
	        Paragraph paragraph4 = new Paragraph("So tien vay " + lenderBorrower.getMoney());
	        Paragraph paragraph5 = new Paragraph("Ky han vay " + lenderBorrower.getTermLoan());
	        Paragraph paragraph6 = new Paragraph("Tien tra hang thang " + lenderBorrower.getMonthPay());
	        Paragraph paragraph7 = new Paragraph("San pham vay " + lenderBorrower.getBorrowProduct());
	        document.add(paragraph1);
	        document.add(paragraph2);
	        document.add(paragraph3);
	        document.add(paragraph4);
	        document.add(paragraph5);
	        document.add(paragraph6);
	        document.add(paragraph7);
	        
	        document.close(); 
	 }
}

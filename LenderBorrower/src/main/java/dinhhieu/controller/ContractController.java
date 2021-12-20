package dinhhieu.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;

import dinhhieu.entity.Borrower;
import dinhhieu.entity.Lender_Borrower;
import dinhhieu.services.ContractPDFExporter;
import dinhhieu.services.LenderBorrowerServices;

@Controller
public class ContractController {
	
	@Autowired
    private LenderBorrowerServices service;
         
	@RequestMapping("/")
	public String showHomepage() {
		return "contract";
	}
	
	@GetMapping("/contract/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        Lender_Borrower lenderBorrower = service.findByLenderBorower(1, 1);
         
        ContractPDFExporter exporter = new ContractPDFExporter(lenderBorrower);
        exporter.export(response);
         
    }

}

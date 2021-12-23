package dinhhieu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dinhhieu.service.ManagementService;
import dinhhieu.entities.*;

@Controller
public class ManagementController {
	
	@Autowired
	private ManagementService managementService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<ManagementEntity> managements = managementService.getAll();
		model.addAttribute("managements", managements);
		
		return "home";
	}
	
	@RequestMapping("/new")
	public String add(Model model) {
		ManagementEntity management = new ManagementEntity();
		model.addAttribute("management", management);
		return "new";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute ManagementEntity management, Model model) {
		managementService.save(management);
		return "redirect:";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEdit(Model model,@PathVariable Long id) {
		ManagementEntity me = managementService.get(id);
		model.addAttribute("manager", me);
		return "edit";
	}

}

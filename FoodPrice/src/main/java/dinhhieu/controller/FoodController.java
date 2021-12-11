package dinhhieu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dinhhieu.entity.Food;
import dinhhieu.service.FoodService;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping("/")
	public String listTable(Model model) {
		List<Food> foods = foodService.listAll();
		model.addAttribute("listAll",foods);
		return "listtable";
	}
	
	@RequestMapping("/add")
	public String showAddTable(Model model) {
		Food food = new Food();
		model.addAttribute("food", food);
		return "add";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveFood(@ModelAttribute Food food) {
		foodService.save(food);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
    public String showEditFood(@PathVariable(name="id") int id, Model model ) {
		
		Optional<Food> food = foodService.find(id);
		model.addAttribute("food", food);
		return "edit";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteFood(@PathVariable(name="id") int id) {
		foodService.delete(id);
		return "redirect:/";
	}
}

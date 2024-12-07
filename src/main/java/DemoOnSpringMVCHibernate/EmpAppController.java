package DemoOnSpringMVCHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import DemoOnSpringMVCHibernate.Employee;

@Controller
public class EmpAppController {
	@Autowired
	EmployeeDAO dao;
	@GetMapping("/add")
	public String Add(Model m)
	{
		//Employee e = new Employee();
		m.addAttribute("command", new Employee());
		return  "add";
		
	}
	//Method to save the Employee object
	@PostMapping("/save")
	public String Save(@ModelAttribute("e") Employee e)
	{
		dao.insert(e);
		return "redirect:/show";
	}
	
	//Method to display the List of Employees from the table
	@GetMapping("/show")
	public String show(Model m)
	{
		m.addAttribute("emplist", dao.getEmployeeList());
		return "show";
	}
	
	//method to edit Employee object
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id,Model m)
	{
		Employee e = dao.getEmployeeById(id);
		m.addAttribute("editdata", e);
		return "edit";
	}
	//method to edit and save employee object
	@PostMapping("/editsave")
	public String update(@ModelAttribute("e") Employee e)
	{
		dao.update(e);
		return "redirect:/show";
	}
	//method to delete the employee object
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		dao.delete(id);
		return "redirect:/show";
	}

}

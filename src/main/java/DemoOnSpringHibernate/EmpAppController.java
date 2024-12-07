package DemoOnSpringHibernate;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpAppController {
	@Autowired
	EmployeeDAO dao;
	@GetMapping("/add")
	public String Add(Model m)
	{
		Employee e = new Employee();
		m.addAttribute("command",e);
		return "add";
		}
	@PostMapping("/save")
	public String Save(@ModelAttribute ("e") Employee e )
	{
		dao.insert(e);
		return "redirect:/show";
		
	}
	@GetMapping("/show")
public String show(Model m)
{
   m.addAttribute("emplist", dao.getEmployeeList());
	return "show";
}
	@PostMapping("/edit/{id}")
	public String edit(int id)
	{
		return "redirect:/show";
	}
}
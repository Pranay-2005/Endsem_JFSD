package DemoOnSpringMVCHibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDAO {
HibernateTemplate template;

public HibernateTemplate getTemplate() {
	return template;
}

public void setTemplate(HibernateTemplate template) {
	this.template = template;
}
	//method to save employee
	public void insert(Employee e) {
		template.save(e);
	}
	//method to update employee
	public void update(Employee e) {
		template.update(e);
	}
	//method to get employee object based on empid
	public Employee getEmployeeById(int empid)
	{
		Employee e = (Employee)template.get(Employee.class, empid);
		return e;
	}
	
	//method to delete employee object based on empid
	public void delete(int empid)
	{
		Employee e = (Employee) template.get(Employee.class, empid);
		template.delete(e);
	}
	
	//method to get the List of Employees
	
	public List<Employee> getEmployeeList() 
	{
		List<Employee> l = (List<Employee>)template.find("from Employee");
	 return l;
	}
	
}

package DemoOnSpringHibernate;

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
	
	public void insert (Employee e ) {
		template.save(e);
	}
	public void update (Employee e) {
		template.update(e);
	}
	
	public Employee getEmployeeById(int empid) {
		Employee e = (Employee)template.get(Employee.class,empid);
		return e;
		
	}
	public void delete(int empId) {
	    // Retrieve the employee object using the empId
	    Employee e= (Employee) template.get(Employee.class, empId);
	    template.delete(e);

	    }
	public List<Employee> getEmployeeList() {
	    // Retrieve a list of all Employee objects from the database
	    List<Employee> l = (List<Employee>) template.find("from Employee");
	    return l;
	    
	 
	}

	}




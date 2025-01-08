package LoadingExamples;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Departments")
public class Department {

    @Id
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
//    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
//    private List<Employee> employees;
    
 // Fetch employees lazily (default behavior)
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees;


	public Department() {
		super();
	}

	public Department(int id, String name, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

    // Getters and Setters
    
}


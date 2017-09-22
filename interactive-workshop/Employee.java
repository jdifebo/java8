
/**
 * A very simple class with 3 fields.
 * 
 * @author jdifebo
 *
 */
public class Employee {
	
	String name;
	int salary;
	String office;
	
	public Employee(String name, int salary, String office) {
		this.name = name;
		this.salary = salary;
		this.office = office;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary
				+ ", office=" + office + "]";
	}

}

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Used to test out our EmployeeManager.  Not a formal unit test or anything, 
 * just a bunch of print statements.
 * 
 * @author jdifebo
 *
 */
public class Main {

	public static List<Employee> generateData(){
		return Arrays.asList(
				new Employee("Matt", 50000, "New York"),
				new Employee("Steve", 60000, "London"),
				new Employee("Carrie", 100000, "New York"),
				new Employee("Peter", 70000, "New York"),
				new Employee("Alec", 60000, "London"),
				new Employee("Sarah", 80000, "London"),
				new Employee("Rebecca", 40000, "New York"),
				new Employee("Pat", 50000, "New York"),
				new Employee("Tammy", 90000, "New York"),
				new Employee("Fred", 50000, "Tokyo"));
	}
	
	public static void main(String[] args){
		EmployeeManager manager = new EmployeeManager(generateData());
		EmployeeManager emptyManager = new EmployeeManager(Collections.emptyList());

		System.out.println("Testing if there are employees from London: " + manager.existsEmployeeAtOffice("London"));
		System.out.println("Testing if there are employees from Rome: " + manager.existsEmployeeAtOffice("Rome"));

		System.out.println("Testing if all employees are paid more than 10000: " + manager.allSalariesGreaterThan(10000));
		System.out.println("Testing if all employees are paid more than 50000: " + manager.allSalariesGreaterThan(50000));

		System.out.println("Finding an Optional of highest paid employee: " + manager.findHighestSalary());
		System.out.println("Finding an Optional of highest paid employee when no employees exist: " + emptyManager.findHighestSalary());
		
		System.out.println("Finding the name of the highest paid employee: " 
				+ manager.findHighestSalary().map(employee -> employee.getName()).orElse("No employees were found!"));
		System.out.println("Finding the name of the highest paid employee when no employees exist: " 
				+ emptyManager.findHighestSalary().map(employee -> employee.getName()).orElse("No employees were found!"));

		System.out.println("Creating a list of employees' names: " + manager.extractEmployeeNames());

		System.out.println("Counting number of employees located in New York: " + manager.countEmployeesAtOffice("New York"));
		System.out.println("Counting number of employees located in London: " + manager.countEmployeesAtOffice("London"));
		System.out.println("Counting number of employees located in Rome: " + manager.countEmployeesAtOffice("Rome"));
		
		System.out.println("Finding names of different offices: " + manager.extractDistinctOffices());
		
		System.out.println("Finding names of different offices: " + manager.extractDistinctOffices());
		System.out.println("Finding names of different offices: " + manager.extractDistinctOffices());

		System.out.println("Finding an employee working in New York: " + manager.findAnyEmployeeAtOffice("New York"));
		System.out.println("Finding an employee working in London: " + manager.findAnyEmployeeAtOffice("London"));
		System.out.println("Finding an employee working in Rome: " + manager.findAnyEmployeeAtOffice("Rome"));

		System.out.println("Creating a list of employees sorted by salary: " + manager.sortedByHighestSalary());
		System.out.println("Creating a list of the 4 highest paid employees, in decreasing order: " + manager.topBySalary(4));

		System.out.println("Finding the average salary of all employees: " + manager.findAverageSalary());
		System.out.println("Finding the average salary of only New York employees: " + manager.findAverageSalaryOfOffice("New York"));
		System.out.println("Finding the average salary of only Rome employees: " + manager.findAverageSalaryOfOffice("Rome"));
	}
}

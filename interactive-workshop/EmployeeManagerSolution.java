import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class provides several examples of lambda expressions and the Stream API
 * 
 * @author jdifebo
 *
 */
public class EmployeeManagerSolution {
	List<Employee> employees;

	public EmployeeManagerSolution(List<Employee> employees){
		this.employees = employees;
	}

	/**
	 * Sorts the given list of employees by the employees' names.
	 *
	 * @param employees to sort
	 */
	public static void sortEmployeesByName(List<Employee> employees){
//		employees.sort(new Comparator<Employee>() {
//			@Override
//			public int compare(Employee e1, Employee e2) {
//				return e1.getName().compareTo(e2.getName());
//			}
//		});
//		employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		employees.sort(Comparator.comparing(Employee::getName));
	}
	
	/**
	 * An example of using anyMatch()
	 * Returns true if any employee's office matches the given office.
	 * 
	 * @param office to match
	 * @return true if there's a match
	 */
	public boolean existsEmployeeAtOffice(String office){
//		for (Employee employee : employees){
//			if (employee.getOffice().equals(office)){
//				return true;
//			}
//		}
//		return false;
		return employees.stream()
						.anyMatch(employee -> employee.getOffice().equals(office));
	}

	/**
	 * An example of using allMatch()
	 * Returns true if all employees' salaries are greater than the given salary.
	 * 
	 * @param salary to compare against
	 * @return true if all employees' salaries are higher than it
	 */
	public boolean areAllSalariesGreaterThan(int salary){
//		for (Employee employee : employees){
//			if (!(employee.getSalary() > salary)){
//				return false;
//			}
//		}
//		return true;
		return employees.stream()
						.allMatch(employee -> employee.getSalary() > salary);
	}

	/**
	 * An example of using max()
	 * Returns the maximum employee given a comparator function, in this case comparing salary
	 *
	 * @return the employee with the highest salary, or an empty optional
	 */
	public Optional<Employee> findHighestSalary(){
//		if (employees.isEmpty()){
//			return Optional.empty();
//		}
//		
//		Employee maxEmployee = employees.get(0);
//		for (Employee currentEmployee : employees){
//			if (currentEmployee.getSalary() > maxEmployee.getSalary()){
//				maxEmployee = currentEmployee;
//			}
//		}
//		return Optional.of(maxEmployee);
		return employees.stream()
				.max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
	}


	/**
	 * An example of using max()
	 * Returns the maximum employee given a comparator function, in this case comparing salary,
	 * and returns either that employee's name or the String "No employees were found!"
	 *
	 * @return the name of the employee with the highest salary, or else "No employees were found!"
	 */
	public String findNameOfHighestSalary(){
//		if (employees.isEmpty()){
//			return "No employees were found!";
//		}
//
//		Employee maxEmployee = employees.get(0);
//		for (Employee currentEmployee : employees){
//			if (currentEmployee.getSalary() > maxEmployee.getSalary()){
//				maxEmployee = currentEmployee;
//			}
//		}
//		return maxEmployee.getName();
		return employees.stream()
				.max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
				.map(emp -> emp.getName())
				.orElse("No employees were found!");
	}
	
	/**
	 * An example using map() and collect()
	 * Generates a new list containing the names of all employees
	 * 
	 * @return the list of employees' names
	 */
	public List<String> findEmployeeNames(){
//		List<String> names = new ArrayList<String>(employees.size());
//		for (Employee employee : employees){
//			names.add(employee.getName());
//		}
//		return names;
		return employees.stream()
						.map(employee -> employee.getName())
						.collect(Collectors.toList());
	}

	/**
	 * An example of filter() and count()
	 * Calculates the number of employees at a given office
	 * 
	 * @param office to filter by
	 * @return the number of employees at that office
	 */
	public long countEmployeesAtOffice(String office) {
//		long count = 0;
//		for (Employee employee : employees){
//			if (employee.getOffice().equals(office)){
//				count++;
//			}
//		}
//		return count;
		return employees.stream()
						.filter(employee -> employee.getOffice().equals(office))
						.count();
	}

	/**
	 * An example of map(), collect(), and filter()
	 * Generates a list of employees' names that all belong to a given office
	 *
	 * @param office to filter by
	 * @return the list of employees' names
	 */
	public List<String> findEmployeeNamesAtOffice(String office) {
//		List<String> names = new ArrayList<>();
//		for (Employee employee : employees){
//			if (employee.getOffice().equals(office)){
//				names.add(employee.getName());
//			}
//		}
//		return names;
		return employees.stream()
				.filter(employee -> employee.getOffice().equals(office))
				.map(Employee::getName)
				.collect(Collectors.toList());
	}

	/**
	 * An example of distinct() and count()
	 * Counts the number of different offices there are among all employees
	 *
	 * @return the number of distinct offices
	 */
	public long countNumberOfOffices() {
//		Set<String> offices = new HashSet<String>();
//		for (Employee employee : employees){
//			offices.add(employee.getOffice());
//		}
//		return offices.size();
		return employees.stream()
				.map(Employee::getOffice)
				.distinct()
				.count();
	}

	/**
	 * Returns a comma separated list of the different offices.
	 * To pass the unit test, be sure to separate with a comma and a space such as ", "
	 * 
	 * @return a String, formatted as a comma separated list of offices
	 */
	public String findDistinctOffices() {
//		Set<String> offices = new HashSet<String>();
//		for (Employee employee : employees){
//			offices.add(employee.getOffice());
//		}
//
//		StringBuilder commaSeparated = new StringBuilder();
//		for (String office : offices){
//			commaSeparated.append(office + ", ");
//		}
//		return commaSeparated.substring(0, commaSeparated.length()-2);
		return employees.stream()
						.map(employee -> employee.getOffice())
						.distinct()
						.collect(Collectors.joining(", "));
	}
	
	/**
	 * Finds any employee at the given office
	 * 
	 * @param office to filter by
	 * @return an Optional of that employee, if one exists
	 */
	public Optional<Employee> findAnyEmployeeAtOffice(String office){
//		for (Employee employee : employees){
//			if (employee.getOffice().equals(office)){
//				return Optional.of(employee);
//			}
//		}
//		return Optional.empty();
		return employees.stream()
						.filter(employee -> employee.getOffice().equals(office))
						.findAny();
	}

	/**
     * Finds the top paid employees at a given office, in sorted order
	 *
	 * @param office to filter by
	 * @param limit the number of employees to find
	 * @return a list of the employees
	 */
	public List<Employee> topSalaryAtOffice(String office, int limit) {
//		List<Employee> employeesAtOffice = new ArrayList<>();
//		for (Employee employee : employees){
//			if (employee.getOffice().equals(office)){
//				employeesAtOffice.add(employee);
//			}
//		}
//		employeesAtOffice.sort(new Comparator<Employee>(){
//			@Override
//			public int compare(Employee e1, Employee e2) {
//				return Integer.compare(e2.getSalary(), e1.getSalary());
//			}
//		});
//		return employeesAtOffice.subList(0, limit);
		return employees.stream()
						.filter(employee -> employee.getOffice().equals(office))
				.sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
						.limit(limit)
						.collect(Collectors.toList());
	}

	/**
	 * Finds the average employee salary by using an IntStream
	 * 
	 * @return the average salary, or 0 if no employees exist
	 */
	public double findAverageSalary() {
//		if (employees.isEmpty()){
//			return 0;
//		}
//		int total = 0;
//		for (Employee employee : employees){
//			total += employee.getSalary();
//		}
//		return ((double) total) / employees.size();
		return employees.stream()
						.mapToInt(Employee::getSalary)
						.average()
						.orElse(0);
	}

	/**
	 * Finds the total salary of all employees at a given office
	 * 
	 * @param office to filter by
	 * @return the total salary
	 */
	public int findTotalSalaryOfOffice(String office) {
//		int total = 0;
//		int count = 0;
//		for (Employee employee : employees){
//			if (employee.getOffice().equals(office)){
//				total += employee.getSalary();
//				count++;
//			}
//		}
//		if (count == 0){
//			return OptionalDouble.empty();
//		}
//		return OptionalDouble.of(((double) total) / count);
		return employees.stream()
						.filter(employee -> employee.getOffice().equals(office))
						.mapToInt(Employee::getSalary)
						.sum();
	}

}

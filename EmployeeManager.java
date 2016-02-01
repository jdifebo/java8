import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class provides several examples of lambda expressions and the Stream API
 * 
 * @author jdifebo
 *
 */
public class EmployeeManager {
	List<Employee> employees;
	
	public EmployeeManager(List<Employee> employees){
		this.employees = employees;
	}
	
	/**
	 * An example of using anyMatch()
	 * Returns true if any employee's office matches the given office.
	 * 
	 * @param office
	 * @return
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
	 * @param salary
	 * @return
	 */
	public boolean allSalariesGreaterThan(int salary){
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
	 * @return
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
	 * An example using map() and collect()
	 * First maps a Stream<Employee> to a Stream<String> by reading each employee's name,
	 * then creates a new list from the elements of the new Stream<String> and returns that.
	 * 
	 * @return
	 */
	public List<String> extractEmployeeNames(){
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
	 * First filters the Stream to create a new Stream containing only the elements that
	 * match the given condition, and then counts the number of elements in the new stream
	 * 
	 * @param office
	 * @return
	 */
	public long countEmployeesAtOffice(String office) {
//		int count = 0;
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
	 * An example of map(), distinct(), and collect()
	 * First maps the Stream<Employee> to a Stream<String> containing the employees' offices,
	 * then removes duplicate entries using distinct, and finally creates a list of the result.
	 * 
	 * @return
	 */
	public Set<String> extractDistinctOffices() {
//		Set<String> offices = new HashSet<String>();
//		for (Employee employee : employees){
//			offices.add(employee.getOffice());
//		}
//		return offices;
		return employees.stream()
						.map(employee -> employee.getOffice())
						.distinct()
						.collect(Collectors.toSet());
	}
	
	/**
	 * An example of filter() and findAny()
	 * First filters by a given office, and then uses findAny() to return an employee
	 * from that office.  This is not guaranteed to return the first employee from that 
	 * office, if you need that, use findFirst()
	 * 
	 * @param office
	 * @return
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
	 * An example of sorted() and collect()
	 * Sorts the stream using a given comparator function, then puts the results
	 * in a new list
	 * 
	 * @return
	 */
	public List<Employee> sortedByHighestSalary() {
//		List<Employee> copy = new ArrayList<Employee>(employees);
//		copy.sort(new Comparator<Employee>(){
//			@Override
//			public int compare(Employee e1, Employee e2) {
//				return Integer.compare(e2.getSalary(), e1.getSalary());
//			}
//		});
//		return copy;
		return employees.stream()
						.sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
						.collect(Collectors.toList());
	}

	/**
	 * An example of sorted(), limit() and collect()
	 * Sorts the stream using a given comparator function, but then truncates the
	 * stream to contain only a certain number of elements.  Finally it puts the results
	 * in a new list
	 * 
	 * @param toRetrieve
	 * @return
	 */
	public List<Employee> topBySalary(int toRetrieve) {
//		List<Employee> copy = new ArrayList<Employee>(employees);
//		copy.sort(new Comparator<Employee>(){
//			@Override
//			public int compare(Employee e1, Employee e2) {
//				return Integer.compare(e2.getSalary(), e1.getSalary());
//			}
//		});
//		return copy.subList(0, toRetrieve);
		return employees.stream()
						.sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
						.limit(toRetrieve)
						.collect(Collectors.toList());
	}

	/**
	 * An example of mapToInt() and average()
	 * Uses mapToInt() to get an IntStream, a special stream that is designed to work with 
	 * primitive int values.  Then uses average() to find the average value.  Note that 
	 * average() is not available on "normal" streams, but is available to IntStream, 
	 * LongStream, and DoubleStream
	 * 
	 * @return
	 */
	public OptionalDouble findAverageSalary() {
//		if (employees.isEmpty()){
//			return OptionalDouble.empty();
//		}
//		int total = 0;
//		for (Employee employee : employees){
//			total += employee.getSalary();
//		}
//		return OptionalDouble.of(((double) total) / employees.size());
		return employees.stream()
						.mapToInt(employee -> employee.getSalary())
						.average();
	}

	/**
	 * An example of filter(), mapToInt(), and average()
	 * Very similar to the above example, but uses filter() to only include
	 * employees from a given office
	 * 
	 * @param office
	 * @return
	 */
	public OptionalDouble findAverageSalaryOfOffice(String office) {
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
						.mapToInt(employee -> employee.getSalary())
						.average();
	}
}

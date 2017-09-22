import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


/**
 * Created by jdifebo on 1/26/2017.
 */
public class EmployeeManagerTest {
    EmployeeManager manager = new EmployeeManager(generateData());
    EmployeeManager emptyManager = new EmployeeManager(Collections.emptyList());

    @Before
    public void before() {
        manager = new EmployeeManager(generateData());
        emptyManager = new EmployeeManager(Collections.emptyList());
    }

    public static List<Employee> generateData(){
        return Arrays.asList(
                new Employee("Matt", 50000, "New York"),
                new Employee("Steve", 65000, "London"),
                new Employee("Carrie", 100000, "New York"),
                new Employee("Peter", 70000, "New York"),
                new Employee("Alec", 60000, "London"),
                new Employee("Sarah", 85000, "London"),
                new Employee("Rebecca", 40000, "New York"),
                new Employee("Pat", 50000, "New York"),
                new Employee("Tammy", 90000, "New York"),
                new Employee("Fred", 50000, "Tokyo"));
    }

    @Test
    public void sortedEmployeesByName() {
        List<Employee> employees = generateData();

        EmployeeManager.sortEmployeesByName(employees);


        assertTrue(employees.get(0).getName().equals("Alec"));
        assertTrue(employees.get(1).getName().equals("Carrie"));
        assertTrue(employees.get(2).getName().equals("Fred"));
    }

    @Test
    public void existsEmployeeAtOffice() {
        assertTrue(manager.existsEmployeeAtOffice("London"));
        assertFalse(manager.existsEmployeeAtOffice("Rome"));
    }

    @Test
    public void areAllSalariesGreaterThan(){
        assertTrue(manager.areAllSalariesGreaterThan(10000));
        assertFalse(manager.areAllSalariesGreaterThan(50000));
    }

    @Test
    public void findHighestSalary(){
        assertTrue(manager.findHighestSalary().map(emp -> emp.getName().equals("Carrie")).orElse(false));
        assertFalse(emptyManager.findHighestSalary().isPresent());
    }


    @Test
    public void findNameOfHighestSalary(){
        assertEquals(manager.findNameOfHighestSalary(), "Carrie");
        assertTrue(emptyManager.findNameOfHighestSalary().toLowerCase().contains("no employee"));
    }

    @Test
    public void findEmployeeNames(){
        List<String> names = manager.findEmployeeNames();
        List<Employee> employees = generateData();
        assertTrue(names.size() == employees.size());
        for (int i = 0; i < names.size(); i++){
            assertEquals(names.get(i), employees.get(i).getName());
        }
    }

    @Test
    public void countEmployeesAtOffice(){
        assertEquals(6, manager.countEmployeesAtOffice("New York"));
        assertEquals(3, manager.countEmployeesAtOffice("London"));
        assertEquals(0, manager.countEmployeesAtOffice("Rome"));
    }

    @Test
    public void findEmployeeNamesAtOffice(){
        List<String> employeeNamesAtNewYork = manager.findEmployeeNamesAtOffice("New York");
        List<String> expected = Arrays.asList("Matt", "Carrie", "Peter", "Rebecca", "Pat", "Tammy");
        assertEquals(expected, employeeNamesAtNewYork);
    }

    @Test
    public void countNumberOfOffices(){
        long result = manager.countNumberOfOffices();
        long expected = 3;
        assertEquals(expected, result);
    }

    @Test
    public void findDistinctOffices(){
        String commaSeparated = manager.findDistinctOffices();
        Set<String> offices = new HashSet<>(Arrays.asList(commaSeparated.split(", ")));
        Set<String> expected = new HashSet<>(Arrays.asList("New York", "London", "Tokyo"));
        assertEquals("Length of comma separated list should be 23", 23, commaSeparated.length());
        assertEquals(expected, offices);
    }

    @Test
    public void findAnyEmployeeAtOffice(){
        Set<String> londonEmployees = new HashSet<>(Arrays.asList("Steve", "Alec", "Sarah"));
        Optional<Employee> anyLondonEmployee = manager.findAnyEmployeeAtOffice("London");
        assertTrue(anyLondonEmployee.isPresent());
        assertTrue(londonEmployees.contains(anyLondonEmployee.get().getName()));
    }

    @Test
    public void topThreeAtOffice(){
        List<Employee> topLondomEmployees = manager.topSalaryAtOffice("London", 2);
        assertEquals(2, topLondomEmployees.size());
        assertEquals("Sarah", topLondomEmployees.get(0).getName());
        assertEquals("Steve", topLondomEmployees.get(1).getName());
    }

    @Test
    public void findAverageSalary(){
        assertEquals(66000, manager.findAverageSalary(), 1);
        assertEquals(0, emptyManager.findAverageSalary(), 1);
    }


    @Test
    public void findTotalSalaryOfOffice(){
        assertEquals(400000, manager.findTotalSalaryOfOffice("New York"));
        assertEquals(210000, manager.findTotalSalaryOfOffice("London"));
        assertEquals(50000, manager.findTotalSalaryOfOffice("Tokyo"));
        assertEquals(0, manager.findTotalSalaryOfOffice("Rome"));
    }
}
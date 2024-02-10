package activityGuide;

import java.util.ArrayList;

public class Manager extends Employee {

    private ArrayList<Employee> employeeList;

    public Manager(String name, int level) {
        super(name, "Manager", level);
        this.employeeList = new ArrayList<Employee>();
    }

    public void setEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return this.employeeList;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("The manager has the following employees:");
        for (Employee employee : this.employeeList) {
            System.out.println("\t" + employee.getName());
        }
    }
}

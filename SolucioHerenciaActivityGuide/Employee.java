package activityGuide;

public class Employee {

    protected static int employeeIDCounter = 0;
    private int employeeID;
    private String name;
    private String jobTitle;
    private int level;

    public Employee(String name, String jobTitle, int level) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.level = level;
        this.calculateEmployeeID();
    }

    public void calculateEmployeeID() {
        employeeIDCounter++;
        // this.setEmployeeID(employeeIDCounter);
        this.employeeID = employeeIDCounter;
    }

    public void displayInformation() {
        System.out.println("Name: " + this.name);
        System.out.println("Job Title: " + this.jobTitle);
        System.out.println("Employee ID: " + this.employeeID);
        System.out.println("Level: " + this.level);
    }

    private void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

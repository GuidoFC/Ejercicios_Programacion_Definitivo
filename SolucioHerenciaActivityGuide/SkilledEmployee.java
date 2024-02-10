package activityGuide;

import java.util.ArrayList;

public class SkilledEmployee extends Employee {

    private ArrayList<String> skillList;

    public SkilledEmployee(String name, String jobTitle, int level) {
        super(name, jobTitle, level);
        this.skillList = new ArrayList<String>();
    }

    public void setSkill(String skill) {
        this.skillList.add(skill);
    }

    public ArrayList<String> getSkills() {
        return this.skillList;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Employee has the following skills:");
        for (String skill : skillList) {
            System.out.println("\t" + skill);
        }
    }

}

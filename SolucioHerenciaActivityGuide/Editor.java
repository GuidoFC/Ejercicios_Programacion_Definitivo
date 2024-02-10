package activityGuide;

public class Editor extends SkilledEmployee {

    private boolean prefersPaperEditing = false;

    public Editor(String name, int level) {
        super(name, "Editor", level);
    }

    public void setPrefersPaperEditing(boolean prefersPaperEditing) {
        this.prefersPaperEditing = prefersPaperEditing;
    }

    public String getEditingPreference() {
        return this.prefersPaperEditing ? "Paper" : "Electronic";
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Editing preference: " + this.getEditingPreference());
    }

}

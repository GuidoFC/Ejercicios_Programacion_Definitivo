package activityGuide;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor("Fred Hanson", 1);
        editor.setSkill("technical editing");
        editor.setSkill("typing");
        editor.setPrefersPaperEditing(true);
        editor.displayInformation();

        Main.displayLineSeparator();

        GraphicIllustrator graphicIllustrator = new GraphicIllustrator("Frank Moses", 3);
        graphicIllustrator.setSkill("technical illustration");
        graphicIllustrator.setSkill("video production");
        graphicIllustrator.setSkill("media authoring");
        graphicIllustrator.displayInformation();

        Main.displayLineSeparator();

        TechnicalWriter technicalWriter = new TechnicalWriter("James Ralph", 1);
        technicalWriter.setSkill("technical writing");
        technicalWriter.displayInformation();

        Main.displayLineSeparator();

        Manager manager = new Manager("Susan Smith", 2);
        manager.setEmployee(editor);
        manager.setEmployee(graphicIllustrator);
        manager.setEmployee(technicalWriter);
        manager.displayInformation();

    }

    private static void displayLineSeparator() {
        System.out.println();
        System.out.println("**** **** ****");
        System.out.println();
    }
}

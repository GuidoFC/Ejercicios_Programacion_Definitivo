public class Borders {

    private static final char VERTICAL_LINE = '║';
    private static final char HORIZONTAL_LINE = '═';
    private static final char TOP_LEFT_CORNER = '╔';
    private static final char BOT_LEFT_CORNER = '╚';
    private static final char TOP_RIGHT_CORNER = '╗';
    private static final char BOT_RIGHT_CORNER = '╝';
    private static final int TOP_BORDER = 0;
    private static final int BOT_BORDER = 1;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Prints a text inside of a rectanble with unicode borders
     * 
     * @param text - text included inside the borders
     * 
     */
    public static void printTextWithBorders(String text) {
        String[] lines = text.split("\n");
        int width = obtainMaxWidth(lines);
        printBorders(lines, width);
    }

    private static void printBorders(String[] lines, int width) {
        printTopBorder(width);
        printLines(lines, width);
        printBotBorder(width);
    }

    private static void printTopBorder(int width) {
        printBorder(TOP_BORDER, width);
    }

    private static void printBotBorder(int width) {
        printBorder(BOT_BORDER, width);
    }

    private static int obtainMaxWidth(String[] lines) {
        int widthMax = 0;
        for (String currentLine : lines) {
            if (currentLine.length() > widthMax)
                widthMax = currentLine.length();
        }
        return widthMax;
    }

    private static void printLines(String[] lines, int maxLines) {
        for (int i = 0; i < lines.length; i++) {
            System.out.print(VERTICAL_LINE + "  ");
            for (int j = 0; j < maxLines; j++) {
                if (j < lines[i].length())
                    System.out.print(lines[i].charAt(j) + "");
                else
                    System.out.print(" ");
            }
            System.out.println(" " + VERTICAL_LINE);
        }
    }

    private static void printBorder(int tipoBorde, int width) {

        System.out.print(tipoBorde == TOP_BORDER ? TOP_LEFT_CORNER : BOT_LEFT_CORNER);
        for (int i = 0; i < width + 3; i++)
            System.out.print(HORIZONTAL_LINE);
        System.out.println(tipoBorde == TOP_BORDER ? TOP_RIGHT_CORNER : BOT_RIGHT_CORNER);

    }

}
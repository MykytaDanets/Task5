public class AsciiTree {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Missing argument. Correct usage of app: java AsciiTree <length>");
            }

            int length = Integer.parseInt(args[0]);

            if (length < 0) {
                throw new IllegalArgumentException("Length cannot be negative.");
            }

            drawTree(length);

        } catch (NumberFormatException e) {
            System.out.println("Error: value must be an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void drawTree(int length) {
        if (length == 0 || length == 1) {
            System.out.println("*");
            return;
        }

        int maxWidth = 1;
        for (int width = 3; width <= length; width += 2) {
            maxWidth = width;
        }

        printCentered(maxWidth, 1);

        for (int widthToPrint = 3; widthToPrint <= maxWidth; widthToPrint += 2) {
            printCentered(maxWidth, widthToPrint);
            printCentered(maxWidth, widthToPrint);
        }

        printCentered(maxWidth, 1);
    }

    private static void printCentered(int totalWidth, int stars) {
        int spaces = (totalWidth - stars) / 2;
        if (spaces < 0) spaces = 0;
        System.out.println(" ".repeat(spaces) + "*".repeat(stars));
    }
}

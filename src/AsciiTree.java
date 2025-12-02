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
            System.out.println("\u001B[32m*\u001B[0m");
            return;
        }

        int maxWidth = (length % 2 == 0) ? length - 1 : length;
        int bodyRows = length - 2;

        printCentered(maxWidth, 1, "\u001B[31m");

        int width = 3;
        int rowsPrinted = 0;

        while (rowsPrinted < bodyRows) {
            for (int i = 0; i < 2 && rowsPrinted < bodyRows; i++) {
                printCentered(maxWidth, width, "\u001B[32m");
                rowsPrinted++;
            }
            width += 2;
            if (width > maxWidth) width = maxWidth;
        }

        printCentered(maxWidth, 1, "\u001B[33m");
    }

    private static void printCentered(int totalWidth, int stars, String color) {
        int spaces = (totalWidth - stars) / 2;
        System.out.println(" ".repeat(spaces) + color + "*".repeat(stars) + "\u001B[0m");
    }
}

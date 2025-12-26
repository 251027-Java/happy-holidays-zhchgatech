import java.util.Random;

/**
 * Holiday ASCII Art Generator
 * 
 * Your task: Create a festive Christmas tree using ASCII characters!
 * 
 * Basic tree structure:
 * * <- Star on top
 * *** <- Tree branches (odd numbers of *)
 * *****
 * *******
 * ||| <- Trunk
 */
public class HolidayArt {

    public static void main(String[] args) {
        // TODO: Parse command-line argument for tree height (default: 5)
        int height = 5;

        // TODO: Print the tree
        printTree(height);
    }

    /**
     * Prints a Christmas tree with the given height.
     * 
     * @param height Number of branch levels (not including star and trunk)
     */
    public static void printTree(int height) {
        // TODO: Implement this method
        //
        // Steps:
        // 1. Print the star on top (centered)
        // 2. Loop through each level of branches
        // - Calculate spaces needed for centering
        // - Calculate stars needed (1, 3, 5, 7, ...)
        // 3. Print the trunk (centered)

        Random random = new Random();
        int maxWidth = height * 2 - 1;

        // 1. Print the star
        printCentered("★", maxWidth);

        // 2. Print branches
        for (int level = 1; level <= height; level++) {
            int stars = level * 2 - 1;
            StringBuilder row = new StringBuilder();

            for (int i = 0; i < stars; i++) {
                // Add ornaments randomly (not on edges)
                if (i > 0 && i < stars - 1 && random.nextInt(4) == 0) {
                    row.append(random.nextBoolean() ? 'o' : 'O');
                } else {
                    row.append('*');
                }
            }

            printCentered(row.toString(), maxWidth);
        }

        // 3. Print trunk
        printCentered("|||", maxWidth);

        // 4. Festive message
        System.out.println();
        System.out.println("✨ Happy Holidays! ✨");
    }

    /**
     * Helper method to center text based on tree width
     */
    private static void printCentered(String text, int width) {
        int spaces = (width - text.length()) / 2;
        System.out.println(" ".repeat(spaces) + text);
    }

}

import java.util.Scanner;

public class Skyscraper {

    public static int n;
    public static int m;
    public static int c;

    public static void main(String[] args) {
        // readInVariables();

        n = 100; // TODO: FOR TESTING ONLY
        m = 100; // TODO: FOR TESTING ONLY
        c = 1; // TODO: FOR TESTING ONLY

        int x = Integer.parseInt(args[0]);
        switch (x) {
        case 1:
            firstTask();
            break;
        case 2:
            secondTask();
            break;
        case 3:
            thirdTask();
            break;
        case 4:
            fourthTask();
            break;
        }
    }

    public static void readInVariables() {
        System.out.println("Enter your variables N, M, and C, separated by one space: ");

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        c = input.nextInt();

        System.out.printf("N = %d, M = %d, C = %d.\n", n, m, c);

        input.close();
    }

    /**
     * This is a Θ(N*M) time algorithm that uses O(M) space for computing a largest
     * area square block where all cells have height C.
     * 
     * We do this as we did the question in Exam 1. We look to see if in the numbers
     * in a given matrix cell = c. If that's the case, we take the minimum of the
     * cells above, left, and above-left, and add 1 to it, then put that in the cell
     * of the number. If it is not c, it is 0. We only need to keep track of one
     * line of length M, and read the next line as it comes through the input
     * stream. This ensures we find our solution in Θ(N*M) time and with O(M) space.
     */
    public static void firstTask() {
        System.out.println("You are starting the first task.");

        int[] buffer = new int[m];

        Scanner stream = new Scanner(System.in);
        
        int[] maxSquare = new int[2];
        maxSquare[0] = -1;
        maxSquare[1] = -1;

        /* This for-loop iterates n*m times, which makes this algorithm work in Θ(N*M)
         * time */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (stream.nextInt() == c) {
                   // buffer[m] = Math.min(a, b);
                }
            }
        }

        stream.close();
    }

    /**
     * This is a Θ(N*M^2) time algorithm that uses O(M) space for computing a
     * largest area rectangle block where all cells have height C.
     */
    public static void secondTask() {
        System.out.println("You are starting the second task.");
    }

    /**
     * This is an Θ(N*M) time algorithm that uses O(M) space for computing a largest
     * area rectangle block where all cells have height C.
     */
    public static void thirdTask() {
        System.out.println("You are starting the third task.");
    }

    /**
     * This is an Θ(N*M^2*C) time algorithm that uses O(M*C) space for computing a
     * largest area rectangle block with the height difference of at most C for any
     * two cells in the block.
     */
    public static void fourthTask() {
        System.out.println("You are starting the fourth task.");
    }

}

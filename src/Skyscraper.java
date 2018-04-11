import java.util.Scanner;

public class Skyscraper {

    public static int n;
    public static int m;
    public static int c;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        readInVariables(input);

        int x = Integer.parseInt(args[0]);
        switch (x) {
        case 1:
            firstTask(input);
            break;
        case 2:
            secondTask(input);
            break;
        case 3:
            thirdTask(input);
            break;
        case 4:
            fourthTask(input);
            break;
        }

        input.close();
    }

    public static void readInVariables(Scanner input) {
        System.out.println("Enter your variables N, M, and C, separated by one space: ");

        n = input.nextInt();
        m = input.nextInt();
        c = input.nextInt();

        System.out.printf("N = %d, M = %d, C = %d.\n", n, m, c);
    }

    /**
     * Returns the minimum of three ints
     * 
     * @param a
     *            buffer[j], the int above the current cell
     * @param b
     *            buffer[j - 1], the int above-left of the current cell
     * @param c
     *            tmpBuf[j - 1], the int left of the current cell
     * @return the minimum of the three cell values
     */
    public static int getMin(int a, int b, int c) {
        int min = Math.min(a, b);
        min = Math.min(min, c);
        return min;
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
    public static void firstTask(Scanner stream) {
        System.out.println("You are starting the first task.");

        // We are using two arrays of length m, which makes this algorithm operate with
        // O(2M) space, which means it is in O(M) space
        int[] buffer = new int[m];
        int[] tmpBuf = new int[m];

        int[] maxSquare = new int[2];
        maxSquare[0] = -1;
        maxSquare[1] = -1;

        int currentMax = -1;

        /* This for-loop iterates n*m times, which makes this algorithm work in Θ(N*M)
         * time */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = stream.nextInt();
                if (current == c) {
                    if (i == 0 || j == 0) {
                        tmpBuf[j] = 1;
                    } else {
                        int min = getMin(buffer[j], buffer[j - 1], tmpBuf[j - 1]);
                        tmpBuf[j] = min + 1;
                    }
                } else {
                    tmpBuf[j] = 0;
                }

                if (tmpBuf[j] > currentMax) {
                    currentMax = tmpBuf[j];
                    maxSquare[0] = j;
                    maxSquare[1] = i;
                }
            }
            buffer = tmpBuf;
            tmpBuf = new int[m];
        }

        int dif = currentMax - 1;
        // As per instructions in the class online discussion section, assume x is for
        // rows, and y is for columns
        System.out.printf("%d %d %d %d\n", maxSquare[1] - dif + 1, maxSquare[0] - dif + 1, maxSquare[1] + 1, maxSquare[0] + 1);
    }

    /**
     * This is a Θ(N*M^2) time algorithm that uses O(M) space for computing a
     * largest area rectangle block where all cells have height C.
     */
    public static void secondTask(Scanner stream) {
        System.out.println("You are starting the second task.");
    }

    /**
     * This is an Θ(N*M) time algorithm that uses O(M) space for computing a largest
     * area rectangle block where all cells have height C.
     */
    public static void thirdTask(Scanner stream) {
        System.out.println("You are starting the third task.");
    }

    /**
     * This is an Θ(N*M^2*C) time algorithm that uses O(M*C) space for computing a
     * largest area rectangle block with the height difference of at most C for any
     * two cells in the block.
     */
    public static void fourthTask(Scanner stream) {
        System.out.println("You are starting the fourth task.");
    }

}

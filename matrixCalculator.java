import java.util.Scanner;

/*
Matrix Calculator
Function details:
1. Show menu
    show menu
    get option (check option)
    run calculator
2. Calculator
    a. Addition
    b. Subtraction
add and sub has the same algorithm:
    c. Multiplication
    a, b and c have same algorithm at
    add and sub has the same algorithm at:
get size (row/column)
get matrix according to size
    differences:
check valid size (matrix 2)
calculate using multi dimensions array
print out
    d. Quit
 */
public class matrixCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int option = getOption();
            runCalculator(option);
        }
    }

    private static void runCalculator(int option) {
        switch (option) {
            case 1:
                additionMatrix();
                break;
            case 2:
                subtractionMatrix();
                break;
            case 3:
                multiplicationMatrix();
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
    }

    private static void multiplicationMatrix() {
        int row1 = getMatrixSize("Row", 1);
        int col1 = getMatrixSize("Column", 1);
        double[][] matrix1 = generateMatrix(row1, col1, 1);
        int row2 = getMatrixSize("Row", 2);
        int col2 = getMatrixSize("Column", 2);
        if (col1 != row2) System.out.println("Wrong matrix size!");
        else {
            double[][] matrix2 = generateMatrix(row2, col2, 2);
            double[][] product = multi(matrix1, matrix2);
            printCalculation(matrix1, "*", matrix2, product);
        }
    }

    private static double[][] multi(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for (int row = 0; row < result.length; row++)
            for (int col = 0; col < result[0].length; col++) {
                for (int i = 0; i < matrix2.length; i++) {
                    result[row][col] += (matrix1[row][i] * matrix2[i][col]);
                }
            }
        return result;
    }

    private static void subtractionMatrix() {
        int row1 = getMatrixSize("Row", 1);
        int col1 = getMatrixSize("Column", 1);
        double[][] matrix1 = generateMatrix(row1, col1, 1);
        int row2 = getMatrixSize("Row", 2);
        int col2 = getMatrixSize("Column", 2);
        if (row1 != row2 || col1 != col2) System.out.println("Wrong matrix size!");
        else {
            double[][] matrix2 = generateMatrix(row1, col1, 2);
            double[][] difference = subtract(matrix1, matrix2);
            printCalculation(matrix1, "-", matrix2, difference);
        }
    }

    private static double[][] subtract(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int row = 0; row < result.length; row++)
            for (int col = 0; col < result[0].length; col++) result[row][col] = matrix1[row][col] - matrix2[row][col];
        return result;
    }

    private static void additionMatrix() {
        int row1 = getMatrixSize("Row", 1);
        int col1 = getMatrixSize("Column", 1);
        double[][] matrix1 = generateMatrix(row1, col1, 1);
        int row2 = getMatrixSize("Row", 2);
        int col2 = getMatrixSize("Column", 2);
        if (row1 != row2 || col1 != col2) System.out.println("Wrong matrix size!");
        else {
            double[][] matrix2 = generateMatrix(row1, col1, 2);
            double[][] sum = add(matrix1, matrix2);
            printCalculation(matrix1, "+", matrix2, sum);
        }
    }

    private static int getMatrixSize(String type, int number) {
        for (; ; ) {
            try {
                System.out.print("Enter " + type + " Matrix " + number + ": ");
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input > 0) {
                    return input;
                } else System.out.println("Please enter a positive number");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive number");
            } catch (Exception e) {
                System.out.println("Error! Reason: " + e);
            }
        }
    }

    private static void printCalculation(double[][] matrix1, String operator, double[][] matrix2, double[][] sum) {
        print(matrix1);
        System.out.println(operator);
        print(matrix2);
        System.out.println("=");
        print(sum);
    }

    private static void print(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.format("%-10s", "[" + doubles[col] + "]");
            }
            System.out.println();
        }
    }

    private static double[][] add(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int row = 0; row < result.length; row++)
            for (int col = 0; col < result[0].length; col++) result[row][col] = matrix1[row][col] + matrix2[row][col];
        return result;
    }

    private static double[][] generateMatrix(int rowNumber, int colNumber, int number) {
        double[][] matrix = new double[rowNumber][colNumber];
        for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++)
            for (int colIndex = 0; colIndex < colNumber; colIndex++) {
                System.out.print("Enter Matrix" + number + "[" + (rowIndex + 1) + "][" + (colIndex + 1) + "]:");
                matrix[rowIndex][colIndex] = getMatrixValue();
            }
        return matrix;
    }

    private static double getMatrixValue() {
        for (; ; ) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            } catch (Exception e) {
                System.out.println("Error! Reason: " + e);
            }
        }
    }

    private static int getOption() {
        for (; ; ) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input == 1 || input == 2 || input == 3 || input == 4) {
                    return input;
                } else System.out.println("Please choose 1, 2, 3 or 4");
            } catch (NumberFormatException e) {
                System.out.println("\"Please choose 1, 2, 3 or 4\"");
            } catch (Exception e) {
                System.out.println("Error! Reason: " + e);
            }
        }
    }

    private static void showMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }
}

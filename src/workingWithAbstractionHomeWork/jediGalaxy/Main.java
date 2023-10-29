package workingWithAbstractionHomeWork.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] galaxyMatrix = readAndInitializeMatrix(scanner);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] jediCoordsArray = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoords = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvilAndDestroyStars(galaxyMatrix, evilCoords);
            sum += moveJediAndCalculateSum(galaxyMatrix, jediCoordsArray);

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static boolean jediIsMoving(int[][] galaxyMatrix, int jediRow, int jediCol) {
        int galaxyMatrixColumnsLength = galaxyMatrix[1].length;
        return jediRow >= 0 && jediCol < galaxyMatrixColumnsLength;
    }

    private static boolean evilIsMoving(int evilRow, int evilCol) {
        return evilRow >= 0 && evilCol >= 0;
    }

    private static void moveEvilAndDestroyStars(int[][] galaxyMatrix, int[] evilCoords) {
        int evilRow = evilCoords[0];
        int evilCol = evilCoords[1];

        while (evilIsMoving(evilRow, evilCol)) {

            if (isInGalaxyMatrix(galaxyMatrix, evilRow, evilCol)) {
                galaxyMatrix[evilRow][evilCol] = 0;
            }

            evilRow--;
            evilCol--;
        }
    }

    private static long moveJediAndCalculateSum(int[][] galaxyMatrix, int[] jediCoords) {
        int jediRow = jediCoords[0];
        int jediCol = jediCoords[1];

        long sum = 0;
        while (jediIsMoving(galaxyMatrix, jediRow, jediCol)) {

            if (isInGalaxyMatrix(galaxyMatrix, jediRow, jediCol)) {
                sum += galaxyMatrix[jediRow][jediCol];
            }

            jediRow--;
            jediCol++;
        }
        return sum;
    }

    private static boolean isInGalaxyMatrix(int[][] galaxyMatrix, int jediRow, int jediCol) {
        int galaxyMatrixColumnsLength = galaxyMatrix[0].length;

        return jediRow >= 0 && jediRow < galaxyMatrix.length && jediCol >= 0 && jediCol < galaxyMatrixColumnsLength;
    }

    static int[][] readAndInitializeMatrix(Scanner scanner) {

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];

        int value = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }
}

import java.util.Arrays;

public class JavaTask4 {

    private static String word; //для определения палидрома
    // Метод для сортировки одномерного массива (пузырьковая сортировка)
    public static int[] step1(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    // Метод для сортировки многомерного массива (матрицы) по столбцам
    public static int[][] step2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int col = 0; col < cols; col++) {
            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < rows - i - 1; j++) {
                    if (matrix[j][col] > matrix[j + 1][col]) {
                        // Обмен элементов в столбце
                        int temp = matrix[j][col];
                        matrix[j][col] = matrix[j + 1][col];
                        matrix[j + 1][col] = temp;
                    }
                }
            }
        }
        return matrix;
    }
    //Умножение матрицы на вектор
    public static double[] mul(double[][] matrix, double[] vector) {
    int m = matrix.length;
    int n = matrix[0].length;
    double[] result = new double[m];

    for (int i = 0; i < m; i++) {
        double sum = 0;
        for (int j = 0; j < n; j++) {
            sum += matrix[i][j] * vector[j];
        }
        result[i] = sum;
    }

    return result;
}
    //Умножение матрицы на матрицу
    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
    int m = matrixLeft.length;
    int p = matrixLeft[0].length;
    int n = matrixRight[0].length;
    double[][] result = new double[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            double sum = 0;
            for (int k = 0; k < p; k++) {
                sum += matrixLeft[i][k] * matrixRight[k][j];
            }
            result[i][j] = sum;
        }
    }

    return result;
}
    //Определяем слово палидром
    public static boolean isPalindrom(String word) {
        JavaTask4.word = word;

    word = word.toLowerCase();

    int left = 0;
    int right = word.length() - 1;

    while (left < right) {
        // Сравниваем символы с обоих концов слова
        if (word.charAt(left) != word.charAt(right)) {
            return false; // Если символы различны, это не палиндром
        }
        left++; // Переходим к следующему символу слева
        right--; // Переходим к следующему символу справа
    }

    return true; // Если дошли до середины и не встретили различий, это палиндром
}




    public static void main(String[] args) {
        // Пример использования
        int[] oneDimensionalArray = {5, 2, 9, 1, 7};
        int[][] matrix = {
            {3, 8, 1},
            {6, 2, 5},
            {4, 7, 9}
        };

        // Сортировка одномерного массива
        int[] sortedArray = step1(oneDimensionalArray);
        System.out.println("Отсортированный одномерный массив: " + Arrays.toString(sortedArray));

        // Сортировка многомерного массива (матрицы)
        int[][] sortedMatrix = step2(matrix);
        System.out.println("Отсортированная матрица:");
        for (int[] row : sortedMatrix) {
            System.out.println(Arrays.toString(row));
        }

}
}
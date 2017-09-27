package func;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class Functions {

    @Getter @Setter private int size;

    public Functions(int size) {
        this.size = size;
    }

    /**
     * F1: e = (A*B) + (C*(D*(MA*MD)))
     * @param A  - vector
     * @param B  - vector
     * @param C  - vector
     * @param D  - vector
     * @param MA - matrix
     * @param MD - matrix
     * @return e = (A*B) + (C*(D*(MA*MD)))
     */
    public int F1(int[] A, int[] B, int[] C, int[] D, int[][] MA, int[][] MD) {
        return scalar(A, B) + scalar(C, vectorMatrixMultiplication(D, matrixMultiplication(MA, MD)));
    }

    /**
     * F2: ML = SORT(MF + MG*MH)
     * @param MF - matrix
     * @param MG - matrix
     * @param MH - matrix
     * @return ML = SORT(MF + MG*MH)
     */
    public int[][] F2 (int[][] MF, int[][] MG, int[][] MH) {
        return matrixAddition(MF, matrixMultiplication(MG, MH));
    }

    /**
     * F3: O = MAX(MP*MR)*T
     * @param MP - matrix
     * @param MR - matrix
     * @param T  - vector
     * @return O = MAX(MP*MR)*T
     */
    public int[] F3(int[][] MP, int[][] MR, int[] T) {
        return numberVectorMultiplication(matrixMax(matrixMultiplication(MP, MR)), T);
    }

    /**
     * Fill vector with number num
     * @param num    - number
     * @param vector - vector
     */
    public void fillArrWithNum(int num, int[] vector) {
        Arrays.fill(vector, num);
    }

    /**
     * Fill matrix with number num
     * @param num    - number
     * @param matrix - matrix
     */
    public void fillMatrixWithNum(int num, int[][] matrix) {
        for (int i = 0 ; i < size; i++) {
            Arrays.fill(matrix[i], num);
        }
    }

    /**
     * Calculate scalar of A with B
     * @param A - vector
     * @param B - vector
     * @return scalar=A*B - number
     */
    private int scalar(int[] A, int[] B) {
        int scalar = 0;
        for (int i = 0; i < size; i++) {
            scalar += A[i] * B[i];
        }
        return scalar;
    }

    /**
     * Add matrix A and B
     * @param A - matrix
     * @param B - matrix
     * @return C=A+B
     */
    private int[][] matrixAddition(int[][] A, int[][] B) {

        int[][] C = new int[size][size];

        for (int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    /**
     * Multiplication matrix A and B
     * @param A - matrix
     * @param B - matrix
     * @return C=A*B - matrix
     */
    private int[][] matrixMultiplication(int[][] A, int[][] B) {
        int[][] C = new int[size][size];
        int buf;

        for (int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                buf = 0;
                for (int k = 0; k < size; k++) {
                    buf += A[i][k] * B[k][j];
                }
                C[i][j] = buf;
            }
        }

        return C;
    }

    /**
     * Multiplication vector A with matrix B
     * @param A - vector
     * @param B - matrix
     * @return C=A*B - vector
     */
    private int[] vectorMatrixMultiplication(int [] A, int[][] B) {
        int[] C = new int[size];
        int buf;

        for (int i = 0; i < size; i++ ) {
            buf = 0;
            for (int j = 0; j < size; j++) {
                buf += A[j] * B[j][i];
            }
            C[i] = buf;
        }

        return C;
    }

    /**
     * Multiplication vector A with number num
     * @param num
     * @param A
     * @return B=num*A - vector
     */
    private int[] numberVectorMultiplication(int num, int[] A) {
        int[] B = new int[size];

        for (int i = 0; i < size; i++)
            B[i] = A[i] * num;

        return B;
    }

    /**
     * Find max element from matrix
     * @param A - matrix
     * @return max element
     */
    private int matrixMax(int[][] A) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (A[i][j] > max) {
                    max = A[i][j];
                }
            }
        }

        return max;
    }

    /**
     * Sort matrix A
     * @param A - matrix
     */
    private void matrixSort(int[][] A) {
        int index = 0;
        int max   = 0;
        for (int line = 0; line < size; line++) {
            for (int i = 0; i < size; i++) {
                index = i;
                max   = A[line][i];
                for (int j = i + 1; j < size; j++) {
                    if (A[line][j] > max) {
                        index = j;
                        max   = A[line][j];
                    }
                }
                A[line][index] = A[line][i];
                A[line][i]     = max;
            }
        }
    }
}

package threads;

import func.Functions;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class Thread3 implements Runnable {

    @Getter @Setter private int[][] MP, MR;
    @Getter @Setter private int[] O, T;
    @Getter @Setter private Functions f;

    public Thread3(int size) {
        f = new Functions(size);
    }

    @Override
    public void run() {
        System.out.println("Thread3 start");

        int size = f.getSize();

        MP = new int[size][size];
        MR = new int[size][size];
        T  = new int[size];

        f.fillMatrixWithNum(1, MP);
        f.fillMatrixWithNum(1, MR);
        f.fillArrWithNum(1, T);

        try {
            Thread.sleep(1200);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        O = f.F3(MP, MR, T);
        try {
            Thread.sleep(1200);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        if (size < 10)
            System.out.printf("F3 = %s%n", Arrays.toString(O));

        System.out.println("Thread3 finish");
    }
}

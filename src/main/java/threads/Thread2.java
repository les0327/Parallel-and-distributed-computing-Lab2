package threads;

import func.Functions;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class Thread2 implements Runnable {

    @Getter @Setter private int[][] ML, MF, MG, MH;
    @Getter @Setter private Functions f;

    public Thread2(int size) {
        this.f = new Functions(size);
    }

    @Override
    public void run() {
        System.out.println("Thread2 start");

        int size = f.getSize();

        MF = new int[size][size];
        MG = new int[size][size];
        MH = new int[size][size];

        f.fillMatrixWithNum(1, MF);
        f.fillMatrixWithNum(1, MG);
        f.fillMatrixWithNum(1, MH);

        try {
            Thread.sleep(700);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        ML = f.F2(MF, MG, MH);
        try {
            Thread.sleep(700);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)
            sb.append(Arrays.toString(ML[i])).append('\n');

        if (size < 10)
            System.out.printf("F2 = %s%n", sb.toString());

        System.out.println("Thread2 finish");
    }
}

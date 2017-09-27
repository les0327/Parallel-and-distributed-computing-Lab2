package threads;

import func.Functions;
import lombok.Getter;
import lombok.Setter;

public class Thread1 extends Thread {

    @Getter @Setter private int[] A, B, C, D;
    @Getter @Setter private int[][] MA, MD;
    @Getter @Setter private Functions f;

    public Thread1(int size) {
        this.f = new Functions(size);
    }

    @Override
    public void run() {
        System.out.println("Thread1 start");

        int size = f.getSize();

        A = new int[size];
        B = new int[size];
        C = new int[size];
        D = new int[size];
        MA = new int[size][size];
        MD = new int[size][size];

        f.fillArrWithNum(1, A);
        f.fillArrWithNum(1, B);
        f.fillArrWithNum(1, C);
        f.fillArrWithNum(1, D);
        f.fillMatrixWithNum(1, MA);
        f.fillMatrixWithNum(1, MD);

        try {
            sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        int e = f.F1(A, B, C, D, MA, MD);
        try {
            sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        if (size < 10)
            System.out.printf("F1 = %d%n", e);

        System.out.println("Thread1 finish");
    }
}

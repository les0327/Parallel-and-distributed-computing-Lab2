import threads.Thread1;
import threads.Thread2;
import threads.Thread3;

import java.util.Scanner;

/**
 Parallel and distributed computing.
 Lab 2. Threads in Java
 Lisovyi Volodymyr
 IO-53
 24.09.17
 F1: e = (A*B) + (C*(D*(MA*MD)))
 F2: ML = SORT(MF + MG*MH)
 F3: O = MAX(MP*MR)*T
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Main thread start");
        System.out.println("Input size:");

        int size = new Scanner(System.in).nextInt();
        Thread thread1 = new Thread1(size);             // Thread1 - extend Thread
        thread1.setPriority(Thread.MAX_PRIORITY);

        Thread thread2 = new Thread(new Thread2(size)); // Thread2 - implement Runnable
        thread2.setPriority(7);

        Thread thread3 = new Thread(new Thread3(size)); // Thread3 - implement Runnable
        thread3.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finish");
    }
}

package lesson5;

public class Main {
    private final Object ABC = new Object();
    private volatile char m1 = 'A';


    public static void main(String[] args) {
        Main main = new Main();

        Thread t1 = new Thread(() -> {
            main.printA();

        });
        Thread t2 = new Thread(() -> {
            main.printB();
        });
        Thread t3 = new Thread(() -> {
            main.printC();
        });

        t1.start();
        t2.start();
        t3.start();

    }


    public void printA() {
        synchronized (ABC) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (m1 != 'A') {
                        ABC.wait();
                    }
                   Thread.sleep(2000);

                    System.out.print("A");
                    m1 = 'B';
                    ABC.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (ABC) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (m1 != 'B') {
                        ABC.wait();
                    }
                 Thread.sleep(2000);
                    System.out.print("B");
                    m1 = 'C';
                    ABC.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC() {
        synchronized (ABC) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (m1 != 'C') {
                        ABC.wait();
                    }
                  Thread.sleep(2000);
                    System.out.print("C");
                    m1 = 'A';
                    ABC.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
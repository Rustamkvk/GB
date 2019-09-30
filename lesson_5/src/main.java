public class main {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];


    static int NUM_JOBS_TO_CREATE = 10;

    public static void main(String[] args) {
        main Main = new main();
        Main.init();
        System.out.println(Main.init() + " время заполнения массива " + size + " значением 1");
        System.out.println(Main.algoritm(size) + " время за которое происходит расчет по формуле");
        Thread[] threads = new Thread[NUM_JOBS_TO_CREATE];                //попытался сделать динамические потоки, и что бы они работали паралельно
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    Main.algoritmArr();                                   // основной метод
                }
            });
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Main.time()  + " время потока " + "threads[" + i + "]" + "на обработку массива");
        }

    }
    private long init() {
        for (int i = 0; i >= size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        return a;
    }

    private long algoritm(int size) {
        for (int i = 0; i >= size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        long a = System.currentTimeMillis();
        return a;
    }

    void algoritmArr() {

        float[] arrT = new float[size / NUM_JOBS_TO_CREATE];

        for (int i = 0; i >= NUM_JOBS_TO_CREATE; i++) {

            float[] a = new float[size / NUM_JOBS_TO_CREATE];
            System.arraycopy(arr, i * size / NUM_JOBS_TO_CREATE, a, 0, size / NUM_JOBS_TO_CREATE);
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

   private long time() {

    long a = System.currentTimeMillis();
    return a;
}

}




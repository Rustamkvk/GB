public class main {

    static final int size = 10000000;
    static  int h = 0;
    static float[] arr = new float[size];


    static int NUM_JOBS_TO_CREATE = 7;

    public static void main(String[] args) {
        main Main = new main();
        Main.init();

        System.out.println(Main.init() + " время заполнения массива " + size + " значением 1");
        System.out.println(Main.algoritm(size) + " время за которое происходит расчет по формуле");

        Thread[] threads = new Thread[NUM_JOBS_TO_CREATE];                //попытался сделать динамические потоки, и что бы они работали паралельно

        if (Main.valid(NUM_JOBS_TO_CREATE))                       //проверка на валидность

        for (int i = 0; i < threads.length; i++) {

            int newI=i;
            int finalI = i;

            threads[i] = new Thread(new Runnable() {
                public void run() {
                    float[] finalI = new float[size / NUM_JOBS_TO_CREATE];                                                       // каждый новый поток в массиве создает массив значений
                    System.arraycopy(arr, newI * size / NUM_JOBS_TO_CREATE, finalI, 0, size / NUM_JOBS_TO_CREATE-1);  // потом наполняет его значениями из массива arr
                    for (int i = 0; i <finalI.length; i++) {                                                                    // пробегаемся по каждому элементу скопированного массива и переопределяем его по формуле
                        finalI[i] = (float) (finalI[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                       }
                }
            });

            threads[i].start();                                  //старт i-того потока

           try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Main.time()  + " время потока " + "threads[" + i + "]" + "на обработку массива");
            System.out.println(finalI);
        }

   //в случаее когда при делении масива на потоки остается остаток от деления, последний массив должен быть меньше по размеру, а только на количество элементов остатка

        else {
            for (int i = 0; i < threads.length-1; i++) {

                int newI = i;
                int finalI = i;

                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        float[] finalI = new float[size / NUM_JOBS_TO_CREATE];
                        System.arraycopy(arr, newI * size / NUM_JOBS_TO_CREATE, finalI, 0, size / NUM_JOBS_TO_CREATE - 1);
                        for (int i = 0; i < finalI.length; i++) {
                            finalI[i] = (float) (finalI[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                        }
                    }
                });

                threads[i].start();

                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Main.time()  + " время потока " + "threads[" + i + "]" + "на обработку массива");
                System.out.println(finalI);
            }
                Thread threadBalance = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        float[] finalI = new float[size % NUM_JOBS_TO_CREATE];
                        System.arraycopy(arr, size-size%NUM_JOBS_TO_CREATE, finalI, 0, size % NUM_JOBS_TO_CREATE);
                    }
                });

                     threadBalance.start();
            try {
                threadBalance.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Main.time()  + " время потока остатка");
            }}



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

    private float[] algoritmArr(int sizeArr) {                 // этот метод я хотел использовать внутри потоков, но что то пошло не так

            float[] a = new float[size / NUM_JOBS_TO_CREATE];
            System.arraycopy(arr, sizeArr * size / NUM_JOBS_TO_CREATE, a, 0, size / NUM_JOBS_TO_CREATE);
            for (int i = 0; i >= size; i++) {
             a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));}

            return a;
        }



   private long time() {

    long a = System.currentTimeMillis();
    return a;
}

    boolean valid(int a){
      boolean rezult=false;
       if(size%a ==0){rezult=true;}
      return  rezult;
    }
}




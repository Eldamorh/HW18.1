public class ThreadClass implements Runnable {
    volatile String[] array;
    int minBound;
    int maxBound;

    ThreadClass(int minBound, int maxBound) {
        array = new String[100_000_000];
        this.minBound = minBound;
        this.maxBound = maxBound;
    }


    public void run() {
        System.out.println("Начало работы");
        for (int i = minBound; i < maxBound; i++) {
            if (i % 1_000_000 == 0) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
            if (i % 3 == 0) {
                array[i] = "Fizz";
                continue;
            }
            if (i % 5 == 0) {
                array[i] = "Buzz";
                continue;
            }
            if (i % 3 == 0 && i % 5 == 0) {
                array[i] = Integer.toString(i);
            }
        }
        System.out.println("Конец работы");
    }

}

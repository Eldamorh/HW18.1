public class ThreadClass implements Runnable {
    volatile static String[] array = new String[10_000_000];
    int minBound;
    int maxBound;

    ThreadClass(int minBound, int maxBound) {
        this.minBound = minBound;
        this.maxBound = maxBound;
    }

    public void run() {
        for (int i = minBound; i < maxBound; i++) {
            if (i % 1_000_000 == 0) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
            if (i % 3 == 0 && i % 5 == 0) {
                array[i] = "FizzBuzz";
                continue;
            }
            if (i % 3 == 0) {
                array[i] = "Fizz";
                continue;
            }
            if (i % 5 == 0) {
                array[i] = "Buzz";
                continue;
            }
            array[i] = Integer.toString(i);
        }
    }
}




public class Main {

    public static void threadStart(Thread... threadArr) {
        for (Thread thread : threadArr) {
            thread.start();
        }
        for (Thread thread : threadArr) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Thread[] threadMaker(int numb) {
        Thread[] threads = new Thread[numb];
        for (int i = 0; i < numb; i++) {
            int minBound = (i * 100_000_000) / numb;
            int maxBound = (100_000_000 * (i + 1)) / numb;
            threads[i] = new Thread(new ThreadClass(minBound, maxBound));
        }
        return threads;
    }

    public static void main(String[] args) throws InterruptedException {

        /*По непонятной мне причине, вариант перенести весь функционал из threadStart в threadMaker, не ускоряет программу,
        * так же как и вариант использовать threadStart(threadMaker(n))
        * Начиная с 5 потоков происходит outOfMemory, пробовал увеличивать выделяемый объем памяти, но это дало возможность
        * увеличить количество потоков до 5 включительно, и также падает на 6*/
        Thread[] threads = threadMaker(3);
        long millis = System.currentTimeMillis();
        threadStart(threads);
        System.out.println(System.currentTimeMillis() - millis);

        

    }


}

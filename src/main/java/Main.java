
public class Main {

    public static void threadStarter(int numb) {
        for (int i = 0; i < numb; i++) {
            int minBound = (i * 10_000_000) / numb;
            int maxBound = (10_000_000 * (i + 1)) / numb;
            new Thread(new ThreadClass(minBound, maxBound)).start();
        }
    }

    public static void main(String[] args){
        threadStarter(10);
    }
}

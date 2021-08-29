public class Main {
    public static void main(String[] args) {
        PrimeNumber1 p1 = new PrimeNumber1();
        PrimeNumber2 p2 = new PrimeNumber2();
//        p1.run();
//        p2.run();
//
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
    }
}

public class Main {
    public static void main(String[] args) {
        OddThread ot = new OddThread();
        EvenThread et = new EvenThread();
        ot.start();
        try {
            ot.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        et.start();
    }
}

public class Main {
    public static void main(String[] args) {
        NumberGenerator n1 = new NumberGenerator();
        Thread1 t1 = new Thread1("Thread1",n1);
        Thread1 t2 = new Thread1("Thread2",n1);
        t1.start();
        t2.start();
    }
}

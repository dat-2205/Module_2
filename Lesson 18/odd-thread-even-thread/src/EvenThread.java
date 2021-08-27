public class EvenThread extends Thread{
    @Override
    public void run() {
        System.out.println("EvenThread Start");
        for(int i=0;i<10;i+=2) {
            System.out.println("EvenThread: " + i);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("EvenThread End");
    }
}

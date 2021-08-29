public class PrimeNumber1 implements Runnable {
    public PrimeNumber1() {
    }

    @Override
    public void run() {
        int number = 3;
        while(number<100) {
            isPrime(number);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            number++ ;
        }
    }
    public void isPrime(int number) {
        boolean isPrime = true;
        for(int i=2;i<number;i++) {
            if(number%i==0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
            System.out.println("P1: " + number);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String primeNum = "";
        System.out.println("Cac so nguyen to nho hon 100: ");
        for(int i=2;i<=100;i++){
            if(checkIsPrime(i)){
                primeNum += String.valueOf(i) + " ";
            }
        }
        System.out.println(primeNum);

    }
    public static boolean checkIsPrime(int x){
        boolean isPrime = true;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}

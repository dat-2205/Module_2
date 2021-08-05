public class Main {
    public static void main(String[] args) {
        int count = 0;
        int i = 3;
        String result = "";
        System.out.println("the first 20 prime number:  ");
        while(count<20){
            boolean isPrime = false;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }else {
                    isPrime = true;
                }
            }
            if(isPrime) {
                result+= String.valueOf(i) + " ";
                count++;
            }
            i++;
        }
        System.out.print(result);
    }
}

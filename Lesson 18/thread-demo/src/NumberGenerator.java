public class NumberGenerator {
    public NumberGenerator() {
    }
    public void display(String name) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(name + " : " + i);
            System.out.println(name + " hash code : " + this.hashCode());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Something wrong");
            }
        }
    }
}

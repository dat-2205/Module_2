public class Thread1 extends Thread{
    private String name;
    NumberGenerator numberGenerator;

    public Thread1(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }
    public void run() {
        numberGenerator.display(name);
    }
}

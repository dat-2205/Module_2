public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = this.SLOW;
    private boolean status = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return this.speed;
    }
    public boolean getStatus() {
        return this.status;
    }
    public double getRadius() {
        return this.radius;
    }
    public String getColor() {
        return this.color;
    }
    public void turnOn() {
        this.status = true;
    }
    public void turnOff() {
        this.status =false;
    }
    public void setStatus(boolean x){
        this.status = x;
    }
    public void setSpeed(int x) {
        switch(x){
            case 1:
                this.speed = SLOW;
                break;
            case 2:
                this.speed = MEDIUM;
                break;
            case 3:
                this.speed = FAST;
                break;
            default:
                System.out.println("Speed is illegal!");
        }
    }
    public void setRadius(double x) {
        this.radius = x;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String toString() {
        String toString = "";
        if(status){
           toString = "Fan { speed = "+ this.getSpeed()+ ";  color = " + this.getColor()+"; radius = " + this.getRadius() + "; \"fan is on\" }";
        }else {
            toString = "Fan {color= " +this.getColor()+ "; \"fan is off\"}";
        }
        return toString;
    }
}

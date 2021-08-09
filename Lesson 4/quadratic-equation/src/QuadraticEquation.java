public class QuadraticEquation {
    public double a;
    public double b;
    public double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getterA() {
        return this.a;
    }
    public double getterB() {
        return this.b;
    }
    public double getterC() {
        return this.c;
    }
    public double getDiscriminant() {
        double delta = Math.pow(this.b,2) - 4*this.a*this.c;
        return delta;
    }
    public double getFirstRoot() {
        double root1 = 0;
        if(getDiscriminant()>=0){
            root1 = (-this.b + Math.sqrt(getDiscriminant()))/2*this.a;

        }
        return root1;
    }
    public double getSecondRoot() {
        double root2 = 0;
        if(getDiscriminant()>=0){
            root2 = (-this.b - Math.sqrt(getDiscriminant()))/2*this.a;

        }
        return root2;
    }
    public void displayRoots() {
        if(getDiscriminant()>0){
            System.out.println("The equation has two roots: " + getFirstRoot() + " and " + getSecondRoot());
        }else if(getDiscriminant()==0){
            System.out.println("The equation has one roots: " + getFirstRoot());
        }else if(getDiscriminant()<0){
            System.out.println("The equation has no real roots!");
        }
    }
}

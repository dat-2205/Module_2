package com.codegym;

public class Shape {
    private String color;
    private boolean filled;

    public Shape(){
        this.color = "green";
        this.filled = false;
    }
    public Shape(String color, boolean filled){
       this.color = color;
       this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    @Override
    public String toString() {
        if(this.filled){
            return "A Shape with color of " + color + " and " +
                    " filled ";
        }else{
            return "A Shape with color of " + color + " and " +
                    " not filled ";
        }
    }
}

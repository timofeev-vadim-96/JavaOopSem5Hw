package calculator.model.impl;

import calculator.model.Calculator;

public class Model implements Calculator {
    private double x;
    private double y;

    public double sum() {
        return x + y;
    }
    public double diff() {return x - y;}
    public double prod() {
        return x * y;
    }
    public double div() {
        return x / y;
    }

    public void setX(double value) {
        this.x = value;
    }

    public void setY(double value) {
        this.y = value;
    }
}

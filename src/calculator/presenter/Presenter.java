package calculator.presenter;

import calculator.model.Calculator;
import calculator.model.impl.Model;

public class Presenter <T extends Calculator> {
    Model model;

    public Presenter() {
        this.model = new Model();
    }

    public double sum(double a, double b){
        setArguments(a,b);
        return model.sum();
    }

    public double diff(double a, double b){
        setArguments(a,b);
        return model.diff();
    }

    public double prod(double a, double b){
        setArguments(a,b);
        return model.prod();
    }

    public double div(double a, double b){
        setArguments(a,b);
        return model.div();
    }

    public void setArguments(double a, double b){
        model.setX(a);
        model.setY(b);
    }
}

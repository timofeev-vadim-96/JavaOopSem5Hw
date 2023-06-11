package calculator.view;

import calculator.presenter.Presenter;
import calculator.util.Command;

import java.util.Scanner;

public class View {
    Presenter presenter;
    Scanner in;

    public View() {
        this.presenter = new Presenter();
        this.in = new Scanner(System.in);
    }


    public void print(double value){
        System.out.printf("Результат: %s\n", value);
    }

    public void run(){
        Command com;
        double a = getNumb();
        while(true){
            String command = prompt("Введите команду: (SUM/DIFF/PROD/DIV/CLEAR/EXIT)\n");
            commandValidation(command);
            com = Command.valueOf(command);
            if (com == Command.EXIT) return;
            if (com == Command.CLEAR){
                a = 0;
                print(a);
                continue;
            }
            double b = getNumb();
            switch (com) {
                case SUM:
                    a = presenter.sum(a,b);
                    print(a);
                    break;
                case DIFF:
                    a = presenter.diff(a,b);
                    print(a);
                    break;
                case PROD:
                    a = presenter.prod(a,b);
                    print(a);
                    break;
                case DIV:
                    a = presenter.div(a,b);
                    print(a);
                    break;
            }

        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine().toUpperCase();
    }

    private double getNumb() {
        try{
            System.out.println("Введите число: ");
            return Double.parseDouble(in.nextLine());
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Вы ввели не число");
        }
    }

    private boolean commandValidation(String action){
        try{
            Enum.valueOf(Command.class, action);
            return true;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Unexpected command! ");
        }

    }
}

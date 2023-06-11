package usersDataBase.view;

import usersDataBase.model.User;
import usersDataBase.presenter.Presenter;
import usersDataBase.util.Commands;

import java.util.Scanner;

public class View {
    private Presenter presenter;
    private Scanner in;

    public View() {
        this.presenter = new Presenter();
        this.in = new Scanner(System.in);
    }


    public void run() {
        Commands com;
        while (true) {
            String command = prompt("Enter command: (CREATE/UPDATE/LIST/DELETE/FIND/EXIT)\n").toUpperCase().trim();
            commandValidation(command);
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String name = prompt("Enter your name: \n");
                    String login = prompt("Enter login: \n");
                    String password = prompt("Enter password: \n");
                    presenter.createUser(new User(name, login, password));
                    break;
                case UPDATE:
                    String userLogin = prompt("Enter login: \n");
                    String userPassword = prompt("Enter password: \n");
                    int id = presenter.verify(userLogin, userPassword);
                    name = prompt("Enter your name: \n");
                    login = prompt("Enter login: \n");
                    password = prompt("Enter password: \n");
                    presenter.update(new User(name, login, password), id);
                    break;
                case LIST:
                    System.out.println("Users list: \n");
                    for (User user : presenter.getAllUsers()) {
                        System.out.println(user);
                    }
                    break;
                case DELETE:
                    id = Integer.parseInt(prompt("Enter account id to delete: \n"));
                    presenter.remove(id);
                    break;
                case ENTER:
                    userLogin = prompt("Enter login: \n");
                    userPassword = prompt("Enter password: \n");
                    String userName = presenter.enter(userLogin, userPassword);
                    System.out.printf("Hi, %s\n", userName);
                    break;
                case FIND:
                    userLogin = prompt("Enter login: \n");
                    System.out.println(presenter.findByLogin(userLogin));
                    break;
            }

        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private boolean commandValidation(String action) {
        try {
            Enum.valueOf(Commands.class, action);
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unexpected command! ");
        }

    }
}

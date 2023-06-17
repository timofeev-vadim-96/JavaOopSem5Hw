package usersDataBase.presenter;

import usersDataBase.model.DB;
import usersDataBase.model.User;
import usersDataBase.model.impl.DataBase;
import usersDataBase.util.Validator;
import usersDataBase.util.impl.CommandValidator;

import java.util.InputMismatchException;
import java.util.List;

public class Presenter {
    private DataBase dataBase;
    private Validator<String> validator;

    public Presenter() {
        this.dataBase = new DataBase();
        this.validator = new CommandValidator();
    }

    public boolean validation(String command){
        return validator.validation(command);
    }

    public void createUser(User user) {
        dataBase.add(user);
    }

    public User findByLogin(String login) {
        return dataBase.getByLogin(login);
    }

    public List<User> getAllUsers() {
        return dataBase.getAll();
    }

    public void remove(int id) {
        dataBase.remove(id);
    }

    public String enter(String login, String password) {
        User user = findByLogin(login);
        if (user.getPassword() == password) return user.getName();
        else throw new InputMismatchException("you entered an incorrect password");
    }

    public int verify(String login, String password) {
        User user = dataBase.getByLogin(login);
        return dataBase.checkPassword(user, password);
    }

    public void update(User user, int id) {
        dataBase.update(user, id);
    }
}

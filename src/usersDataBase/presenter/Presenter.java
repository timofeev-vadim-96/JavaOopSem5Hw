package usersDataBase.presenter;

import usersDataBase.model.User;
import usersDataBase.model.impl.DataBase;

import java.util.InputMismatchException;
import java.util.List;

public class Presenter {
    private DataBase dataBase;

    public Presenter() {
        this.dataBase = new DataBase();
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

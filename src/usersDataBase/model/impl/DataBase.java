package usersDataBase.model.impl;

import usersDataBase.model.DB;
import usersDataBase.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DataBase implements DB<User> {
    private ArrayList<User> users;

    public DataBase() {
        this.users = new ArrayList<>();
    }

    public void add(User user) {
        if (checkingUnique(user)) users.add(user); // проверка на уникальность нового пользователя
    }

    public void remove(int id) {
        boolean flag = true;
        for (int i = 0; i < users.size(); i++) {
            if (id == users.get(i).getId()) {
                users.remove(i);
                flag = false;
                break;
            }
        }
        if (flag) throw new NoSuchElementException("A user with this id wasn't found");
    }

    @Override
    public User getById(int id) {
        for (User user : users) {
            if (id == user.getId()) {
                return user;
            }
        }
        throw new NoSuchElementException("A user with this id wasn't found");
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    public boolean checkingUnique(User newUser) {
        boolean flag = true;
        for (User user : users) {
            if (user.equals(newUser)) return flag = false;
        }
        return true;
    }

    public int size() {
        return users.size();
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) return user;
        }
        System.out.println("It is not working");
        throw new NoSuchElementException("A user with this login wasn't found");
    }

    public int checkPassword(User user, String password) {
        if (user.getPassword().equals(password)) return user.getId();
        else throw new SecurityException("Wrong password ");
    }

    public void update(User user, int id) {
        remove(id);
        user.setId(id);
        add(user);
    }
}

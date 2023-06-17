package usersDataBase.model;

/**
 * Переписал класс setPassword с излишней функциональностью (была работа с консолью с проверкой старого пороля), что
 * как нарушало MVP, так и нарушало принцип единственной ответственности.
 */

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private static int counter;

    static {
        counter = 0;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = ++counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, name: %s, login: %s", id, name, login);
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return user.login.equals(this.login) && user.id == this.id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

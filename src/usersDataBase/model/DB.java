package usersDataBase.model;

import java.util.List;

public interface DB <T>{
    void add(T t);
    void remove(int id);
    T getById(int id);
    List<T> getAll();
}

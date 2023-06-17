package usersDataBase.model;

import java.util.List;

/**
 * С целью соблюдения принципа инверсии зависимостей, абстракции ведь не должны зависеть от деталей (не зависеть
 * от конкретного типа id, переписал на обобщение
 * @param <T>
 * @param <E> - id может быть long, int, String...
 */
public interface DB<T, E> {
    void add(T t);

    void remove(E id);

    T getById(E id);

    List<T> getAll();
    void update(T t, E e);

}

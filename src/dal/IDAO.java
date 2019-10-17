package dal;

import java.util.List;

public interface IDAO<E> {
    public void create(E object);
    public List<E> findAll();

}

package dal;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<E> {
    public void create(E object);
    public List<E> findAll() throws SQLException;
    public void update(E object) throws SQLException;

}

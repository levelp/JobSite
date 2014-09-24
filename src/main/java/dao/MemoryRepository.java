package dao;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Хранение объектов в памяти
 */
public class MemoryRepository<T extends Entity> implements Repository<T> {
    static int counter = 0;

    HashMap<Integer, T> table = new LinkedHashMap<Integer, T>();

    @Override
    public int insert(T obj) throws Exception {
        counter++;

        // Присваиваем setId
        obj.setId(counter);

        table.put(obj.getId(), obj);
        return obj.getId();
    }

    @Override
    public T get(int id) {
        return table.get(id);
    }
}

package webapp.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Хранение объектов в памяти
 */
public class MemoryRepository<T extends Entity> implements Repository<T> {
    /**
     * Счётчик объектов в таблице
     */
    int counter = 0;

    /**
     * Таблица с удобным поиском по id
     */
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

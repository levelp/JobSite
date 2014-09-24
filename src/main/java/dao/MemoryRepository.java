package dao;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Хранение объектов в памяти
 */
public class MemoryRepository implements Repository {
    static int counter = 0;

    HashMap<Integer, Object> table = new LinkedHashMap<Integer, Object>();

    @Override
    public int insert(Entity obj) throws Exception {
        counter++;

        // Присваиваем setId
        obj.setId(counter);

        table.put(obj.getId(), obj);
        return obj.getId();
    }
}

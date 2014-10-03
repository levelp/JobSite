package dao;

/**
 * Репозиторий
 *
 * T - класс, объекты которого будем хранить в репозитории
 */
public interface Repository<T extends Entity> {
    /**
     * Добавление в таблицу
     *
     * @param obj Объект, который нужно добавить
     * @return Новый идентификатор в хранилище
     * @throws Exception
     */
    int insert(T obj) throws Exception;

    /**
     * Получение объекта по идентификатору
     *
     * @param id идентификатор объекта
     * @return Объект или null если объекта с таким id нет
     */
    T get(int id) throws Exception;
}

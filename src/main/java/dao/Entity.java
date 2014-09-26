package dao;

/**
 * Объект-сущность в БД
 */
public interface Entity {
    int getId();

    void setId(int id);

    <T extends Entity> void equalityCheck(T obj) throws Exception;
}

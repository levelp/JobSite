package dao;

/**
 * Объект-сущность в БД
 */
public interface Entity {
    int getId();

    void setId(int id);

    void equalityCheck(Entity e) throws Exception;
}

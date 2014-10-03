package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vladimir on 03.10.14.
 */
public abstract class DBRepository <T extends Entity> implements Repository<T>{

    protected Connection conn;
    protected Statement statement;

    public DBRepository () throws SQLException, ClassNotFoundException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/JobSite", "root", "root");
        statement = conn.createStatement();
    }

    @Override
    protected void finalize() throws Throwable {
        conn.close();
    }

    @Override
    abstract public int insert(T obj) throws Exception;

    @Override
    public T get(int id) {
        return null;
    }
}

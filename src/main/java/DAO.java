package main.java;
import java.sql.Connection;

public interface DAO {
    Connection getConnection() throws DAOException;

}

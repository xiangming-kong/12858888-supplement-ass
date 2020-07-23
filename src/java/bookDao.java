/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author koxim
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bookDao {

    public int regisBook(book bk) throws ClassNotFoundException {
        String INSERT_USERS_SQL =
            "INSERT INTO BOOK.BOOKS(id, title, author, publisher)" + "VALUES (?,?,?,?)";

        int result = 0;

        Class.forName("org.apache.derby.jdbc.ClientDriver");

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/book","book","book");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, bk.getId());
            preparedStatement.setString(2, bk.getTitle());
            preparedStatement.setString(3, bk.getAuthor());
            preparedStatement.setString(4, bk.getPublisher());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

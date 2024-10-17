import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountsTable {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/ycap_bank"; // Update with your database name
        String user = "root"; // Update with your MySQL username
        String password = "Password@123"; // Update with your MySQL password

        Connection connection = null;
        Statement statement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            // SQL statement to create the Accounts table
            String createTableSQL = "CREATE TABLE Accounts (" +
                                     "account_number INT PRIMARY KEY, " +
                                     "full_name VARCHAR(100), " +
                                     "email VARCHAR(100) UNIQUE, " +
                                     "balance DECIMAL(10, 2), " +
                                     "security_pin VARCHAR(6)" +
                                     ");";

            // Execute the SQL statement
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'Accounts' created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        try {
            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            // SQL statement to create the User table
            String createTableSQL = "CREATE TABLE User (" +
                                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                     "full_name VARCHAR(100), " +
                                     "email VARCHAR(100) UNIQUE, " +
                                     "password VARCHAR(255)" +
                                     ");";

            // Execute the SQL statement
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'User' created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

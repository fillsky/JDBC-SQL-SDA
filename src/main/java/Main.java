import java.sql.*;

public class Main {

    //Dane bazy
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_java19";

    //Dane logowania do bazy
    static final String USER = "root";
    static final String PASS = "root";


    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to db...");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Query for database");

            statement = connection.createStatement();

            String sql = "SELECT * FROM employees LIMIT 10;";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.print(rs.getInt("age") + " ");
                System.out.print(rs.getString("first_name") + " ");
                System.out.print(rs.getString("last_name") + "\n");
            }

            rs.close();
            statement.close();
            connection.close();




        } catch (ClassNotFoundException e) {
            System.out.println("NO such class");

        } catch (SQLException e) {

            System.out.println("Connection Error!");
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Something wrong with data base/resource blocked");
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Something wrong with data base/resource blocked");
                }
        }

        System.out.println("Code query complete");
    }
}

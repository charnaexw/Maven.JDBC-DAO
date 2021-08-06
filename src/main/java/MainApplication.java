import com.mysql.cj.jdbc.Driver;
import daos.CarRepository;
import models.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class MainApplication {

    public static void main(String[] args) {
        registerJDBCDriver();
        Connection mysqlDbConnection = getConnection("mysql");
        CarRepository carRepository = new CarRepository(mysqlDbConnection);
        executeStatement(mysqlDbConnection, "DROP DATABASE IF EXISTS automobiles;");
        executeStatement(mysqlDbConnection, "CREATE DATABASE IF NOT EXISTS automobiles;");
        executeStatement(mysqlDbConnection, "USE automobiles;");
        executeStatement(mysqlDbConnection, new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS automobiles.carTable(")
                .append("id int auto_increment primary key,")
                .append("make text not null,")
                .append("model text not null,")
                .append("color text not null,")
                .append("vin int not null);")
                .toString());

        carRepository.create(new Car(12L,"Toyota", "Camry", "Red", 232L));
        carRepository.create(new Car(12L,"Toyota", "Camry", "Red", 232L));

//        executeStatement(mysqlDbConnection, new StringBuilder()
//                .append("INSERT INTO automobiles.carTable(")
//                .append("id, make, model, color, vin) ")
//                .append("VALUES (12, 'Toyota', 'Camry', 'Red', 232;")
//                .toString());
//
//        executeStatement(mysqlDbConnection, new StringBuilder()
//                .append("INSERT INTO automobiles.carTable(")
//                .append("id, make, model, color, vin) ")
//                .append("VALUES (13, 'Toyota', 'Camry', 'Red', 232;")
//                .toString());
//
        System.out.println(carRepository.readAll());
    }

    static ResultSet executeQuery(Connection connection, String sqlQuery) {
        try {
            Statement statement = getScrollableStatement(connection);
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    static void printResults(ResultSet resultSet) {
        try {
            for (int rowNumber = 0; resultSet.next(); rowNumber++) {
                String firstColumnData = resultSet.getString(1);
                String secondColumnData = resultSet.getString(2);
                String thirdColumnData = resultSet.getString(3);
                String fourthColumnData = resultSet.getString(4);
                String fifthColumnData = resultSet.getString(5);
                System.out.println(new StringJoiner("\n")
                        .add("Row number = " + rowNumber)
                        .add("First Column = " + firstColumnData)
                        .add("Second Column = " + secondColumnData)
                        .add("Third Column = " + thirdColumnData)
                        .add("Fourth Column = " + fourthColumnData)
                        .add("Fifth column = " + fifthColumnData));
            }
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    static void executeStatement(Connection connection, String sqlStatement) {
        try {
            Statement statement = getScrollableStatement(connection);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    static Statement getScrollableStatement(Connection connection) {
        int resultSetType = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
        try { // scrollable statements can be iterated more than once without closing
            return connection.createStatement(resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    static Connection getConnection(String dbVendor) {
        String username = "root";
        String password = "zipcode0";
        String url = new StringBuilder()
                .append("jdbc:")
                .append(dbVendor)
                .append("://127.0.0.1/")
                .append("?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .toString();
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    static void registerJDBCDriver() {
        // Attempt to register JDBC Driver
        try {
            DriverManager.registerDriver(Driver.class.newInstance());
        } catch (InstantiationException | IllegalAccessException | SQLException e1) {
            throw new RuntimeException(e1);
        }
    }
}

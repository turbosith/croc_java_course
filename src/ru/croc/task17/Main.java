package ru.croc.task17;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


public class Main {
    //создание таблицы заказов
    private static final String CREATE_ORDER_TABLE = "DROP TABLE IF EXISTS order1;" +
            "CREATE TABLE order1 (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            "orderNumber INTEGER, " +
            "buyer TEXT, " +
            "articulate TEXT) ";
    //создание таблицы товаров
    private static final String CREATE_PRODUCT_TABLE = "DROP TABLE IF EXISTS product;" +
            "CREATE TABLE product (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            "articulate TEXT, " +
            "productName TEXT, " +
            "productPrice INTEGER, " +
            "UNIQUE (articulate)) ";
    //добавление заказа
    private static final String INSERT_ORDER = "INSERT INTO order1 (orderNumber, buyer,articulate) VALUES(?, ?, ?);";
    //добавление товара
    private static final String INSERT_PRODUCT = "INSERT INTO product (articulate, productName, productPrice) VALUES(?, ?, ?);";
    private static final String JOIN_PRODUCTS_AND_ORDERS = "SELECT * FROM order1 o JOIN product p ON o.articulate = p.articulate";


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // load JDBC driver class
        Class.forName("org.h2.Driver");

        // connection properties:
        // connect to a local database file test.mv.db
        // in a user home directory with 'sa' user credentials
        String connectionUrl = "jdbc:h2:tcp://localhost/~/croc";
        String user = "sa";
        String password = "sa";

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {
            // create and run statement
            try (Statement statement = connection.createStatement()) {
                statement.execute(CREATE_ORDER_TABLE);
                statement.execute(CREATE_PRODUCT_TABLE);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try (BufferedReader lineReader = new BufferedReader(new FileReader(args[0]));
                 PreparedStatement firstStatement = connection.prepareStatement(INSERT_ORDER);
                 PreparedStatement secondStatement = connection.prepareStatement(INSERT_PRODUCT)) {
                String line;
                String[] partsLine;
                while ((line = lineReader.readLine()) != null) {
                    partsLine = line.split(";");
                    firstStatement.setInt(1, Integer.parseInt(partsLine[0]));
                    firstStatement.setString(2, partsLine[1]);
                    firstStatement.setString(3, partsLine[2]);
                    secondStatement.setString(1, partsLine[2]);
                    secondStatement.setString(2, partsLine[3]);
                    secondStatement.setInt(3, Integer.parseInt(partsLine[4]));
                    secondStatement.executeUpdate();


                    firstStatement.executeUpdate();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(JOIN_PRODUCTS_AND_ORDERS);
            printResult(resultSet);
            statement.close();
            resultSet.close();
        }
    }

    /**
     * Вывод совмещенной таблицы товаров и заказов
     *
     * @param resultSet - таблица, получившаяся в результате
     * @throws SQLException - ошибка SQL
     */
    private static void printResult(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columsNumber = resultSetMetaData.getColumnCount();
        for (int i = 0; i < columsNumber; i++) {
            if (i >= 1) {
                System.out.print(",");
            }
            System.out.print(resultSetMetaData.getColumnName(i + 1));
        }
        System.out.println();
        while (resultSet.next()) {
            for (int i = 0; i < columsNumber; i++) {
                if (i >= 1) {
                    System.out.print(",");
                }
                System.out.print(resultSet.getString(i + 1));
            }
            System.out.println();
        }

    }
}
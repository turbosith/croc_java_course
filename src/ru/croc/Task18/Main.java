package ru.croc.Task18;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    //создание таблицы заказов


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
            test(connection);
        }
    }

    private static void test(Connection connection) throws SQLException {
        DAO dao = new DAO(connection);

        Product product = dao.findProduct("Т3");
        System.out.println(product);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product);

        System.out.println(product);

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
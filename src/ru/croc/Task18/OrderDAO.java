package ru.croc.Task18;

import java.sql.*;
import java.util.List;

public class OrderDAO {
    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    private final Connection connection;
    private static final String INSERT_ORDER = "INSERT INTO order1 (orderNumber, buyer,articulate) VALUES(?, ?, ?);";

    public Order createOrder(String userLogin, List<Product> products) throws SQLException {
        int orderNumber;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(orderNumber) FROM order1");
        resultSet.next();
        orderNumber = resultSet.getInt(1) + 1;
        PreparedStatement statement1 = connection.prepareStatement(INSERT_ORDER);
        for (Product product : products) {
            statement1.setInt(1, orderNumber);
            statement1.setString(2, userLogin);
            statement1.setString(3, product.getArticulate());
            statement1.executeUpdate();
        }
        statement = connection.createStatement();
        resultSet = statement.executeQuery(String.format("SELECT * FROM order1 o WHERE o.orderNumber = '%s'", orderNumber));
        statement1.close();
        statement.close();
        return new Order(resultSet);
    }
}

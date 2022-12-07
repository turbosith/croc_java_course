package ru.croc.Task18;

import java.sql.*;
import java.util.List;

public class DAO {
    private Connection connection;
    private Statement statement;
    private static final String INSERT_ORDER = "INSERT INTO order1 (orderNumber, buyer,articulate) VALUES(?, ?, ?);";
    private static final String INSERT_PRODUCT = "INSERT INTO product (articulate, productName, productPrice) VALUES(?, ?, ?);";

    public DAO(Connection connection){
        this.connection = connection;
    }
    public  Product findProduct(String productCode){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM product p WHERE p.articulate='%s'",productCode));
            return new Product(resultSet);
        } catch (SQLException e) {
            return null;
        }
    }
    public Product createProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
        preparedStatement.setString(1,product.getArticulate() );
        preparedStatement.setString(2, product.getProductName());
        preparedStatement.setInt(3, product.getProductPrice());
        preparedStatement.executeUpdate();
        return product;



    }
    public Product updateProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET articulate=?, productName=?, productPrice=?");
        preparedStatement.setString(1,product.getArticulate() );
        preparedStatement.setString(2, product.getProductName());
        preparedStatement.setInt(3, product.getProductPrice());
        preparedStatement.executeUpdate();
        return product;
    }
    public void deleteProduct(String productCode) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(String.format(
                "DELETE * FROM product p WHERE p.articulate='%s'",productCode));
        statement.executeUpdate();
    }
    public Order createOrder(String userLogin, List<Product> products) throws SQLException {
        int orderNumber;
        statement = connection.createStatement();
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
        resultSet = statement.executeQuery(String.format("SELECT * FROM order1 o WHERE o.orderNumber = '%s'",orderNumber));
        return new Order(resultSet);
    }
}

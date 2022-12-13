package ru.croc.Task18;

import java.sql.*;

public class ProductDAO {
    private final Connection connection;

    private static final String INSERT_PRODUCT = "INSERT INTO product (articulate, productName, productPrice) VALUES(?, ?, ?);";

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public Product findProduct(String productCode) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM product p WHERE p.articulate='%s'", productCode));
            statement.close();
            if (!resultSet.next())
                return null;
            return new Product(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public Product createProduct(Product product) throws SQLException {
        if (findProduct(product.getArticulate()) == null) {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getArticulate());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getProductPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return product;
        } else {
            return null;
        }


    }

    public Product updateProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET articulate=?, productName=?, productPrice=?");
        preparedStatement.setString(1, product.getArticulate());
        preparedStatement.setString(2, product.getProductName());
        preparedStatement.setInt(3, product.getProductPrice());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return product;
    }

    public void deleteProduct(String productCode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(String.format(
                "DELETE * FROM product p WHERE p.articulate='%s'", productCode));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}

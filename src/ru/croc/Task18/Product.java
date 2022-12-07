package ru.croc.Task18;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private int id;
    private  String articulate;
    private String productName;
    private int productPrice;

    public Product(int id, String articulate, String productName, int productPrice) {
        this.id = id;
        this.articulate = articulate;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public Product(ResultSet resultSet) throws SQLException {
        resultSet.next();
        id = resultSet.getInt(1);
        articulate=resultSet.getString(2);
        productName=resultSet.getString(3);
        productPrice=resultSet.getInt(4);


    }

    public int getId() {
        return id;
    }


    public String getArticulate() {
        return articulate;
    }



    public String getProductName() {
        return productName;
    }



    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", articulate=" + articulate +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}

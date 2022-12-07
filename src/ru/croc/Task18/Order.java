package ru.croc.Task18;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    private int id;
    private int orderNumber;
    private String buyer;
    private String articulate;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", buyer='" + buyer + '\'' +
                ", articulate='" + articulate + '\'' +
                '}';
    }

    public Order(int id, int orderNumber, String buyer, String articulate) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.buyer = buyer;
        this.articulate = articulate;
    }

    public int getId() {
        return id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getArticulate() {
        return articulate;
    }
    public Order(ResultSet resultSet) throws SQLException {
        resultSet.next();
        this.id = resultSet.getInt(1);
        this.orderNumber = resultSet.getInt(2);
        this.buyer = resultSet.getString(3);
        this.articulate = resultSet.getString(4);


    }
}

package org.example;

public class OrderDataTest {
    public final String firstname;
    public final String lastname;
    public final String address;
    public final String subwayStation;
    public final String telephone;
    public final String orderDate;
    public final int days;
    public final String color;
    public final String comment;

    public OrderDataTest(String firstname, String lastname, String address,String subwayStation, String telephone, String orderDate, int days, String color, String comment) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.telephone = telephone;
        this.orderDate = orderDate;
        this.days = days;
        this.color = color;
        this.comment = comment;
    }
}
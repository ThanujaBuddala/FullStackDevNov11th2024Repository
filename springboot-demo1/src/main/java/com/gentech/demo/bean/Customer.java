package com.gentech.demo.bean;

public class Customer
{
    private long id;
    private String customerName;
    private String cityName;

    public Customer()
    {

    }
    public Customer(long id, String customerName, String cityName) {
        this.id = id;
        this.customerName = customerName;
        this.cityName = cityName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}

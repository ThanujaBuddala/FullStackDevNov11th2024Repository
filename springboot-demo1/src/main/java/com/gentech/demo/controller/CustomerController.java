package com.gentech.demo.controller;

import com.gentech.demo.bean.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CustomerController
{
    //http://localhost:8084/Customer
    @GetMapping("/Customer")
    public Customer getCustomer()
    {
        return new Customer(101, "Thanuja", "Gangavathi");
    }

    @GetMapping("/Customers")
    public List<Customer> getAllCustomers() {
        List<Customer> obj = new ArrayList<Customer>();
        obj.add(this.getCustomer());
        obj.add(new Customer(102, "Adams", "Tumkur"));
        obj.add(new Customer(103, "James", "Hassan"));
        obj.add(new Customer(104, "Miller", "Kolar"));
        return obj;
    }
}



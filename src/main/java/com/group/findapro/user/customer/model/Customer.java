package com.group.findapro.user.customer.model;

import com.group.findapro.user.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer extends User {

    public Customer(String firstName, String lastName, String login, String password, String emailAddress, long phoneNumber) {
        super(firstName, lastName, login, password, emailAddress, phoneNumber);
    }

    public Customer() {
    }
}

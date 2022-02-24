package com.group.findapro.user.pro_user.model;

import com.group.findapro.user.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Handymen")
public class Handyman extends User {

    public Handyman(String firstName, String lastName, String login, String password, String emailAddress, long phoneNumber) {
        super(firstName, lastName, login, password, emailAddress, phoneNumber);
    }

    public Handyman() {
    }
}

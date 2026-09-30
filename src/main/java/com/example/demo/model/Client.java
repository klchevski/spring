package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private String cardNumber;
    private int balance;

    Client(int id, String name, String lastName, String cardNumber, int balance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    Client() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getBalance() {
        return balance;
    }
}

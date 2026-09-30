package com.example.demo.service;

import com.example.demo.model.Client;

import java.util.List;

public interface ClientService {
    void save(Client client);

    List<Client> getAllClients();

    Integer totalBalanceDiapazon(int min, int max);

    Integer getNullBalanceCount();
}

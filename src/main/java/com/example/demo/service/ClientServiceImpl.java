package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Integer totalBalanceDiapazon(int min, int max) {
        List<Client> allClients = clientRepository.findAll();
        int total = 0;

        for (Client client : allClients) {
            Integer balance = client.getBalance();
            if (balance == null) {
                continue;
            }
            if (balance >= min && balance <= max) {
                total += balance;
            }
        }
        return total;
    }

    @Override
    public Integer getNullBalanceCount() {
        List<Client> allClients = clientRepository.findAll();

        int total = 0;
        for (Client client : allClients) {
            String balance = client.getBalance() + "";
            if (balance.endsWith("0")) {
                total++;
            }
        }

        return total;
    }

    @Override
    public Client getMaxBalance() {
        List<Client> clientsBalance = clientRepository.findAll();
        Client clientMax = null;
        int max = 0;
        for (Client client : clientsBalance) {
            if (max < client.getBalance()) {
                clientMax = client;
                max = client.getBalance();
            }
        }

        return clientMax;
    }
}

package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private ClientService clientService;

    @Autowired
    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("clients/save")
    void save(@RequestBody Client client) {
        clientService.save(client);
    }

    @GetMapping("clients/return")
    List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("clients/totalBalance")
    Integer getTotalBalanceDiapazon(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
        return clientService.totalBalanceDiapazon(min, max);
    }

    @GetMapping("clients/nullBalanceCount")
    Integer getNullBalanceCount() {
        return clientService.getNullBalanceCount();
    }

    @GetMapping("clients/maxBalance")
    Client getMaxBalance() {
        return clientService.getMaxBalance();
    }
}


package com.example.appspring.Services;

import com.example.appspring.Entity.Client;

import java.util.List;

public interface ClientService {
    Client getClientByNom(String nom);
    List<Client> getAllClient();
    Client createClient(Client client);

    Client getClientByID(Long id);
    Client updateClient(Client product);

    void deleteClient(Long id);

}

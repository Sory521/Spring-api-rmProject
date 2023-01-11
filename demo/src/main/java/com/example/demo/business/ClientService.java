package com.example.demo.business;

import com.example.demo.dao.Client;
import com.example.demo.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void CreateClient(Client client){
        clientRepository.save(client);
    }
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientByid(Integer id){
        return clientRepository.findById(id);
    }

    public void updateClient(Integer id, Client client){
        clientRepository.save(client);
    }

    public void deleteClientById(Integer id){
        clientRepository.deleteById(id);
    }
    public void deleteClient(Client client){
        clientRepository.delete(client);
    }
}

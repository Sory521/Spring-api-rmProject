package com.example.demo.api;

// import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.ClientService;
import com.example.demo.dao.Client;

@RestController
@RequestMapping("api")
public class ClientApiController {

    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    public List<Client> getallClients(){
        return clientService.getAllClients();
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<Client>  getClientById(@PathVariable Integer id){
        Optional<Client> optional = clientService.getClientByid(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Client client = optional.get();
            return ResponseEntity.ok(client);
        }
    }

    @PostMapping("clients")
    public void createClient(@RequestBody Client client){
        clientService.CreateClient(client);
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable Integer id){
        Optional<Client> optional = clientService.getClientByid(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Client client = optional.get();
            clientService.deleteClient(client);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody Client client){
        Optional<Client> optional = clientService.getClientByid(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            if(id.equals(client.getId())){
                clientService.updateClient(id, client);
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.badRequest().build();
            }
        }
    }
}
package com.fincas.app.controller.api;

import java.util.List;
import java.util.Optional;

import com.fincas.app.controller.api.exeptions.notFoundException;
import com.fincas.app.controller.api.exeptions.unaceptableException;
import com.fincas.app.crud.clients.clientEntity;
import com.fincas.app.services.clientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*")
public class clientApi {
    @Autowired
    private clientService clientService;

    @GetMapping("/{id}")
    public clientEntity getFarm(@PathVariable long id){
        Optional<clientEntity> exist = clientService.getClientByID(id);
        if(exist.isEmpty()){
            throw new notFoundException("Client with id: " + id+ " not exist");
        }
        return exist.get();
    }

    @PostMapping
    public void addClient(@RequestBody clientEntity body){
        clientEntity exist = clientService.saveClient(body);
        if(exist == null){
            throw new unaceptableException("There is already a client with the id: " + body.getIdClient());
        }
    }

    @GetMapping List<clientEntity> getEveryClients(){
        return clientService.getAllClients();
    }

    @PutMapping
    public void update(@RequestBody clientEntity body){
        clientEntity exsist = clientService.update(body);
        if(exsist == null){
            throw new notFoundException("Client with id: " + body.getIdClient() + " not exist");
        }
    }

    @DeleteMapping
    public void delete(@RequestBody clientEntity body){
        boolean isDeleted = clientService.delete(body.getIdClient());

        if(!isDeleted){
            throw new notFoundException("Client with id: " + body.getIdClient() + "not exist");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void derleteWihtId(@PathVariable long id){
        boolean isDeleted = clientService.delete(id);

        if(!isDeleted){
            throw new notFoundException("Client with id: " + id + "not exist");
        }
    }

    // MinTic requests

    @PostMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClientInAll(@RequestBody clientEntity body){
        clientEntity exist = clientService.saveClient(body);
        if(exist == null){
            throw new unaceptableException("There is already a client with the id: " + body.getIdClient());
        }
    }

    @GetMapping (value = "/all")
    public List<clientEntity> getEveryClientsInAll(){
        return clientService.getAllClients();
    }

    @PutMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateInAll(@RequestBody clientEntity body){
        clientEntity exsist = clientService.update(body);
        if(exsist == null){
            throw new notFoundException("Client with id: " + body.getIdClient() + " not exist");
        }
    }


    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClientInUpdate(@RequestBody clientEntity body){
        clientEntity exist = clientService.saveClient(body);
        if(exist == null){
            throw new unaceptableException("There is already a client with the id: " + body.getIdClient());
        }
    }

    @GetMapping (value = "/update")
    public List<clientEntity> getEveryClientsInUpdate(){
        return clientService.getAllClients();
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateInUpdate(@RequestBody clientEntity body){
        clientEntity exsist = clientService.update(body);
        if(exsist == null){
            throw new notFoundException("Client with id: " + body.getIdClient() + " not exist");
        }
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClientInSave(@RequestBody clientEntity body){
        clientEntity exist = clientService.saveClient(body);
        if(exist == null){
            throw new unaceptableException("There is already a client with the id: " + body.getIdClient());
        }
    }

    @GetMapping (value = "/save")
    public List<clientEntity> getEveryClientsInSave(){
        return clientService.getAllClients();
    }

    @PutMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateInSave(@RequestBody clientEntity body){
        clientEntity exsist = clientService.update(body);
        if(exsist == null){
            throw new notFoundException("Client with id: " + body.getIdClient() + " not exist");
        }
    }
}

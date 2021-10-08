package com.fincas.app.crud.clients;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class clientQuery{
    @Autowired
    private clientRepository clientRep;

    public List<clientEntity> getAllClients(){
        return (List<clientEntity>) clientRep.findAll();
    }
    public Optional<clientEntity> getClientByID(long id){
        return clientRep.findById(id);
    }
    public clientEntity save(clientEntity client){
        return clientRep.save(client);
    }
}

package com.fincas.app.controller.api;

import java.util.List;
import java.util.Optional;

import com.fincas.app.controller.api.exeptions.notFoundException;
import com.fincas.app.controller.api.exeptions.unaceptableException;
import com.fincas.app.crud.messages.messageEntity;
import com.fincas.app.services.messageServie;

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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")
public class messageApi {
    @Autowired
    private messageServie msgService;

    @GetMapping("/{id}")
    public messageEntity getFarm(@PathVariable long id) {
        Optional<messageEntity> exist = msgService.getMessageByID(id);
        if (exist.isEmpty()) {
            throw new notFoundException("Message with id: " + id + " not exist");
        }
        return exist.get();
    }

    @GetMapping
    public List<messageEntity> getEveryMessages() {
        return msgService.getAllMessages();
    }

    @PostMapping
    public void addMessage(@RequestBody messageEntity body) {
        messageEntity exist = msgService.saveMessage(body);
        if (exist == null) {
            throw new unaceptableException("There is already a message with the id: " + body.getIdMessage());
        }
    }

    @PutMapping
    public void updaate(@RequestBody messageEntity body) {
        messageEntity exsist = msgService.update(body);
        if (exsist == null) {
            throw new notFoundException("Message with id: " + body.getIdMessage() + " not exist");
        }
    }

    @DeleteMapping
    public void delete(@RequestBody messageEntity body) {
        boolean isDeleted = msgService.delete(body.getIdMessage());

        if (!isDeleted) {
            throw new notFoundException("Message with id: " + body.getIdMessage() + " not exist");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWihtID(@PathVariable long id) {
        boolean isDeleted = msgService.delete(id);

        if (!isDeleted) {
            throw new notFoundException("Message with id: " + id + " not exist");
        }
    }

    // Mintic Requests

    @GetMapping(value = "/all")
    public List<messageEntity> getEveryMessagesInAll() {
        return msgService.getAllMessages();
    }

    @PostMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessageInAll(@RequestBody messageEntity body) {
        messageEntity exist = msgService.saveMessage(body);
        if (exist == null) {
            throw new unaceptableException("There is already a message with the id: " + body.getIdMessage());
        }
    }

    @PutMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void updaateInAll(@RequestBody messageEntity body) {
        messageEntity exsist = msgService.update(body);
        if (exsist == null) {
            throw new notFoundException("Message with id: " + body.getIdMessage() + " not exist");
        }
    }

    @GetMapping(value = "/update")
    public List<messageEntity> getEveryMessagesInUpdate() {
        return msgService.getAllMessages();
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessageInUpdate(@RequestBody messageEntity body) {
        messageEntity exist = msgService.saveMessage(body);
        if (exist == null) {
            throw new unaceptableException("There is already a message with the id: " + body.getIdMessage());
        }
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updaateInUpdate(@RequestBody messageEntity body) {
        messageEntity exsist = msgService.update(body);
        if (exsist == null) {
            throw new notFoundException("Message with id: " + body.getIdMessage() + " not exist");
        }
    }

    @GetMapping(value = "/save")
    public List<messageEntity> getEveryMessagesInSave() {
        return msgService.getAllMessages();
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessageInSave(@RequestBody messageEntity body) {
        messageEntity exist = msgService.saveMessage(body);
        if (exist == null) {
            throw new unaceptableException("There is already a message with the id: " + body.getIdMessage());
        }
    }

    @PutMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void updaateInSave(@RequestBody messageEntity body) {
        messageEntity exsist = msgService.update(body);
        if (exsist == null) {
            throw new notFoundException("Message with id: " + body.getIdMessage() + " not exist");
        }
    }
}

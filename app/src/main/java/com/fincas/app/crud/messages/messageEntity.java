package com.fincas.app.crud.messages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGES")
public class messageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageText;

    public messageEntity(String messageText) {
        this.messageText = messageText;
    }
    
    /** Empty constructor */
    public messageEntity(){}

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}

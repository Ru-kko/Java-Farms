package com.fincas.app.crud.clientScore;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fincas.app.crud.messages.messageEntity;

@Entity
@Table(name = "SCORE")
public class scoreEntity {
    
    @OneToOne
    private messageEntity message;
}

package com.fincas.app.crud.reservations;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fincas.app.crud.clients.clientEntity;
import com.fincas.app.crud.farms.farmEntity;

@Entity
@Table(name="RESERVATIONS")
public class reservationEntity {
    
    @ManyToOne
    private clientEntity client;
    @ManyToOne
    private farmEntity farm;

    private Date fristDate;
    private Date lastDate;
    
    public clientEntity getClient() {
        return client;
    }
    public void setClient(clientEntity client) {
        this.client = client;
    }
    public farmEntity getFarm() {
        return farm;
    }
    public void setFarm(farmEntity farm) {
        this.farm = farm;
    }
    public Date getFristDate() {
        return fristDate;
    }
    public void setFristDate(Date fristDate) {
        this.fristDate = fristDate;
    }
    public Date getLastDate() {
        return lastDate;
    }
    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}

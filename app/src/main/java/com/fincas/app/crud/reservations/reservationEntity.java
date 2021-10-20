package com.fincas.app.crud.reservations;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fincas.app.crud.clients.clientEntity;
import com.fincas.app.crud.farms.farmEntity;

@Entity
@Table(name="RESERVATIONS")
public class reservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    
    private Date startDate;
    private Date devolutionDate;
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private farmEntity farm;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private clientEntity client;

    public reservationEntity(clientEntity client, farmEntity farm, Date fristDate, Date devolutionDate) {
        this.client = client;
        this.farm = farm;
        this.startDate = fristDate;
        this.devolutionDate = devolutionDate;
    }
    /** Empty constructor */
    public reservationEntity(){}

    public Long getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}

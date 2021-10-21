package com.fincas.app.crud.reservations;

import java.sql.Timestamp;

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
    
    private Timestamp startDate;
    private Timestamp devolutionDate;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private farmEntity farm;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private clientEntity client;

    private Float score;

    public reservationEntity(clientEntity client, farmEntity farm, Timestamp fristDate, Timestamp devolutionDate) {
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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Float getScore() {
        return score;
    }
    public void setScore(Float score) {
        this.score = score;
    }
    public Timestamp getStartDate() {
        return startDate;
    }
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
    public Timestamp getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Timestamp devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}

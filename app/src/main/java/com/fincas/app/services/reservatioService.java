package com.fincas.app.services;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fincas.app.crud.reservations.reservationEntity;
import com.fincas.app.crud.reservations.reservationQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class reservatioService {
    @Autowired
    private reservationQuery resRep;

    public List<reservationEntity> getAllReservations(){
        return resRep.getAllReservations();
    }

    public List<reservationEntity> getReservationsByClientAndFarm(long farm, long client){
        return resRep.getReservationsByClientAndFarm(farm, client);
    }

    public Optional<reservationEntity> getReservationById(long id){
        return resRep.getReservationById(id);
    }

    public reservationEntity saveReservation(reservationEntity reservation){
        if(reservation.getIdReservation() != null){
            Optional<reservationEntity> opReserv = resRep.getReservationById(reservation.getIdReservation());
            if(opReserv.isEmpty()){
                return resRep.save(reservation);        
            }
            return null;
        }
        return resRep.save(reservation);
    }

    public reservationEntity update(reservationEntity reservation){
        if(reservation.getIdReservation() != null){
            Optional<reservationEntity> opReserv = resRep.getReservationById(reservation.getIdReservation());

            if(opReserv.isPresent()){
                reservationEntity thisReserv = opReserv.get();
                if(reservation.getClient() != null){
                    thisReserv.setClient(reservation.getClient());
                }
                if(reservation.getFarm() != null){
                    thisReserv.setFarm(reservation.getFarm());
                }
                if(reservation.getStartDate() != null){
                    thisReserv.setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate() != null){
                    thisReserv.setDevolutionDate(reservation.getDevolutionDate());
                }
                return resRep.save(thisReserv);
            }
        }
        return null;
    }

    public Boolean delete(long id){
        Boolean isDeleted = this.resRep.getReservationById(id).map(res ->{
            resRep.delete(res);
            return true;
        }).orElse(false);
        return isDeleted;
    }

    public Map<String, BigInteger> getStatusCount(){
        Map<String, BigInteger> map = new HashMap<>();

        for (Object[] i : resRep.getStatusCount()){
            map.put((String)i[0] , (BigInteger) i[1]);
        }

        return map;
    }
}
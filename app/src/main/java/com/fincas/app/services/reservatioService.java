package com.fincas.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fincas.app.crud.Reports.clietnCounter;
import com.fincas.app.crud.Reports.status;
import com.fincas.app.crud.clients.clientEntity;
import com.fincas.app.crud.reservations.reservationEntity;
import com.fincas.app.crud.reservations.reservationQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reservatioService {
    @Autowired
    private reservationQuery resRep;

    public List<reservationEntity> getAllReservations() {
        return resRep.getAllReservations();
    }

    public List<reservationEntity> getReservationsByClientAndFarm(long farm, long client) {
        return resRep.getReservationsByClientAndFarm(farm, client);
    }

    public Optional<reservationEntity> getReservationById(long id) {
        return resRep.getReservationById(id);
    }

    public reservationEntity saveReservation(reservationEntity reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<reservationEntity> opReserv = resRep.getReservationById(reservation.getIdReservation());
            if (opReserv.isEmpty()) {
                return resRep.save(reservation);
            }
            return null;
        }
        return resRep.save(reservation);
    }

    public reservationEntity update(reservationEntity reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<reservationEntity> opReserv = resRep.getReservationById(reservation.getIdReservation());

            if (opReserv.isPresent()) {
                reservationEntity thisReserv = opReserv.get();
                if (reservation.getClient() != null) {
                    thisReserv.setClient(reservation.getClient());
                }
                if (reservation.getFarm() != null) {
                    thisReserv.setFarm(reservation.getFarm());
                }
                if (reservation.getStartDate() != null) {
                    thisReserv.setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    thisReserv.setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    thisReserv.setStatus(reservation.getStatus());
                }
                return resRep.save(thisReserv);
            }
        }
        return null;
    }

    public Boolean delete(long id) {
        Boolean isDeleted = this.resRep.getReservationById(id).map(res -> {
            resRep.delete(res);
            return true;
        }).orElse(false);
        return isDeleted;
    }

    public status getStatus() {
        int completed = resRep.getStatusCount("completed").size();
        int cancelled = resRep.getStatusCount("cancelled").size();

        return new status(completed, cancelled);
    }

    public List<clietnCounter> reportClientStatus() {
        List<clietnCounter> response = new ArrayList<>();
        List<Object[]> report = resRep.countTotalReservations();

        for (Object[] i : report) {
            response.add(new clietnCounter((long) i[0], (clientEntity) i[1]));
        }

        return response;
    }

    public List<reservationEntity> timeReport(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return resRep.getReservationEntitieBetwent(datoUno, datoDos);
        } else {
            return new ArrayList<>();

        }
    }
}

// public List<Reservacion> reporteTiempoServicio (String datoA, String datoB){
// SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");

// Date datoUno = new Date();
// Date datoDos = new Date();

// try{
// datoUno = parser.parse(datoA);
// datoDos = parser.parse(datoB);
// }catch(ParseException evt){
// evt.printStackTrace();
// }if(datoUno.before(datoDos)){
// return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
// }else{
// return new ArrayList<>();

// }
// }
// public List<ContadorClientes> reporteClientesServicio(){
// return metodosCrud.getClientesRepositorio();
// }

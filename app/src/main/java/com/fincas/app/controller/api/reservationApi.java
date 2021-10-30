package com.fincas.app.controller.api;

import java.util.List;
import java.util.Optional;

import com.fincas.app.controller.api.exeptions.notFoundException;
import com.fincas.app.controller.api.exeptions.unaceptableException;
import com.fincas.app.crud.Reports.clietnCounter;
import com.fincas.app.crud.Reports.status;
import com.fincas.app.crud.reservations.reservationEntity;
import com.fincas.app.services.reservatioService;

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
@RequestMapping("/api/Reservation")
@CrossOrigin("*")
public class reservationApi {
    @Autowired
    private reservatioService reservService;

    @GetMapping("/{id}")
    public reservationEntity getReservation(@PathVariable long id) {
        Optional<reservationEntity> exist = reservService.getReservationById(id);
        if (exist.isEmpty()) {
            throw new notFoundException("Reservation with id: " + id + "not exist");
        }
        return exist.get();
    }

    @GetMapping
    public List<reservationEntity> getEveryReservations() {
        return reservService.getAllReservations();
    }

    @PostMapping
    public void addReservation(@RequestBody reservationEntity body) {
        reservationEntity exist = reservService.saveReservation(body);
        if (exist == null) {
            throw new unaceptableException("There is already a Reservation with the id: " + body.getIdReservation());
        }
    }

    @PutMapping
    public void update(@RequestBody reservationEntity body) {
        reservationEntity exsist = reservService.update(body);
        if (exsist == null) {
            throw new notFoundException("Resevation with id: " + body.getIdReservation() + "not exist");
        }
    }

    @DeleteMapping
    public void delete(@RequestBody reservationEntity body) {
        boolean isDeleted = reservService.delete(body.getIdReservation());

        if (!isDeleted) {
            throw new notFoundException("Reservation with id: " + body.getIdReservation() + "not exist");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteWihtId(@PathVariable long id) {
        boolean isDeleted = reservService.delete(id);

        if (!isDeleted) {
            throw new notFoundException("Reservation with id: " + id + "not exist");
        }
    }

    // Mintic requests
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<reservationEntity> getReservasTiempo(@PathVariable("dateOne") String dateOne,
                @PathVariable("dateTwo") String dateTwo) {
        return reservService.timeReport(dateOne, dateTwo);
    }

    @GetMapping(value = "/report-status")
    public status getStatusCount() {
        return this.reservService.getStatus();
    }

    @GetMapping(value = "/report-clients")
    public List<clietnCounter> reportClientStatus() {
        return reservService.reportClientStatus();
    }

    @GetMapping(value = "/all")
    public List<reservationEntity> getEveryReservationsInAll() {
        return reservService.getAllReservations();
    }

    @PostMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservationInAll(@RequestBody reservationEntity body) {
        reservationEntity exist = reservService.saveReservation(body);
        if (exist == null) {
            throw new unaceptableException("There is already a Reservation with the id: " + body.getIdReservation());
        }
    }

    @PutMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateInAll(@RequestBody reservationEntity body) {
        reservationEntity exsist = reservService.update(body);
        if (exsist == null) {
            throw new notFoundException("Resevation with id: " + body.getIdReservation() + "not exist");
        }
    }

    @GetMapping(value = "/update")
    public List<reservationEntity> getEveryReservationsInUpdate() {
        return reservService.getAllReservations();
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservationInUpdate(@RequestBody reservationEntity body) {
        reservationEntity exist = reservService.saveReservation(body);
        if (exist == null) {
            throw new unaceptableException("There is already a Reservation with the id: " + body.getIdReservation());
        }
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateInUpdate(@RequestBody reservationEntity body) {
        reservationEntity exsist = reservService.update(body);
        if (exsist == null) {
            throw new notFoundException("Resevation with id: " + body.getIdReservation() + "not exist");
        }
    }

    @GetMapping(value = "/save")
    public List<reservationEntity> getEveryReservationsInSave() {
        return reservService.getAllReservations();
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservationInSave(@RequestBody reservationEntity body) {
        reservationEntity exist = reservService.saveReservation(body);
        if (exist == null) {
            throw new unaceptableException("There is already a Reservation with the id: " + body.getIdReservation());
        }
    }

    @PutMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateInSave(@RequestBody reservationEntity body) {
        reservationEntity exsist = reservService.update(body);
        if (exsist == null) {
            throw new notFoundException("Resevation with id: " + body.getIdReservation() + "not exist");
        }
    }
}
